package com.bootdo.alarm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统WEB站内消息待发送表（WEB站内消息，只有阅读或者是忽略后才写入站内消息历史表中）
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-06-21 15:04:45
 */
public class TbAlarmWebReadyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//发送消息GUID
	private String sendGuid;
	//告警定义ID
	private String defineId;
	//发送时间
	private Date sendTime;
	//写入告警时间
	private Date writeTime;
	//msgGuid
	private String msgGuid;
	//是否阅读（0：未阅读 1：已阅读 2：忽略）
	private Integer isRead;
	//告警发送对象用户ID
	private String userId;
	//发送次数
	private String sendCount;
	//消息内容
	private String msgContent;
	//告警消息类型（0：告警与消息 1：待办事项提醒）
	private Integer msgType;
	//告警消息级别（0：提示消息 1：一般告警 2：紧急告警 3：严重告警）
	private Integer msgLevel;
	//是否历史表记录 0：否；1：是
	private Integer isHis;

	/**
	 * 设置：发送消息GUID
	 */
	public void setSendGuid(String sendGuid) {
		this.sendGuid = sendGuid;
	}
	/**
	 * 获取：发送消息GUID
	 */
	public String getSendGuid() {
		return sendGuid;
	}
	/**
	 * 设置：告警定义ID
	 */
	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}
	/**
	 * 获取：告警定义ID
	 */
	public String getDefineId() {
		return defineId;
	}
	/**
	 * 设置：发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：写入告警时间
	 */
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	/**
	 * 获取：写入告警时间
	 */
	public Date getWriteTime() {
		return writeTime;
	}
	/**
	 * 设置：msgGuid
	 */
	public void setMsgGuid(String msgGuid) {
		this.msgGuid = msgGuid;
	}
	/**
	 * 获取：msgGuid
	 */
	public String getMsgGuid() {
		return msgGuid;
	}
	/**
	 * 设置：是否阅读（0：未阅读 1：已阅读 2：忽略）
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	/**
	 * 获取：是否阅读（0：未阅读 1：已阅读 2：忽略）
	 */
	public Integer getIsRead() {
		return isRead;
	}
	/**
	 * 设置：告警发送对象用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：告警发送对象用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：发送次数
	 */
	public void setSendCount(String sendCount) {
		this.sendCount = sendCount;
	}
	/**
	 * 获取：发送次数
	 */
	public String getSendCount() {
		return sendCount;
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
	 * 设置：告警消息类型（0：告警与消息 1：待办事项提醒）
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	/**
	 * 获取：告警消息类型（0：告警与消息 1：待办事项提醒）
	 */
	public Integer getMsgType() {
		return msgType;
	}
	/**
	 * 设置：告警消息级别（0：提示消息 1：一般告警 2：紧急告警 3：严重告警）
	 */
	public void setMsgLevel(Integer msgLevel) {
		this.msgLevel = msgLevel;
	}
	/**
	 * 获取：告警消息级别（0：提示消息 1：一般告警 2：紧急告警 3：严重告警）
	 */
	public Integer getMsgLevel() {
		return msgLevel;
	}
	/**
	 * 设置：是否历史表记录 0：否；1：是
	 */
	public void setIsHis(Integer isHis) {
		this.isHis = isHis;
	}
	/**
	 * 获取：是否历史表记录 0：否；1：是
	 */
	public Integer getIsHis() {
		return isHis;
	}
}
