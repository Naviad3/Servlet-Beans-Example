package hello;

import javax.ejb.EJBLocalHome;

public interface HelloLocalHome extends EJBLocalHome {
    public HelloLocal create();
}
