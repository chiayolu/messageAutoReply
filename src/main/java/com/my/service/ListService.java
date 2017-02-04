package com.my.service;

import java.util.List;

import com.my.bean.Message;
import com.my.dao.MessageDao;

/**
 * 列表相关的业务功能
 */
public class ListService {
	public List<Message> QueryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	} 
}
