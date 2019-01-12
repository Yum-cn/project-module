package com.project.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="project")
public class BootdoConfig {
	//上传路径
	private String uploadPath;
	//下载Url
	private String downloadUrl;
	//系统名称
	private String systemName;
	//手机号正则
	private String phoneRegexp;
	//国际手机号正则
	private String phoneInternationalRegexp;
	//密码正则
	private String passwordRegexp;
	

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getPhoneRegexp() {
		return phoneRegexp;
	}

	public void setPhoneRegexp(String phoneRegexp) {
		this.phoneRegexp = phoneRegexp;
	}

	public String getPhoneInternationalRegexp() {
		return phoneInternationalRegexp;
	}

	public void setPhoneInternationalRegexp(String phoneInternationalRegexp) {
		this.phoneInternationalRegexp = phoneInternationalRegexp;
	}

	public String getPasswordRegexp() {
		return passwordRegexp;
	}

	public void setPasswordRegexp(String passwordRegexp) {
		this.passwordRegexp = passwordRegexp;
	}
	
	
}
