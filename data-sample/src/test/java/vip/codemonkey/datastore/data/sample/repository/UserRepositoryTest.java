package vip.codemonkey.datastore.data.sample.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vip.codemonkey.datastore.data.jpa.repository.BaseDataTestCase;
import vip.codemonkey.datastore.data.sample.condition.UserCondition;
import vip.codemonkey.datastore.data.sample.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class UserRepositoryTest extends BaseDataTestCase {

    @Autowired
    UserRepository repository;

    @Test
    public void testFindById(){
        Optional<User> optionalUser = repository.findById(-1L);
        Assert.assertTrue(optionalUser.isPresent());
        logger.info("test find by id result is {}",optionalUser.get());
    }

    @Test
    public void testFindByCondition(){
        UserCondition condition = new UserCondition();
        condition.setName("test1");
        Iterable<User> userIterable = repository.findAll(repository.predicateByCondition(condition));
        Assert.assertTrue(userIterable.iterator().hasNext());
        logger.info("test find by condition result is {}",userIterable.iterator().next().getId());

        condition.setId(-2L);
        condition.setCreatedAtStart(LocalDateTime.parse("2018-12-06 14:45:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Iterable<User> userIterableByNameAndId = repository.findAll(repository.predicateByCondition(condition));
        Assert.assertTrue(!userIterableByNameAndId.iterator().hasNext());

    }


}
