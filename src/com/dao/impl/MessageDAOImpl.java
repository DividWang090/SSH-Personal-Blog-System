package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.MessageDAO;
import com.domain.*;
public class MessageDAOImpl extends HibernateDaoSupport implements MessageDAO{

	@Override
	public List getMessageList() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Message order by id desc");
	}

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(message);
	}

}
