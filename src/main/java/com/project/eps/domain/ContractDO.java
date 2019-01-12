package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 合同表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public class ContractDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//合同名称
	private Long name;
	//合同金额
	private String amount;
	//合同签署时间
	private Integer signTime;
	//签署人
	private String signPerson;
	//合同生效时间
	private String effectiveStartTime;
	//合同终止时间
	private String effectiveEndTime;
	//合同服务次数
	private String serviceTimes;
	//合同总服务时长
	private String serviceDuration;
	//客户编号
	private String customerId;
	//客户名称
	private String customerName;
	//合同规模
	private String contractSize;
	//合作方式（包年/包月/按个）
	private String ways;
	//合作方式数量
	private String waysNumber;
	//合同附件编号
	private String attachmentIds;
	//备注
	private String remark;
	//状态
	private Integer status;
	//创建时间
	private Long createTime;
	//修改时间
	private Long updateTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：合同名称
	 */
	public void setName(Long name) {
		this.name = name;
	}
	/**
	 * 获取：合同名称
	 */
	public Long getName() {
		return name;
	}
	/**
	 * 设置：合同金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：合同金额
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：合同签署时间
	 */
	public void setSignTime(Integer signTime) {
		this.signTime = signTime;
	}
	/**
	 * 获取：合同签署时间
	 */
	public Integer getSignTime() {
		return signTime;
	}
	/**
	 * 设置：签署人
	 */
	public void setSignPerson(String signPerson) {
		this.signPerson = signPerson;
	}
	/**
	 * 获取：签署人
	 */
	public String getSignPerson() {
		return signPerson;
	}
	/**
	 * 设置：合同生效时间
	 */
	public void setEffectiveStartTime(String effectiveStartTime) {
		this.effectiveStartTime = effectiveStartTime;
	}
	/**
	 * 获取：合同生效时间
	 */
	public String getEffectiveStartTime() {
		return effectiveStartTime;
	}
	/**
	 * 设置：合同终止时间
	 */
	public void setEffectiveEndTime(String effectiveEndTime) {
		this.effectiveEndTime = effectiveEndTime;
	}
	/**
	 * 获取：合同终止时间
	 */
	public String getEffectiveEndTime() {
		return effectiveEndTime;
	}
	/**
	 * 设置：合同服务次数
	 */
	public void setServiceTimes(String serviceTimes) {
		this.serviceTimes = serviceTimes;
	}
	/**
	 * 获取：合同服务次数
	 */
	public String getServiceTimes() {
		return serviceTimes;
	}
	/**
	 * 设置：合同总服务时长
	 */
	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}
	/**
	 * 获取：合同总服务时长
	 */
	public String getServiceDuration() {
		return serviceDuration;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：客户名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：合同规模
	 */
	public void setContractSize(String contractSize) {
		this.contractSize = contractSize;
	}
	/**
	 * 获取：合同规模
	 */
	public String getContractSize() {
		return contractSize;
	}
	/**
	 * 设置：合作方式（包年/包月/按个）
	 */
	public void setWays(String ways) {
		this.ways = ways;
	}
	/**
	 * 获取：合作方式（包年/包月/按个）
	 */
	public String getWays() {
		return ways;
	}
	/**
	 * 设置：合作方式数量
	 */
	public void setWaysNumber(String waysNumber) {
		this.waysNumber = waysNumber;
	}
	/**
	 * 获取：合作方式数量
	 */
	public String getWaysNumber() {
		return waysNumber;
	}
	/**
	 * 设置：合同附件编号
	 */
	public void setAttachmentIds(String attachmentIds) {
		this.attachmentIds = attachmentIds;
	}
	/**
	 * 获取：合同附件编号
	 */
	public String getAttachmentIds() {
		return attachmentIds;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
