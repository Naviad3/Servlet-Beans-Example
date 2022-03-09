package hello;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;

public class HelloRemoteBean implements SessionBean {
    @Override
    public void ejbActivate() throws EJBException, RemoteException {
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
    }

    @Override
    public void setSessionContext(SessionContext arg0) throws EJBException,
            RemoteException {
    }

    // used for creating a reference to RemoteInterface
    public void ejbCreate () throws CreateException {
        System.out.println("ejb remote - create");
    }

    // Our business method which client will call
    public String sayHello() throws CreateException {
        return "Hello World by EJB 2.x Hello RemoteBean...";
    }
}
