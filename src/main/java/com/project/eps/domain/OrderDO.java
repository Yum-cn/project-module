package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//订单编号
	private String orderNo;
	//订单名称
	private String orderName;
	//订单类型
	private String orderType;
	//订单创建人编号
	private Long createUserId;
	//客户编号
	private Long customerId;
	//订单金额(单位分)
	private Integer amount;
	//成交时间
	private Long finishTime;
	//订单状态
	private Integer orderStatus;
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
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：订单名称
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * 获取：订单名称
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * 设置：订单类型
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：订单创建人编号
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：订单创建人编号
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：客户编号
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：订单金额(单位分)
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * 获取：订单金额(单位分)
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * 设置：成交时间
	 */
	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}
	/**
	 * 获取：成交时间
	 */
	public Long getFinishTime() {
		return finishTime;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderStatus() {
		return orderStatus;
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
