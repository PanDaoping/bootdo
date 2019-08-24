package com.bootdo.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:06
 */
public class TbMtInDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//采购订单guid
	private String orderGuid;
	//采购单编号
	private String orderNum;
	//操作时间
	private Date operDate;
	//操作人
	private String operUser;
	//删除（0：不删除 ，1：删除）
	private Integer isDelete;

	/**
	 * 设置：采购订单guid
	 */
	public void setorderGuid(String orderGuid) {
		this.orderGuid = orderGuid;
	}
	/**
	 * 获取：采购订单guid
	 */
	public String getorderGuid() {
		return orderGuid;
	}
	/**
	 * 设置：采购单编号
	 */
	public void setorderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：采购单编号
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：操作时间
	 */
	public void setoperDate(Date operDate) {
		this.operDate = operDate;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getoperDate() {
		return operDate;
	}
	/**
	 * 设置：操作人
	 */
	public void setoperUser(String operUser) {
		this.operUser = operUser;
	}
	/**
	 * 获取：操作人
	 */
	public String getOperUser() {
		return operUser;
	}
	/**
	 * 设置：删除（0：不删除 ，1：删除）
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：删除（0：不删除 ，1：删除）
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
