package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户账户明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public class UserAccountDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//用户编号
	private Long userId;
	//交易单号
	private String tradeNo;
	//交易描述
	private String tradeDesc;
	//操作金额(单位分)
	private Integer operateAmount;
	//操作时间
	private Long operateTime;
	//操作类型(收入、支出)
	private Integer type;
	//账户余额(单位分:含当前操作金额)
	private Double amount;
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
	 * 设置：交易单号
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 获取：交易单号
	 */
	public String getTradeNo() {
		return tradeNo;
	}
	/**
	 * 设置：交易描述
	 */
	public void setTradeDesc(String tradeDesc) {
		this.tradeDesc = tradeDesc;
	}
	/**
	 * 获取：交易描述
	 */
	public String getTradeDesc() {
		return tradeDesc;
	}
	/**
	 * 设置：操作金额(单位分)
	 */
	public void setOperateAmount(Integer operateAmount) {
		this.operateAmount = operateAmount;
	}
	/**
	 * 获取：操作金额(单位分)
	 */
	public Integer getOperateAmount() {
		return operateAmount;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Long getOperateTime() {
		return operateTime;
	}
	/**
	 * 设置：操作类型(收入、支出)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：操作类型(收入、支出)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：账户余额(单位分:含当前操作金额)
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：账户余额(单位分:含当前操作金额)
	 */
	public Double getAmount() {
		return amount;
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
