package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class OrderDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//订单编号
	private Long orderNo;
	//服务时长
	private Long serviceDuration;
	//服务费
	private Integer serviceFee;
	//出车公里
	private Double distanceKm;
	//出车费
	private Integer carFee;
	//用电描述
	private String orderDesc;
	//开始供电时间
	private Long powerStartTime;
	//结束供电时间
	private Long powerEndTime;
	//状态
	private Integer status;
	//创建时间
	private Long createTime;
	//修改时间
	private Long updateTime;

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
	 * 设置：订单编号
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public Long getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：服务时长
	 */
	public void setServiceDuration(Long serviceDuration) {
		this.serviceDuration = serviceDuration;
	}
	/**
	 * 获取：服务时长
	 */
	public Long getServiceDuration() {
		return serviceDuration;
	}
	/**
	 * 设置：服务费
	 */
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**
	 * 获取：服务费
	 */
	public Integer getServiceFee() {
		return serviceFee;
	}
	/**
	 * 设置：出车公里
	 */
	public void setDistanceKm(Double distanceKm) {
		this.distanceKm = distanceKm;
	}
	/**
	 * 获取：出车公里
	 */
	public Double getDistanceKm() {
		return distanceKm;
	}
	/**
	 * 设置：出车费
	 */
	public void setCarFee(Integer carFee) {
		this.carFee = carFee;
	}
	/**
	 * 获取：出车费
	 */
	public Integer getCarFee() {
		return carFee;
	}
	/**
	 * 设置：用电描述
	 */
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	/**
	 * 获取：用电描述
	 */
	public String getOrderDesc() {
		return orderDesc;
	}
	/**
	 * 设置：开始供电时间
	 */
	public void setPowerStartTime(Long powerStartTime) {
		this.powerStartTime = powerStartTime;
	}
	/**
	 * 获取：开始供电时间
	 */
	public Long getPowerStartTime() {
		return powerStartTime;
	}
	/**
	 * 设置：结束供电时间
	 */
	public void setPowerEndTime(Long powerEndTime) {
		this.powerEndTime = powerEndTime;
	}
	/**
	 * 获取：结束供电时间
	 */
	public Long getPowerEndTime() {
		return powerEndTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}
}
