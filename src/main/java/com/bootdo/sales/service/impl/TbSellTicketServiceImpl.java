package com.bootdo.sales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sales.dao.TbSellTicketDao;
import com.bootdo.sales.domain.TbSellTicketDO;
import com.bootdo.sales.service.TbSellTicketService;



@Service
public class TbSellTicketServiceImpl implements TbSellTicketService {
	@Autowired
	private TbSellTicketDao tbSellTicketDao;
	
	@Override
	public TbSellTicketDO get(String ticketGuid){
		return tbSellTicketDao.get(ticketGuid);
	}
	
	@Override
	public List<TbSellTicketDO> list(Map<String, Object> map){
		return tbSellTicketDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tbSellTicketDao.count(map);
	}
	
	@Override
	public int save(TbSellTicketDO tbSellTicket){
		return tbSellTicketDao.save(tbSellTicket);
	}
	
	@Override
	public int update(TbSellTicketDO tbSellTicket){
		return tbSellTicketDao.update(tbSellTicket);
	}
	
	@Override
	public int remove(String ticketGuid){
		return tbSellTicketDao.remove(ticketGuid);
	}
	
	@Override
	public int batchRemove(String[] ticketGuids){
		return tbSellTicketDao.batchRemove(ticketGuids);
	}
	
}
