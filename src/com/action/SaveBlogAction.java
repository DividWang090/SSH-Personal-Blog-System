package com.action;

import java.util.List;
import java.util.Map;
import com.domain.Blog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class SaveBlogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private ActionManager mgr;
	private String title;
	private String content;
	private List<Blog> blogList;
	
	public String execute() throws Exception{
		this.blogList=mgr.getBlogList();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("username") == null) {
			return "LOGIN";
		}
		mgr.saveBlog(title, content);
		return "blog";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
