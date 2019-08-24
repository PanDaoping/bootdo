package com.bootdo.match.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.match.dao.TbMatchListFallDao;
import com.bootdo.match.domain.TbMatchListFallDO;
import com.bootdo.match.service.TbMatchListFallService;



@Service
public class TbMatchListFallServiceImpl implements TbMatchListFallService {
	@Autowired
	private TbMatchListFallDao tbMatchListFallDao;
	
	@Override
	public TbMatchListFallDO get(String matchListGuid){
		return tbMatchListFallDao.get(matchListGuid);
	}
	
	@Override
	public List<TbMatchListFallDO> list(Map<String, Object> map){
		return tbMatchListFallDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbMatchListFallDao.count(map);
	}
	
	@Override
	public int save(TbMatchListFallDO tbMatchListFall){
		return tbMatchListFallDao.save(tbMatchListFall);
	}
	
	@Override
	public int update(TbMatchListFallDO tbMatchListFall){
		return tbMatchListFallDao.update(tbMatchListFall);
	}
	
	@Override
	public int remove(String matchListGuid){
		return tbMatchListFallDao.remove(matchListGuid);
	}
	
	@Override
	public int batchRemove(String[] matchListGuids){
		return tbMatchListFallDao.batchRemove(matchListGuids);
	}
	
}
