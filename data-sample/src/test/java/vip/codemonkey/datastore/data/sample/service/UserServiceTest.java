package vip.codemonkey.datastore.data.sample.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vip.codemonkey.datastore.data.jpa.repository.BaseDataTestCase;
import vip.codemonkey.datastore.data.sample.entity.User;
import vip.codemonkey.datastore.data.sample.repository.UserRepository;

public class UserServiceTest extends BaseDataTestCase {

    @Autowired
    UserService service;
    @Autowired
    UserRepository repository;

    @Test
    public void testGetOne(){
        User user = service.getOneById(-1L);
        logger.info("user is {}",user.getName());
        logger.info("repository query user is {}",user);
    }
}
