package com.bootdo.sales.dao;

import com.bootdo.sales.domain.TbSellTicketDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
@Mapper
public interface TbSellTicketDao {

	TbSellTicketDO get(String ticketGuid);
	
	List<TbSellTicketDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TbSellTicketDO tbSellTicket);
	
	int update(TbSellTicketDO tbSellTicket);
	
	int remove(String ticket_guid);
	
	int batchRemove(String[] ticketGuids);
}
