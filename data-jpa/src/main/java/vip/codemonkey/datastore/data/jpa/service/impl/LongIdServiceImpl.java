package vip.codemonkey.datastore.data.jpa.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;
import vip.codemonkey.datastore.data.jpa.repository.QueryDslRepository;
import vip.codemonkey.datastore.data.jpa.service.LongIdService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:43
 * @description
 */
public abstract class LongIdServiceImpl<T extends LongIdEntity, C extends LongIdCondition> implements LongIdService<T, C> {
    private static final Logger logger = LoggerFactory.getLogger(LongIdServiceImpl.class);
    @Autowired
    protected QueryDslRepository<T, Long> repository;

    @Override
    public T get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> save(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    public void remove(Iterable<T> entities) {
        repository.deleteAll(entities);
    }
    @Override
    public List<T> findByIdIn(List<Long> ids) {
        return repository.findByIdIn(ids).orElse(new ArrayList<>());
    }
}
