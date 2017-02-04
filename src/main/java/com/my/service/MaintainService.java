package com.my.service;

import java.util.ArrayList;
import java.util.List;

import com.my.dao.MessageDao;

/**
 * 维护
 */
public class MaintainService {
	
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if (null != id && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id.trim()));
		}
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] idList) {
		if (null != idList && idList.length > 0) {
			List<Integer> ids = new ArrayList<Integer>();
			for (int i = 0; i < idList.length; i++) {
				ids.add(Integer.valueOf(idList[i].trim()));
			}
			MessageDao messageDao = new MessageDao();
			messageDao.deleteBatch(ids);
		}
	}
}
