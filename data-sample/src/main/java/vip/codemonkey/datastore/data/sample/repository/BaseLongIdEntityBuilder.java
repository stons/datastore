package vip.codemonkey.datastore.data.sample.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;
import vip.codemonkey.datastore.data.jpa.entity.QLongIdEntity;

import java.util.Objects;

public class BaseLongIdEntityBuilder  {
    public static  BooleanBuilder predicateByCondition(LongIdCondition condition, Path<? extends LongIdEntity> path){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QLongIdEntity qLongIdEntity = new QLongIdEntity(path);
        if(Objects.nonNull(condition.getId())){
            booleanBuilder.and(qLongIdEntity.id.eq(condition.getId()));
        }
        if(Objects.nonNull(condition.getCreatedAt())){
            booleanBuilder.and(qLongIdEntity.createdAt.after(condition.getCreatedAt()));
        }
        return booleanBuilder;
    }

}
