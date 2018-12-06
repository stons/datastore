package vip.codemonkey.datastore.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;

public interface QueryDslRepository<T extends LongIdEntity,Long> extends JpaRepository<T,Long>, QuerydslPredicateExecutor<T> {
}
