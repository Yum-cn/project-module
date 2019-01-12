package com.project.eps.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * API点表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public class ApiPlaceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键编号
	private Long id;
	//API点名称
	private String apiName;
	//API点地址
	private String apiAddress;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//行业类型
	private Long industryType;
	//区域
	private Integer area;
	//负责人
	private Double responsiblePerson;
	//负责人职位
	private String responsiblePersonJob;
	//负责人联系电话
	private String responsiblePersonPhone;
	//联系人
	private String contactPerson;
	//联系人联系电话
	private String contactPersonPhone;
	//最大功率
	private Double maxPower;
	//最小功率
	private Double minPower;
	//最大电流
	private Double maxCurrent;
	//最小电流
	private Double minCurrent;
	//电压
	private Double voltage;
	//负责电工
	private String electrician;
	//电工电话
	private String electricianPhone;
	//开户状态（合同维护api点后置为已开户,已开户才可使用）
	private Integer validStatus;
	//录入人(后台系统用户信息)
	private String operateUser;
	//录入人电话(后台系统用户信息)
	private String operatePhone;
	//API服务有效状态(判断该API点是否在合同执行有效期内,此状态需由系统自动更新)
	private Integer apiStatus;
	//状态
	private Integer status;
	//入网时间
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
	 * 设置：API点名称
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	/**
	 * 获取：API点名称
	 */
	public String getApiName() {
		return apiName;
	}
	/**
	 * 设置：API点地址
	 */
	public void setApiAddress(String apiAddress) {
		this.apiAddress = apiAddress;
	}
	/**
	 * 获取：API点地址
	 */
	public String getApiAddress() {
		return apiAddress;
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
	 * 设置：行业类型
	 */
	public void setIndustryType(Long industryType) {
		this.industryType = industryType;
	}
	/**
	 * 获取：行业类型
	 */
	public Long getIndustryType() {
		return industryType;
	}
	/**
	 * 设置：区域
	 */
	public void setArea(Integer area) {
		this.area = area;
	}
	/**
	 * 获取：区域
	 */
	public Integer getArea() {
		return area;
	}
	/**
	 * 设置：负责人
	 */
	public void setResponsiblePerson(Double responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	/**
	 * 获取：负责人
	 */
	public Double getResponsiblePerson() {
		return responsiblePerson;
	}
	/**
	 * 设置：负责人职位
	 */
	public void setResponsiblePersonJob(String responsiblePersonJob) {
		this.responsiblePersonJob = responsiblePersonJob;
	}
	/**
	 * 获取：负责人职位
	 */
	public String getResponsiblePersonJob() {
		return responsiblePersonJob;
	}
	/**
	 * 设置：负责人联系电话
	 */
	public void setResponsiblePersonPhone(String responsiblePersonPhone) {
		this.responsiblePersonPhone = responsiblePersonPhone;
	}
	/**
	 * 获取：负责人联系电话
	 */
	public String getResponsiblePersonPhone() {
		return responsiblePersonPhone;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * 设置：联系人联系电话
	 */
	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}
	/**
	 * 获取：联系人联系电话
	 */
	public String getContactPersonPhone() {
		return contactPersonPhone;
	}
	/**
	 * 设置：最大功率
	 */
	public void setMaxPower(Double maxPower) {
		this.maxPower = maxPower;
	}
	/**
	 * 获取：最大功率
	 */
	public Double getMaxPower() {
		return maxPower;
	}
	/**
	 * 设置：最小功率
	 */
	public void setMinPower(Double minPower) {
		this.minPower = minPower;
	}
	/**
	 * 获取：最小功率
	 */
	public Double getMinPower() {
		return minPower;
	}
	/**
	 * 设置：最大电流
	 */
	public void setMaxCurrent(Double maxCurrent) {
		this.maxCurrent = maxCurrent;
	}
	/**
	 * 获取：最大电流
	 */
	public Double getMaxCurrent() {
		return maxCurrent;
	}
	/**
	 * 设置：最小电流
	 */
	public void setMinCurrent(Double minCurrent) {
		this.minCurrent = minCurrent;
	}
	/**
	 * 获取：最小电流
	 */
	public Double getMinCurrent() {
		return minCurrent;
	}
	/**
	 * 设置：电压
	 */
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	/**
	 * 获取：电压
	 */
	public Double getVoltage() {
		return voltage;
	}
	/**
	 * 设置：负责电工
	 */
	public void setElectrician(String electrician) {
		this.electrician = electrician;
	}
	/**
	 * 获取：负责电工
	 */
	public String getElectrician() {
		return electrician;
	}
	/**
	 * 设置：电工电话
	 */
	public void setElectricianPhone(String electricianPhone) {
		this.electricianPhone = electricianPhone;
	}
	/**
	 * 获取：电工电话
	 */
	public String getElectricianPhone() {
		return electricianPhone;
	}
	/**
	 * 设置：开户状态（合同维护api点后置为已开户,已开户才可使用）
	 */
	public void setValidStatus(Integer validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 获取：开户状态（合同维护api点后置为已开户,已开户才可使用）
	 */
	public Integer getValidStatus() {
		return validStatus;
	}
	/**
	 * 设置：录入人(后台系统用户信息)
	 */
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	/**
	 * 获取：录入人(后台系统用户信息)
	 */
	public String getOperateUser() {
		return operateUser;
	}
	/**
	 * 设置：录入人电话(后台系统用户信息)
	 */
	public void setOperatePhone(String operatePhone) {
		this.operatePhone = operatePhone;
	}
	/**
	 * 获取：录入人电话(后台系统用户信息)
	 */
	public String getOperatePhone() {
		return operatePhone;
	}
	/**
	 * 设置：API服务有效状态(判断该API点是否在合同执行有效期内,此状态需由系统自动更新)
	 */
	public void setApiStatus(Integer apiStatus) {
		this.apiStatus = apiStatus;
	}
	/**
	 * 获取：API服务有效状态(判断该API点是否在合同执行有效期内,此状态需由系统自动更新)
	 */
	public Integer getApiStatus() {
		return apiStatus;
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
	 * 设置：入网时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：入网时间
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
