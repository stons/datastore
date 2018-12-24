package vip.codemonkey.datastore.data.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.codemonkey.datastore.data.jpa.utils.JPAUtil;
import vip.codemonkey.datastore.data.sample.entity.User;
import vip.codemonkey.datastore.data.sample.repository.UserRepository;

@Service
@Transactional
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository repository;

    public User getOneById(Long id ){
        User one = repository.getOne(id);
//        logger.info("user getOneById result is {}",one);
//JPAUtil.initializeAndUnproxy(one)
        return JPAUtil.initializeAndUnproxy(one);
    }
}
