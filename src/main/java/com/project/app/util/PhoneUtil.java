package com.project.app.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author Yum
 */
public class PhoneUtil {

	/**
	 * 获取有效国家代码
	 * 
	 * @author Yum
	 */
	public static String getValidCountryCode(String countryCode) {

		if (StringUtils.contains(countryCode, "+")) {
			countryCode = StringUtils.substringAfter(countryCode, "+");
		}

		if (StringUtils.equals("86", countryCode) || StringUtils.isBlank(countryCode)) {// 兼容旧接口及数据
			countryCode = "";
		}

		return countryCode;
	}

	/**
	 * 判断是否为国际区号
	 * 
	 * @author Yum
	 */
	public static boolean isInternationalNumber(String countryCode) {

		boolean isInternationalNumber = false;
		if (!StringUtils.equals("+86", countryCode) && !StringUtils.equals("86", countryCode)
				&& !StringUtils.equals("", countryCode)) {
			isInternationalNumber = true;
		}
		return isInternationalNumber;
	}

	public static void main(String[] args) {
		System.out.println("getValidCountryCode："+getValidCountryCode("8"));
		System.out.println("isInternationalNumber："+isInternationalNumber("86"));
	}

}
