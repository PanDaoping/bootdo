package com.bootdo.system.dao;

import com.bootdo.system.domain.TbSysDicListDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典分类表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-25 13:11:18
 */
@Mapper
public interface TbSysDicListDao {

	TbSysDicListDO get(String dicListId);
	
	List<TbSysDicListDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSysDicListDO tbSysDicList);
	
	int update(TbSysDicListDO tbSysDicList);
	
	int remove(String dic_list_id);
	
	int batchRemove(Integer[] dicListIds);
}
