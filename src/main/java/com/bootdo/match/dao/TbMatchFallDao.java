package com.bootdo.match.dao;

import com.bootdo.match.domain.TbMatchFallDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 配比下发
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
@Mapper
public interface TbMatchFallDao {

	TbMatchFallDO get(String matchGuid);
	
	List<TbMatchFallDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbMatchFallDO tbMatchFall);
	
	int update(TbMatchFallDO tbMatchFall);
	
	int remove(String match_guid);
	
	int batchRemove(String[] matchGuids);
}
