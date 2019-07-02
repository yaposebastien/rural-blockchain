package com.civruralblockchain.webapp.dao;

import com.civruralblockchain.webapp.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
