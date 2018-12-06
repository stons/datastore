package vip.codemonkey.datastore.data.sample.repository;

import com.querydsl.core.BooleanBuilder;
import vip.codemonkey.datastore.data.jpa.entity.QLongIdEntity;
import vip.codemonkey.datastore.data.jpa.repository.QueryDslRepository;
import vip.codemonkey.datastore.data.sample.condition.UserCondition;
import vip.codemonkey.datastore.data.sample.entity.QUser;
import vip.codemonkey.datastore.data.sample.entity.User;

import java.util.Objects;

public interface UserRepository extends QueryDslRepository<User,Long> {
    default BooleanBuilder predicateByCondition(UserCondition condition){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QUser qUser = QUser.user;
        if(Objects.nonNull(condition.getName())){
            booleanBuilder.and(qUser.name.like(condition.getName()));
        }
        if(Objects.nonNull(condition.getId())){
            booleanBuilder.and(qUser.id.eq(condition.getId()));
        }
        return booleanBuilder;
    }
}
