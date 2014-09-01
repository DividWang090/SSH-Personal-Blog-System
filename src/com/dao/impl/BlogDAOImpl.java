package com.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BlogDAO;
import com.domain.Blog;

public class BlogDAOImpl extends HibernateDaoSupport implements BlogDAO {
	public Blog get(Integer id)
    {
        return (Blog)getHibernateTemplate().get(Blog.class , id);
    }
	
    public Blog findBlogById(String title)
    {
        String[] args = {title};
        List ul = getHibernateTemplate().find("from Users au where au.id = ? " , args);
        
        return (Blog)ul.get(0);
    }

	@Override
	public List getBlogList() {
		// TODO Auto-generated method stub
        return getHibernateTemplate().find("from Blog order by id desc");
	}
    public void save(Blog blog)
    {
        getHibernateTemplate().save(blog);
    }

	@Override
	public void deleteBlog(Integer id) {
		// TODO Auto-generated method stub
        getHibernateTemplate().delete(getHibernateTemplate().get(Blog.class , id));

	}
}
