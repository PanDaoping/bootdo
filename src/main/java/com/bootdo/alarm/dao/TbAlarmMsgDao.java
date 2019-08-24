package com.bootdo.alarm.dao;

import com.bootdo.alarm.domain.TbAlarmMsgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 告警消息源表（数据量大的情况下可按分厂机构分区或按MSG_GUID做hash分区）
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
@Mapper
public interface TbAlarmMsgDao {

	TbAlarmMsgDO get(String msgGuid);
	
	List<TbAlarmMsgDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbAlarmMsgDO tbAlarmMsg);
	
	int update(TbAlarmMsgDO tbAlarmMsg);
	
	int remove(String msg_guid);
	
	int batchRemove(String[] msgGuids);
}
