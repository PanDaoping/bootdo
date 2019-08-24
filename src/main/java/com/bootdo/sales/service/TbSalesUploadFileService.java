package com.bootdo.sales.service;

import com.bootdo.sales.domain.TbSalesUploadFileDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-17 15:28:00
 */
public interface TbSalesUploadFileService {
	
	TbSalesUploadFileDO get(String uploadGuid);
	
	List<TbSalesUploadFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TbSalesUploadFileDO tbSalesUploadFile);
	
	int update(TbSalesUploadFileDO tbSalesUploadFile);
	
	int remove(String uploadGuid);
	
	int batchRemove(String[] uploadGuids);
}
