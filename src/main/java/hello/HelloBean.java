package hello;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloBean implements SessionBean {
    @Override
    public void ejbActivate() throws EJBException {
    }

    @Override
    public void ejbPassivate() throws EJBException {
    }

    @Override
    public void ejbRemove() throws EJBException {
    }

    @Override
    public void setSessionContext(SessionContext arg0) throws EJBException {
    }

    // used for creating a reference to RemoteInterface
    public void ejbCreate () throws CreateException {
        System.out.println("ejb local - create");
    }

    // Our business method which client will call
    public String sayHello() throws CreateException {
        return "Hello World by EJB 2.x HelloBean...";
    }
}
