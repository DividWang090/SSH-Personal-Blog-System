package com.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class ViewBlogAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private ActionManager mgr;
	private String title;
	private String content;
	private List blogList;
	
	public String execute() throws Exception {

		this.blogList=mgr.getBlogList();
		
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
	public void setMgr(ActionManager mgr) {
		this.mgr = mgr;
	}

	public ActionManager getMgr() {
		return mgr;
	}
	public List getBlogList(){
		return this.blogList;
	}
	public void setBlogList(List blogList){
		this.blogList=blogList;
	}
}
