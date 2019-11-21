package com.braisedpanda.web.service.impl;

import com.braisedpanda.commons.model.User;
import com.braisedpanda.web.mapper.UserMapper;
import com.braisedpanda.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: admin-dashboard
 * @description:

 * @create: 2019-11-21 12:00
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> userlist = userMapper.selectByExample(example);
        if(userlist.size() > 0){
            return userlist.get(0);
        }
        return null;
    }
}
