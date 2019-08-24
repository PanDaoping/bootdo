package com.bootdo.alarm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.alarm.dao.TbAlarmMsgDao;
import com.bootdo.alarm.domain.TbAlarmMsgDO;
import com.bootdo.alarm.service.TbAlarmMsgService;



@Service
public class TbAlarmMsgServiceImpl implements TbAlarmMsgService {
	@Autowired
	private TbAlarmMsgDao tbAlarmMsgDao;
	
	@Override
	public TbAlarmMsgDO get(String msgGuid){
		return tbAlarmMsgDao.get(msgGuid);
	}
	
	@Override
	public List<TbAlarmMsgDO> list(Map<String, Object> map){
		return tbAlarmMsgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbAlarmMsgDao.count(map);
	}
	
	@Override
	public int save(TbAlarmMsgDO tbAlarmMsg){
		return tbAlarmMsgDao.save(tbAlarmMsg);
	}
	
	@Override
	public int update(TbAlarmMsgDO tbAlarmMsg){
		return tbAlarmMsgDao.update(tbAlarmMsg);
	}
	
	@Override
	public int remove(String msgGuid){
		return tbAlarmMsgDao.remove(msgGuid);
	}
	
	@Override
	public int batchRemove(String[] msgGuids){
		return tbAlarmMsgDao.batchRemove(msgGuids);
	}
	
}
