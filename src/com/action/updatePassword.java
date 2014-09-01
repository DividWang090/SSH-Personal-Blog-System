package com.action;

import java.util.List;
import java.util.Map;

import com.domain.Blog;
import com.domain.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class updatePassword extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionManager mgr;
	private List<Blog> blogList;
	private List<Message> messageList;
	private int blogNumber;
	private int messageNumber;
	private String username;
	private String password;
	
	public String execute() throws Exception {
		this.setBlogList(getMgr().getBlogList());
		this.setMessageList(getMgr().getMessageList());
		
		this.setBlogNumber(this.getBlogList().size());
		this.setMessageNumber(this.getMessageList().size());
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("username") == null) {
			return "LOGIN";
		}
		mgr.updateUser(password);
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

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public int getBlogNumber() {
		return blogNumber;
	}

	public void setBlogNumber(int blogNumber) {
		this.blogNumber = blogNumber;
	}

	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
