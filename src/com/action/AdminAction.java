package com.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;
import com.domain.Blog;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ActionManager mgr;
	private List<Blog> blogList;

	public String execute()throws Exception{
		this.setBlogList(getMgr().getBlogList());
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("username") == null) {
			return "LOGIN";
		}
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
}
