package com.bootdo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sales.dao.TbSalesUploadFileDao;
import com.bootdo.sales.domain.TbSalesUploadFileDO;
import com.bootdo.sales.service.TbSalesUploadFileService;



@Service
public class TbSalesUploadFileServiceImpl implements TbSalesUploadFileService {
	@Autowired
	private TbSalesUploadFileDao tbSalesUploadFileDao;
	
	@Override
	public TbSalesUploadFileDO get(String uploadGuid){
		return tbSalesUploadFileDao.get(uploadGuid);
	}
	
	@Override
	public List<TbSalesUploadFileDO> list(Map<String, Object> map){
		return tbSalesUploadFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSalesUploadFileDao.count(map);
	}
	
	@Override
	public int save(TbSalesUploadFileDO tbSalesUploadFile){
		return tbSalesUploadFileDao.save(tbSalesUploadFile);
	}
	
	@Override
	public int update(TbSalesUploadFileDO tbSalesUploadFile){
		return tbSalesUploadFileDao.update(tbSalesUploadFile);
	}
	
	@Override
	public int remove(String uploadGuid){
		return tbSalesUploadFileDao.remove(uploadGuid);
	}
	
	@Override
	public int batchRemove(String[] uploadGuids){
		return tbSalesUploadFileDao.batchRemove(uploadGuids);
	}
	
}
