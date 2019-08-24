package com.bootdo.match.dao;

import com.bootdo.match.domain.TbTheroryMatchingDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-04 14:45:47
 */
@Mapper
public interface TbTheroryMatchingDao {

	TbTheroryMatchingDO get(String theoryGuid);
	
	List<TbTheroryMatchingDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbTheroryMatchingDO tbTheroryMatching);
	
	int update(TbTheroryMatchingDO tbTheroryMatching);
	
	int remove(String theory_guid);
	
	int batchRemove(String[] theoryGuids);
}
