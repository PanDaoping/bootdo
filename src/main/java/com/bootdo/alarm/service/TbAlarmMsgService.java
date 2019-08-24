package com.bootdo.alarm.service;

import com.bootdo.alarm.domain.TbAlarmMsgDO;

import java.util.List;
import java.util.Map;

/**
 * 告警消息源表（数据量大的情况下可按分厂机构分区或按MSG_GUID做hash分区）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
public interface TbAlarmMsgService {
	
	TbAlarmMsgDO get(String msgGuid);
	
	List<TbAlarmMsgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbAlarmMsgDO tbAlarmMsg);
	
	int update(TbAlarmMsgDO tbAlarmMsg);
	
	int remove(String msgGuid);
	
	int batchRemove(String[] msgGuids);
}
