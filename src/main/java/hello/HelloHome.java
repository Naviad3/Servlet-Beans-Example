package hello;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;


public interface HelloHome extends EJBHome {

    public HelloRemote create() throws RemoteException;

}
