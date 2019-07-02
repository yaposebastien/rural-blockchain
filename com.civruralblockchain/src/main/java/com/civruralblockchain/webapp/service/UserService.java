package com.civruralblockchain.webapp.service;

import com.civruralblockchain.webapp.entity.User;
import com.civruralblockchain.webapp.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
          
    }
  
