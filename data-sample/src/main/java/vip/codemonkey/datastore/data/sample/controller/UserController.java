package vip.codemonkey.datastore.data.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.codemonkey.datastore.data.sample.entity.User;
import vip.codemonkey.datastore.data.sample.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService service;
    @GetMapping("detail/{id}")
    public User detail(@PathVariable Long id ){
        User oneById = service.getOneById(id);
        logger.info("detail user id is {} info is {}",id,oneById);
        return oneById;
    }
}
