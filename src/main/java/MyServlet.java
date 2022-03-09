import hello.HelloLocal;
import hello.HelloLocalHome;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.ejb.*;
import javax.naming.*;


@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet extends HttpServlet {
    HelloLocalHome helloHome;
    HelloLocal hello;

    public void init() throws ServletException
    {
        try {


            // 1. Retrieve the Home Interface using a JNDI Lookup
            // Retrieve the initial context for JNDI.       // No properties needed when local
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.apache.openejb.core.LocalInitialContextFactory");
            Context ctx = new InitialContext(props);

            // Retrieve the home interface using a JNDI lookup using
            // the java:comp/env bean environment variable        // specified in web.xml
            helloHome = (HelloLocalHome) ctx.lookup("ejb/HelloBeanLocalHome");
            System.out.println(helloHome);

            //2. Narrow the returned object to be an HelloHome object.      // Since the client is local, cast it to the correct object type.
            //3. Create the local Hello bean instance, return the reference
            hello = (HelloLocal)helloHome.create();

        } catch(NamingException e) {
            throw new ServletException("Error looking up home", e);
        }// catch(CreateException e) {
           // throw new ServletException("Error creating local hello bean", e);
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream out = response.getOutputStream();
        try
        {
            out.println("<html>");
            out.println("<body>");
            //4. Invoke a business method on the local interface reference.
            out.println(hello.sayHello());
            out.println("</body>");
            out.println("</html>");
        } catch(EJBException e) {
            out.println("EJBException error: " + e.getMessage());
        } catch(IOException e) {
            out.println("IOException error: " + e.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
