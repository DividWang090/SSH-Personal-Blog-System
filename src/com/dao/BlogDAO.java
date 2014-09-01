package com.dao;

import java.util.List;
import com.domain.Blog;

public interface BlogDAO {
	/**
     * 根据id查找blog
     * @param id 需要查找的blog id
     */  
    Blog get(Integer id);
    Blog findBlogById(String id);
    List getBlogList();
    void save(Blog blog);
    void deleteBlog(Integer id);
    
}
