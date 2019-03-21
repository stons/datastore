package vip.codemonkey.datastore.data.sample.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;
import vip.codemonkey.datastore.data.jpa.entity.QLongIdEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class BaseLongIdEntityBuilder  {
    public static  BooleanBuilder predicateByCondition(LongIdCondition condition, Path<? extends LongIdEntity> path){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QLongIdEntity qLongIdEntity = new QLongIdEntity(path);
        Long id = condition.getId();
        if (Objects.nonNull(id)) {
            booleanBuilder.and(qLongIdEntity.id.eq(id));
        }
        List<Long> ids = condition.getIds();
        if (Objects.nonNull(ids) && !ids.isEmpty()) {
            booleanBuilder.and(qLongIdEntity.id.in(ids));
        }
        LocalDateTime createdAtStart = condition.getCreatedAtStart();
        LocalDateTime createdAtEnd = condition.getCreatedAtEnd();
        if (Objects.nonNull(createdAtStart) && Objects.nonNull(createdAtEnd)) {
            booleanBuilder.and(qLongIdEntity.createdAt.between(createdAtStart, createdAtEnd));
        } else {
            if (Objects.nonNull(createdAtStart)) {
                booleanBuilder.and(qLongIdEntity.createdAt.goe(createdAtStart));
            }
            if (Objects.nonNull(createdAtEnd)) {
                booleanBuilder.and(qLongIdEntity.updatedAt.loe(createdAtEnd));
            }
        }

        LocalDateTime updatedAtStart = condition.getUpdatedAtStart();
        LocalDateTime updatedAtEnd = condition.getUpdatedAtEnd();
        if (Objects.nonNull(updatedAtStart) && Objects.nonNull(updatedAtEnd)) {
            booleanBuilder.and(qLongIdEntity.updatedAt.between(updatedAtStart, updatedAtEnd));
        } else {
            if (Objects.nonNull(updatedAtStart)) {
                booleanBuilder.and(qLongIdEntity.updatedAt.goe(updatedAtStart));
            }
            if (Objects.nonNull(updatedAtEnd)) {
                booleanBuilder.and(qLongIdEntity.updatedAt.loe(updatedAtEnd));
            }
        }
        return booleanBuilder;
    }

}
