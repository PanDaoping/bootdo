package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.TbSysDicListDao;
import com.bootdo.system.domain.TbSysDicListDO;
import com.bootdo.system.service.TbSysDicListService;



@Service
public class TbSysDicListServiceImpl implements TbSysDicListService {
	@Autowired
	private TbSysDicListDao tbSysDicListDao;
	
	@Override
	public TbSysDicListDO get(String dicListId){
		return tbSysDicListDao.get(dicListId);
	}
	
	@Override
	public List<TbSysDicListDO> list(Map<String, Object> map){
		return tbSysDicListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSysDicListDao.count(map);
	}
	
	@Override
	public int save(TbSysDicListDO tbSysDicList){
		return tbSysDicListDao.save(tbSysDicList);
	}
	
	@Override
	public int update(TbSysDicListDO tbSysDicList){
		return tbSysDicListDao.update(tbSysDicList);
	}
	
	@Override
	public int remove(String dicListId){
		return tbSysDicListDao.remove(dicListId);
	}
	
	@Override
	public int batchRemove(Integer[] dicListIds){
		return tbSysDicListDao.batchRemove(dicListIds);
	}
	
}
