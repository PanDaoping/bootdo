package com.bootdo.alarm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.alarm.dao.TbAlarmWebReadyDao;
import com.bootdo.alarm.domain.TbAlarmWebReadyDO;
import com.bootdo.alarm.service.TbAlarmWebReadyService;



@Service
public class TbAlarmWebReadyServiceImpl implements TbAlarmWebReadyService {
	@Autowired
	private TbAlarmWebReadyDao tbAlarmWebReadyDao;
	
	@Override
	public TbAlarmWebReadyDO get(String sendGuid){
		return tbAlarmWebReadyDao.get(sendGuid);
	}
	
	@Override
	public List<TbAlarmWebReadyDO> list(Map<String, Object> map){
		return tbAlarmWebReadyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbAlarmWebReadyDao.count(map);
	}
	
	@Override
	public int save(TbAlarmWebReadyDO tbAlarmWebReady){
		return tbAlarmWebReadyDao.save(tbAlarmWebReady);
	}
	
	@Override
	public int update(TbAlarmWebReadyDO tbAlarmWebReady){
		return tbAlarmWebReadyDao.update(tbAlarmWebReady);
	}
	
	@Override
	public int remove(String sendGuid){
		return tbAlarmWebReadyDao.remove(sendGuid);
	}
	
	@Override
	public int batchRemove(String[] sendGuids){
		return tbAlarmWebReadyDao.batchRemove(sendGuids);
	}
	
}
