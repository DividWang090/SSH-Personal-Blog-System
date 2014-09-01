package com.action;

import java.util.List;
import com.domain.Blog;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class DeleteBlogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionManager mgr;
	private Integer id;	
	private List<Blog> blogList;
	
	public String execute() throws Exception{
		this.setBlogList(mgr.getBlogList());
		mgr.deleteBlog(getId());
		this.setBlogList(getMgr().getBlogList());
		
		return "SUCCESS";
	}

	public ActionManager getMgr() {
		return mgr;
	}

	public void setMgr(ActionManager mgr) {
		this.mgr = mgr;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
