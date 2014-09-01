package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowSavePageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("username") == null) {
			return "LOGIN";
		}
		return "successful";
	}

}
