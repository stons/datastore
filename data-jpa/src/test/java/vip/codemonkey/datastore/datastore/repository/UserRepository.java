package vip.codemonkey.datastore.datastore.repository;

import com.querydsl.core.BooleanBuilder;
import vip.codemonkey.datastore.datastore.condition.UserCondition;
import vip.codemonkey.datastore.datastore.entity.User;

public interface UserRepository extends QueryDslRepository<User,Long> {
    default BooleanBuilder queryAll(UserCondition condition){
        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        booleanBuilder.and()
        return booleanBuilder;
    }
}
