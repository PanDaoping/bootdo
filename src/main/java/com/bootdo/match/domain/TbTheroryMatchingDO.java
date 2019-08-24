package com.bootdo.match.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-07-04 14:45:47
 */
public class TbTheroryMatchingDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//理论配比guid
	private String theoryGuid;
	//强度等级
	private String strengthGrade;
	//配比编号
	private String matchNum;
	//
	private Integer isDelete;

	/**
	 * 设置：理论配比guid
	 */
	public void setTheoryGuid(String theoryGuid) {
		this.theoryGuid = theoryGuid;
	}
	/**
	 * 获取：理论配比guid
	 */
	public String getTheoryGuid() {
		return theoryGuid;
	}
	/**
	 * 设置：强度等级
	 */
	public void setStrengthGrade(String strengthGrade) {
		this.strengthGrade = strengthGrade;
	}
	/**
	 * 获取：强度等级
	 */
	public String getStrengthGrade() {
		return strengthGrade;
	}
	/**
	 * 设置：配比编号
	 */
	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}
	/**
	 * 获取：配比编号
	 */
	public String getMatchNum() {
		return matchNum;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
}
