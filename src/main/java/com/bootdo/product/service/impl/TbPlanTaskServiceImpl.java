package com.bootdo.product.service.impl;

import com.bootdo.alarm.dao.TbAlarmMsgDao;
import com.bootdo.alarm.dao.TbAlarmWebReadyDao;
import com.bootdo.alarm.domain.TbAlarmWebReadyDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.product.dao.TbPlanTaskDao;
import com.bootdo.product.domain.TbPlanTaskDO;
import com.bootdo.product.service.TbPlanTaskService;



@Service
public class TbPlanTaskServiceImpl implements TbPlanTaskService {
	@Autowired
	private TbPlanTaskDao tbPlanTaskDao;
    @Autowired
    private TbAlarmMsgDao tbAlarmMsgDao;
	@Autowired
	private TbAlarmWebReadyDao tbAlarmWebReadyDao;


	@Override
	public TbPlanTaskDO get(String planGuid){
		return tbPlanTaskDao.get(planGuid);
	}
	
	@Override
	public List<TbPlanTaskDO> list(Map<String, Object> map){
		return tbPlanTaskDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbPlanTaskDao.count(map);
	}
	
	@Override
	public int save(TbPlanTaskDO tbPlanTask){
		int count=0;
		try{
			tbPlanTaskDao.save(tbPlanTask);
			TbAlarmWebReadyDO tbAlarmWebReady=new TbAlarmWebReadyDO();

			tbAlarmWebReadyDao.save(tbAlarmWebReady);
			count++;
		}catch (Exception e){
             e.getMessage();
		}

		return count;
	}
	
	@Override
	public int update(TbPlanTaskDO tbPlanTask){
		return tbPlanTaskDao.update(tbPlanTask);
	}
	
	@Override
	public int remove(String planGuid){
		return tbPlanTaskDao.remove(planGuid);
	}
	
	@Override
	public int batchRemove(String[] planGuids){
		return tbPlanTaskDao.batchRemove(planGuids);
	}
	
}
