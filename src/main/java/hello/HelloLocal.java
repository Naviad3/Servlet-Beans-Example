package hello;

import javax.ejb.EJBLocalObject;

public interface HelloLocal extends EJBLocalObject{
    public String sayHello();
}
