package com.bootdo.sales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 客户信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public class TbSellClientDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//客户guid
	private String clientGuid;
	//客户编号
	private String clientCode;
	//客户名称
	private String clientName;
	//公司名称
	private String companyName;
	//公司电话
	private String companyTel;
	//联系电话（手机）
	private String linkMtel;
	//详细地址
	private String address;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//最近更新时间
	private Date operTime;
	//操作人id
	private String userId;
	//状态()
	private Integer state;
	//联系电话（固定）
	private String linktel;

	/**
	 * 设置：客户guid
	 */
	public void setClientGuid(String clientGuid) {
		this.clientGuid = clientGuid;
	}
	/**
	 * 获取：客户guid
	 */
	public String getClientGuid() {
		return clientGuid;
	}
	/**
	 * 设置：客户编号
	 */
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	/**
	 * 获取：客户编号
	 */
	public String getClientCode() {
		return clientCode;
	}
	/**
	 * 设置：客户名称
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * 设置：公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：公司电话
	 */
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	/**
	 * 获取：公司电话
	 */
	public String getCompanyTel() {
		return companyTel;
	}
	/**
	 * 设置：联系电话（手机）
	 */
	public void setLinkMtel(String linkMtel) {
		this.linkMtel = linkMtel;
	}
	/**
	 * 获取：联系电话（手机）
	 */
	public String getLinkMtel() {
		return linkMtel;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：逻辑删除（0：不删除 1：删除）
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：逻辑删除（0：不删除 1：删除）
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：最近更新时间
	 */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	/**
	 * 获取：最近更新时间
	 */
	public Date getOperTime() {
		return operTime;
	}
	/**
	 * 设置：操作人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：操作人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：状态()
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态()
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：联系电话（固定）
	 */
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	/**
	 * 获取：联系电话（固定）
	 */
	public String getLinktel() {
		return linktel;
	}
}
