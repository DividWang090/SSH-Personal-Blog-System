package com.dao;

import java.util.List;
import com.domain.Users;

public interface UserDAO {
	/**
     * 根据id查找用户
     * @param id 需要查找的用户id
     */  
    Users get(Integer id);
    /**
     * 增加用户
     * @param user 需要增加的用户
     */       
    void save(Users user);

    /**
     * 修改用户
     * @param user 需要修改的用户
     */  
    void update(Users user);

    /**
     * 删除用户
     * @param id 需要删除的用户id
     */  
    void delete(Integer id);

    /**
     * 删除用户
     * @param user 需要删除的用户
     */  
    void delete(Users user);

    /**
     * 查询全部用户
     * @return 获得全部用户
     */ 
    List<Users> findAll();

    /**
     * 根据用户名，密码查找用户
     * @param username 查询所需的用户名
     * @param pass 查询所需的密码
     * @return 对应的用户
     */ 
    Users findUserByNameAndPass(String username , String password);
}
