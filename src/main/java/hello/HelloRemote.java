package hello;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface HelloRemote extends EJBObject {

    public String sayHello() throws RemoteException;

}
