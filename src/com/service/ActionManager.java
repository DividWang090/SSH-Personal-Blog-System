package com.service;
import java.util.List;
public interface ActionManager {
	/**
     * 根据用户名，密码验证登录是否成功
     * @param username 登录所输入的用户名
     * @param password 登录的密码
     */
    Integer validLogin(String username , String password);  
    
    String getcontent(int id);
    List getBlogList();
    void saveBlog(String title, String content);
    
    List getMessageList();
    void saveMessage(String name,String content);
    void deleteBlog(Integer id);
    void updateUser(String password);
}
