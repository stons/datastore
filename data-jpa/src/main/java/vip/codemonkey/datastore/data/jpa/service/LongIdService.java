package vip.codemonkey.datastore.data.jpa.service;

import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:39
 * @description
 */
public interface LongIdService<T extends LongIdEntity, C extends LongIdCondition> {
    public T get(Long id);

    public List<T> getAll();

    public T save(T entity);

    public List<T> save(Iterable<T> entities);

    public void remove(Long id);

    public void remove(T entity);

    public void remove(Iterable<T> entities);

    List<T> findByIdIn(List<Long> ids);

}
