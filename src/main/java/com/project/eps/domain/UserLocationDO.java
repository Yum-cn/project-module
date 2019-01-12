package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户位置表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
public class UserLocationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//用户编号
	private Long userId;
	//记录时间
	private Long recordTime;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//状态
	private String status;

	/**
	 * 设置：主键编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：记录时间
	 */
	public void setRecordTime(Long recordTime) {
		this.recordTime = recordTime;
	}
	/**
	 * 获取：记录时间
	 */
	public Long getRecordTime() {
		return recordTime;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
