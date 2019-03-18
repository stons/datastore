package vip.codemonkey.datastore.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface QueryDslRepository<T extends LongIdEntity,Long> extends JpaRepository<T,Long>, QuerydslPredicateExecutor<T> {
    /**
     * 根据ID in 查询
     * @param ids id集合
     */
    Optional<List<T>> findByIdIn(List<Long> ids);

    /**
     * time < 创建时间
     * @param createdAtStart 时间
     */
    Optional<List<T>> findByCreatedAtAfter(Date createdAtStart);

    /**
     * time > 创建时间
     * @param createdAtEnd 时间
     */
    Optional<List<T>> findByCreatedAtBefore(Date createdAtEnd);

    /**
     * time < 修改时间
     * @param updatedAtStart 时间
     */
    Optional<List<T>> findByUpdatedAtAfter(Date updatedAtStart);

    /**
     * time > 修改时间
     * @param updatedAtEnd 时间
     */
    Optional<List<T>> findByUpdatedAtBefore(Date updatedAtEnd);
}
