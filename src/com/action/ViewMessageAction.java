package com.action;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class ViewMessageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionManager mgr;
	private String name;
	private String content;
	private List messageList;
	
	public String execute() throws Exception{
		this.messageList=mgr.getMessageList();
		return "SUCCESS";
		
	}

	public ActionManager getMgr() {
		return mgr;
	}

	public void setMgr(ActionManager mgr) {
		this.mgr = mgr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getMessageList() {
		return messageList;
	}

	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
