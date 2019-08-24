package com.bootdo.alarm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 告警消息源表（数据量大的情况下可按分厂机构分区或按MSG_GUID做hash分区）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
public class TbAlarmMsgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//消息GUID
	private String msgGuid;
	//备注字段1
	private String remark1;
	//备注字段2
	private String remark2;
	//备注字段3
	private String remark3;
	//备注字段4
	private String remark4;
	//备注字段5
	private String remark5;
	//消息代码（用于唯一识别此类消息，当告警被恢复后，则有可能需要取消该类告警消息，此编码由各业务模块自行定义）
	private String msgCode;
	//是否是待办消息提醒（0：不是 1：是）
	private String isUndoTask;
	//写入时间（日）
	private Date writeDay;
	//消息内容
	private String msgContent;
	//消息主体对象（由哪个主体对象产生的消息）
	private String msgObject;
	//业务关键字（唯一确定具体某业务模块消息的关键字）
	private String msgKey;
	//告警消息定义ID
	private String defineId;

	/**
	 * 设置：消息GUID
	 */
	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}
	/**
	 * 获取：消息GUID
	 */
	public String getMsgGuid() {
		return msgGuid;
	}
	/**
	 * 设置：备注字段1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	/**
	 * 获取：备注字段1
	 */
	public String getRemark1() {
		return remark1;
	}
	/**
	 * 设置：备注字段2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	/**
	 * 获取：备注字段2
	 */
	public String getRemark2() {
		return remark2;
	}
	/**
	 * 设置：备注字段3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	/**
	 * 获取：备注字段3
	 */
	public String getRemark3() {
		return remark3;
	}
	/**
	 * 设置：备注字段4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	/**
	 * 获取：备注字段4
	 */
	public String getRemark4() {
		return remark4;
	}
	/**
	 * 设置：备注字段5
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	/**
	 * 获取：备注字段5
	 */
	public String getRemark5() {
		return remark5;
	}
	/**
	 * 设置：消息代码（用于唯一识别此类消息，当告警被恢复后，则有可能需要取消该类告警消息，此编码由各业务模块自行定义）
	 */
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	/**
	 * 获取：消息代码（用于唯一识别此类消息，当告警被恢复后，则有可能需要取消该类告警消息，此编码由各业务模块自行定义）
	 */
	public String getMsgCode() {
		return msgCode;
	}
	/**
	 * 设置：是否是待办消息提醒（0：不是 1：是）
	 */
	public void setIsUndoTask(String isUndoTask) {
		this.isUndoTask = isUndoTask;
	}
	/**
	 * 获取：是否是待办消息提醒（0：不是 1：是）
	 */
	public String getIsUndoTask() {
		return isUndoTask;
	}
	/**
	 * 设置：写入时间（日）
	 */
	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}
	/**
	 * 获取：写入时间（日）
	 */
	public Date getWriteDay() {
		return writeDay;
	}
	/**
	 * 设置：消息内容
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * 获取：消息内容
	 */
	public String getMsgContent() {
		return msgContent;
	}
	/**
	 * 设置：消息主体对象（由哪个主体对象产生的消息）
	 */
	public void setMsgObject(String msgObject) {
		this.msgObject = msgObject;
	}
	/**
	 * 获取：消息主体对象（由哪个主体对象产生的消息）
	 */
	public String getMsgObject() {
		return msgObject;
	}
	/**
	 * 设置：业务关键字（唯一确定具体某业务模块消息的关键字）
	 */
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
	/**
	 * 获取：业务关键字（唯一确定具体某业务模块消息的关键字）
	 */
	public String getMsgKey() {
		return msgKey;
	}
	/**
	 * 设置：告警消息定义ID
	 */
	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}
	/**
	 * 获取：告警消息定义ID
	 */
	public String getDefineId() {
		return defineId;
	}
}
