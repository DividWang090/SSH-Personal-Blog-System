package com.dao;

import java.util.*;
import com.domain.Message;

public interface MessageDAO {
	List getMessageList();
	void saveMessage(Message message);
}
