package com.bootdo.match.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 配比下发
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-13 16:47:23
 */
public class TbMatchFallDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//配比下发
	private String matchGuid;
	//计划guid
	private String planGuid;
	//理论配比
	private String theoryGuid;
	//逻辑删除（0：不删除 1：删除）
	private Integer isDelete;

	/**
	 * 设置：配比下发
	 */
	public void setMatchGuid(String matchGuid) {
		this.matchGuid = matchGuid;
	}
	/**
	 * 获取：配比下发
	 */
	public String getMatchGuid() {
		return matchGuid;
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
	 * 设置：理论配比
	 */
	public void setTheoryGuid(String theoryGuid) {
		this.theoryGuid = theoryGuid;
	}
	/**
	 * 获取：理论配比
	 */
	public String getTheoryGuid() {
		return theoryGuid;
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
}
