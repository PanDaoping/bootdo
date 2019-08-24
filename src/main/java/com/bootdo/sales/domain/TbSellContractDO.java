package com.bootdo.sales.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 销售合同
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-12 14:24:57
 */
public class TbSellContractDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//合同guid
	private String contractGuid;
	//合同编号
	private String contractCode;
	//客户guid
	private String clientGuid;
	//合同名称
	private String contractName;
	//签订总方量
	private Double signedAmount;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;
	//施工单位
	private String constructionOrganiz;
	//工程名称
	private String projectName;
	//工程地点
	private String projectSite;
	//砼计划方量
	private Double concretePlanAmount;
	//砼实际方量
	private Double oncreteActualAmount;
	//合同开始日期
	private Date contractStartDate;
	//合同结束日期
	private Date contractOverDate;
	//结款限量，超过此限量则提醒结款
	private Double accountLimit;
	//合同状态（0：有效   1：无效 ）
	private Integer status;

	/**
	 * 设置：合同guid
	 */
	public void setContractGuid(String contractGuid) {
		this.contractGuid = contractGuid;
	}
	/**
	 * 获取：合同guid
	 */
	public String getContractGuid() {
		return contractGuid;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractCode() {
		return contractCode;
	}
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
	 * 设置：合同名称
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	/**
	 * 获取：合同名称
	 */
	public String getContractName() {
		return contractName;
	}
	/**
	 * 设置：签订总方量
	 */
	public void setSignedAmount(Double signedAmount) {
		this.signedAmount = signedAmount;
	}
	/**
	 * 获取：签订总方量
	 */
	public Double getSignedAmount() {
		return signedAmount;
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
	 * 设置：施工单位
	 */
	public void setConstructionOrganiz(String constructionOrganiz) {
		this.constructionOrganiz = constructionOrganiz;
	}
	/**
	 * 获取：施工单位
	 */
	public String getConstructionOrganiz() {
		return constructionOrganiz;
	}
	/**
	 * 设置：工程名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：工程名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：工程地点
	 */
	public void setProjectSite(String projectSite) {
		this.projectSite = projectSite;
	}
	/**
	 * 获取：工程地点
	 */
	public String getProjectSite() {
		return projectSite;
	}
	/**
	 * 设置：砼计划方量
	 */
	public void setConcretePlanAmount(Double concretePlanAmount) {
		this.concretePlanAmount = concretePlanAmount;
	}
	/**
	 * 获取：砼计划方量
	 */
	public Double getConcretePlanAmount() {
		return concretePlanAmount;
	}
	/**
	 * 设置：砼实际方量
	 */
	public void setOncreteActualAmount(Double oncreteActualAmount) {
		this.oncreteActualAmount = oncreteActualAmount;
	}
	/**
	 * 获取：砼实际方量
	 */
	public Double getOncreteActualAmount() {
		return oncreteActualAmount;
	}
	/**
	 * 设置：合同开始日期
	 */
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	/**
	 * 获取：合同开始日期
	 */
	public Date getContractStartDate() {
		return contractStartDate;
	}
	/**
	 * 设置：合同结束日期
	 */
	public void setContractOverDate(Date contractOverDate) {
		this.contractOverDate = contractOverDate;
	}
	/**
	 * 获取：合同结束日期
	 */
	public Date getContractOverDate() {
		return contractOverDate;
	}
	/**
	 * 设置：结款限量，超过此限量则提醒结款
	 */
	public void setAccountLimit(Double accountLimit) {
		this.accountLimit = accountLimit;
	}
	/**
	 * 获取：结款限量，超过此限量则提醒结款
	 */
	public Double getAccountLimit() {
		return accountLimit;
	}
	/**
	 * 设置：合同状态（0：有效   1：无效 ）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：合同状态（0：有效   1：无效 ）
	 */
	public Integer getStatus() {
		return status;
	}
}
