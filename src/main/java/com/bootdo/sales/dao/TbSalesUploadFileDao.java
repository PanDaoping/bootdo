package com.bootdo.sales.dao;

import com.bootdo.sales.domain.TbSalesUploadFileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-17 15:28:00
 */
@Mapper
public interface TbSalesUploadFileDao {

	TbSalesUploadFileDO get(String uploadGuid);
	
	List<TbSalesUploadFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSalesUploadFileDO tbSalesUploadFile);
	
	int update(TbSalesUploadFileDO tbSalesUploadFile);
	
	int remove(String upload_guid);
	
	int batchRemove(String[] uploadGuids);

	int removeByRelation(String contractGuid);
}
