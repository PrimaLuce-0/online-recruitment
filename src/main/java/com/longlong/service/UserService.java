package com.longlong.service;

import com.longlong.entity.User;
import com.longlong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    public User queryUserByUsername(String username)
    {
        return userMapper.queryUserByUsername((username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.queryUserByUsername(username);
        //System.out.println(user.getUsername());
        return user;
    }

    public List<User> queryAllUser(){
        return userMapper.queryAllUser();
    }
    public int deleteUser(int userid){
        return userMapper.deleteUser(userid);
    }
    public User queryUserByUserid(int userid){
        return userMapper.queryUserByUserid(userid);
    }
}
