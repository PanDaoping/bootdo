package com.bootdo.match.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.match.dao.TbMatchFallDao;
import com.bootdo.match.domain.TbMatchFallDO;
import com.bootdo.match.service.TbMatchFallService;



@Service
public class TbMatchFallServiceImpl implements TbMatchFallService {
	@Autowired
	private TbMatchFallDao tbMatchFallDao;
	
	@Override
	public TbMatchFallDO get(String matchGuid){
		return tbMatchFallDao.get(matchGuid);
	}
	
	@Override
	public List<TbMatchFallDO> list(Map<String, Object> map){
		return tbMatchFallDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMatchFallDao.count(map);
	}
	
	@Override
	public int save(TbMatchFallDO tbMatchFall){
		return tbMatchFallDao.save(tbMatchFall);
	}
	
	@Override
	public int update(TbMatchFallDO tbMatchFall){
		return tbMatchFallDao.update(tbMatchFall);
	}
	
	@Override
	public int remove(String matchGuid){
		return tbMatchFallDao.remove(matchGuid);
	}
	
	@Override
	public int batchRemove(String[] matchGuids){
		return tbMatchFallDao.batchRemove(matchGuids);
	}
	
}
