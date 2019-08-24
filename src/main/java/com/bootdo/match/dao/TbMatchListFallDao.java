package com.bootdo.match.dao;

import com.bootdo.match.domain.TbMatchListFallDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
@Mapper
public interface TbMatchListFallDao {

	TbMatchListFallDO get(String matchListGuid);
	
	List<TbMatchListFallDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbMatchListFallDO tbMatchListFall);
	
	int update(TbMatchListFallDO tbMatchListFall);
	
	int remove(String match_list_guid);
	
	int batchRemove(String[] matchListGuids);
}
