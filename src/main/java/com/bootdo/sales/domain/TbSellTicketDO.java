package com.bootdo.sales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public class TbSellTicketDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//销售单guid
	private String ticketGuid;
	//计划guid
	private String planGuid;
	//状态（0未结款  1 已结款   ）
	private Integer status;

	/**
	 * 设置：销售单guid
	 */
	public void setTicketGuid(String ticketGuid) {
		this.ticketGuid = ticketGuid;
	}
	/**
	 * 获取：销售单guid
	 */
	public String getTicketGuid() {
		return ticketGuid;
	}
	/**
	 * 设置：计划guid
	 */
	public void setPlanGuid(String planGuid) {
		this.planGuid = planGuid;
	}
	/**
	 * 获取：计划guid
	 */
	public String getPlanGuid() {
		return planGuid;
	}
	/**
	 * 设置：状态（0未结款  1 已结款   ）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态（0未结款  1 已结款   ）
	 */
	public Integer getStatus() {
		return status;
	}
}
