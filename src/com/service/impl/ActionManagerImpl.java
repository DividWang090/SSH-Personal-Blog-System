package com.service.impl;

import java.util.List;

import com.dao.BlogDAO;
import com.dao.MessageDAO;
import com.dao.UserDAO;
import com.domain.Blog;
import com.domain.Message;
import com.domain.Users;
import com.service.ActionManager;

public class ActionManagerImpl implements ActionManager {
	private UserDAO userDAO;
	private BlogDAO blogDAO;
	private MessageDAO messageDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}

	public Integer validLogin(String username, String password) {
		try {
			Users user = userDAO.findUserByNameAndPass(username, password);
			if (user != null) {
				return user.getId();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public String getcontent(int id) {
		// TODO Auto-generated method stub
		try {
			// Blog blog = blogDAO.findBlogById(title);
			Blog blog = blogDAO.get(id);
			return blog.getContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public List getBlogList() {
		// TODO Auto-generated method stub
		try {
			List blogList = blogDAO.getBlogList();
			return blogList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void saveBlog(String title, String content) {
		// TODO Auto-generated method stub
		try {
			Blog blog = new Blog();
			blog.setTitle(title);
			blog.setContent(content);
//			blog.setId((int)Math.random());
			blogDAO.save(blog);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public List getMessageList() {
		// TODO Auto-generated method stub
		try {
			List messageList = messageDAO.getMessageList();
			return messageList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public void saveMessage(String name, String content) {
		// TODO Auto-generated method stub
		try {
			Message message = new Message();
//			message.setId(null);
			message.setName(name);
			message.setContent(content);
			
			messageDAO.saveMessage(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	@Override
	public void deleteBlog(Integer id) {
		// TODO Auto-generated method stub
		try {
			blogDAO.deleteBlog(id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void updateUser(String password) {
		// TODO Auto-generated method stub
		try {
			Users user = userDAO.get(2);
			System.out.println(user.getPassword());
			user.setPassword(password);
			userDAO.update(user);
			System.out.println(user.getPassword());

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
