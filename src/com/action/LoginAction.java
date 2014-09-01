package com.action;

import java.util.List;
import java.util.Map;

import com.domain.Blog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected ActionManager mgr;
	private String username;
	private String password;
	private List<Blog> blogList;

	public String execute() throws Exception {
		this.setBlogList(mgr.getBlogList());
		if (username.equals("") || username == null) {
			return "input";
		}
		Integer userId = mgr.validLogin(username, password);
		if (userId != null) {
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("username", username);
			return SUCCESS;
		} else {
			addActionError("用户名/密码不匹配");
			return "input";
		}
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMgr(ActionManager mgr) {
		this.mgr = mgr;
	}

	public ActionManager getMgr() {
		return mgr;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}
}
