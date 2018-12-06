package vip.codemonkey.datastore.data.sample.repository;

import com.querydsl.core.BooleanBuilder;
import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;
import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;
import vip.codemonkey.datastore.data.jpa.entity.QLongIdEntity;
import vip.codemonkey.datastore.data.jpa.repository.QueryDslRepository;
import vip.codemonkey.datastore.data.sample.condition.UserCondition;
import vip.codemonkey.datastore.data.sample.entity.QUser;

import java.util.Objects;

public class BaseLongIdEntityBuilder  {
    public static  BooleanBuilder predicateByCondition(LongIdCondition condition){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QLongIdEntity qLongIdEntity = QLongIdEntity.longIdEntity;
        if(Objects.nonNull(condition.getId())){
            booleanBuilder.and(qLongIdEntity.id.eq(condition.getId()));
        }
        return booleanBuilder;
    }
}
