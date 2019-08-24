package com.bootdo.stock.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 资产（材料）领用登记表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:20:07
 */
public class TbMtOutDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//出库GUID
	private String outGuid;
	//出库类型（0：正常出库  1：异常出库 2：盘亏时出库）
	private Integer outType;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//出库登记人ID
	private String regUserId;
	//工作流审核状态（0：提交 1：审核中 2：审核通过 3：审核被驳回 ）
	private Integer checkState;
	//出库描述
	private String outDesc;
	//出库领用人ID
	private String outUserId;
	//出库领用人名称
	private String userName;
	//出库时间
	private Date outTime;
	//出库总金额
	private Double amount;
	//用途说明
	private String usePurpose;
	//业务关联GUID（如果是生产的出库，此字段存储的是计划GUID，如果是盘点所产生的出库，则此字段存储的是盘点GUID，类似理解）
	private String relationGuid;
	//出库单编号
	private String outcode;

	/**
	 * 设置：出库GUID
	 */
	public void setOutGuid(String outGuid) {
		this.outGuid = outGuid;
	}
	/**
	 * 获取：出库GUID
	 */
	public String getOutGuid() {
		return outGuid;
	}
	/**
	 * 设置：出库类型（0：正常出库  1：异常出库 2：盘亏时出库）
	 */
	public void setOutType(Integer outType) {
		this.outType = outType;
	}
	/**
	 * 获取：出库类型（0：正常出库  1：异常出库 2：盘亏时出库）
	 */
	public Integer getOutType() {
		return outType;
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
	 * 设置：出库登记人ID
	 */
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	/**
	 * 获取：出库登记人ID
	 */
	public String getRegUserId() {
		return regUserId;
	}
	/**
	 * 设置：工作流审核状态（0：提交 1：审核中 2：审核通过 3：审核被驳回 ）
	 */
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	/**
	 * 获取：工作流审核状态（0：提交 1：审核中 2：审核通过 3：审核被驳回 ）
	 */
	public Integer getCheckState() {
		return checkState;
	}
	/**
	 * 设置：出库描述
	 */
	public void setOutDesc(String outDesc) {
		this.outDesc = outDesc;
	}
	/**
	 * 获取：出库描述
	 */
	public String getOutDesc() {
		return outDesc;
	}
	/**
	 * 设置：出库领用人ID
	 */
	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
	}
	/**
	 * 获取：出库领用人ID
	 */
	public String getOutUserId() {
		return outUserId;
	}
	/**
	 * 设置：出库领用人名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：出库领用人名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：出库时间
	 */
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	/**
	 * 获取：出库时间
	 */
	public Date getOutTime() {
		return outTime;
	}
	/**
	 * 设置：出库总金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：出库总金额
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 设置：用途说明
	 */
	public void setUsePurpose(String usePurpose) {
		this.usePurpose = usePurpose;
	}
	/**
	 * 获取：用途说明
	 */
	public String getUsePurpose() {
		return usePurpose;
	}
	/**
	 * 设置：业务关联GUID（如果是生产的出库，此字段存储的是计划GUID，如果是盘点所产生的出库，则此字段存储的是盘点GUID，类似理解）
	 */
	public void setRelationGuid(String relationGuid) {
		this.relationGuid = relationGuid;
	}
	/**
	 * 获取：业务关联GUID（如果是生产的出库，此字段存储的是计划GUID，如果是盘点所产生的出库，则此字段存储的是盘点GUID，类似理解）
	 */
	public String getRelationGuid() {
		return relationGuid;
	}
	/**
	 * 设置：出库单编号
	 */
	public void setOutcode(String outcode) {
		this.outcode = outcode;
	}
	/**
	 * 获取：出库单编号
	 */
	public String getOutcode() {
		return outcode;
	}
}
