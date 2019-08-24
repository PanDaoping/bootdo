package com.bootdo.system.dao;

import com.bootdo.system.domain.TbSysDicDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
@Mapper
public interface TbSysDicDao {

	TbSysDicDO get(String dicId);
	
	List<TbSysDicDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSysDicDO tbSysDic);
	
	int update(TbSysDicDO tbSysDic);
	
	int remove(String dic_id);
	
	int batchRemove(Integer[] dicIds);
}
