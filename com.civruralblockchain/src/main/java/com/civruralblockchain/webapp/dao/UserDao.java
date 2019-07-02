package com.civruralblockchain.webapp.dao;

import com.civruralblockchain.webapp.entity.User;


public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
    
}
