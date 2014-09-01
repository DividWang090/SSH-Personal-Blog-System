package com.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.dao.UserDAO;
import com.domain.Users;
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	/**
     * 根据id查找用户
     * @param id 需要查找的用户id
     */  
    public Users get(Integer id)
    {
        return (Users)getHibernateTemplate().get(Users.class , id);
    }
    /**
     * 增加用户
     * @param user 需要增加的用户
     */       
    public void save(Users user)
    {
        getHibernateTemplate().save(user);
    }

    /**
     * 修改用户
     * @param user 需要修改的用户
     */  
    public void update(Users user)
    {
        getHibernateTemplate().saveOrUpdate(user);
    }

    /**
     * 删除用户
     * @param id 需要删除的用户id
     */  
    public void delete(Integer id)
    {
        getHibernateTemplate().delete(getHibernateTemplate().get(Users.class , id));
    }

    /**
     * 删除用户
     * @param user 需要删除的用户
     */  
    public void delete(Users user)
    {
        getHibernateTemplate().delete(user);
    }

    /**
     * 查询全部用户
     * @return 获得全部用户
     */ 
    public List findAll()
    {
        return getHibernateTemplate().find("from Users");
    }

    /**
     * 根据用户名，密码查找用户
     * @param username 查询所需的用户名
     * @param pass 查询所需的密码
     * @return 对应的用户
     */ 
    public Users findUserByNameAndPass(String username , String pass)
    {
        String[] args = {username , pass};
        List ul = getHibernateTemplate().find("from Users au where au.username = ? and au.password = ?" , args);
        if (ul.size() == 1)
        {
            return (Users)ul.get(0);
        }
        return null;
    }
}