package com.bootdo.alarm.service;

import com.bootdo.alarm.domain.TbAlarmWebReadyDO;

import java.util.List;
import java.util.Map;

/**
 * 系统WEB站内消息待发送表（WEB站内消息，只有阅读或者是忽略后才写入站内消息历史表中）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
public interface TbAlarmWebReadyService {
	
	TbAlarmWebReadyDO get(String sendGuid);
	
	List<TbAlarmWebReadyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbAlarmWebReadyDO tbAlarmWebReady);
	
	int update(TbAlarmWebReadyDO tbAlarmWebReady);
	
	int remove(String sendGuid);
	
	int batchRemove(String[] sendGuids);
}
