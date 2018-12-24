package vip.codemonkey.datastore.data.jpa.utils;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

public class JPAUtil {
    public static  <T> T initializeAndUnproxy(T entity){
        if (Objects.isNull(entity)) {
            return entity;
        }
        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
