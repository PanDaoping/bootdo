package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.TbSysDicDao;
import com.bootdo.system.domain.TbSysDicDO;
import com.bootdo.system.service.TbSysDicService;



@Service
public class TbSysDicServiceImpl implements TbSysDicService {
	@Autowired
	private TbSysDicDao tbSysDicDao;
	
	@Override
	public TbSysDicDO get(String dicId){
		return tbSysDicDao.get(dicId);
	}
	
	@Override
	public List<TbSysDicDO> list(Map<String, Object> map){
		return tbSysDicDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSysDicDao.count(map);
	}
	
	@Override
	public int save(TbSysDicDO tbSysDic){
		return tbSysDicDao.save(tbSysDic);
	}
	
	@Override
	public int update(TbSysDicDO tbSysDic){
		return tbSysDicDao.update(tbSysDic);
	}
	
	@Override
	public int remove(String dicId){
		return tbSysDicDao.remove(dicId);
	}
	
	@Override
	public int batchRemove(Integer[] dicIds){
		return tbSysDicDao.batchRemove(dicIds);
	}
	
}
