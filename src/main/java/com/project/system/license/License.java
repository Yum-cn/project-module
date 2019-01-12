/*
 * Copyright (C) 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.project.system.license;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Class for storing license data. It can store any number of features and their values like <code>Properties</code>.
 *
 * @author Decebal Suiu
 */
public class License {

    public static final String EXPIRATION_DATE = "expirationDate";
    public static final String LIMIT_NUMBER = "number";
    public static final String MAC_ADDRESS = "macAddress";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Properties features;

    public License(Properties features) throws LicenseException {
        this.features = features;
    }

    public Date getExpirationDate() {
        try {
            return DATE_FORMAT.parse(getFeature(EXPIRATION_DATE));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getExpirationDateAsString() {
        return getFeature(EXPIRATION_DATE);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > getExpirationDate().getTime();
    }
    
    public boolean isLocalMachine() {
    	String mac = "";
		try {
			InetAddress ia = InetAddress.getLocalHost();
			mac = LocalMac.getLocalMac(ia);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	String fileMacAddress = getFeature(MAC_ADDRESS);
    	if(StringUtils.isNotBlank(fileMacAddress)&&StringUtils.isNotBlank(mac)){
    		return StringUtils.equals(mac, fileMacAddress);
    	}else{
    		return true;
    	}
    	
    }

    public int getDaysTillExpire() {
        return DateUtils.getNumberOfDays(new Date(), getExpirationDate());
    }

    public String getFeature(String name) {
        return features.getProperty(name);
    }

    public List<String> getFeatureNames() {
        List<String> featureNames = new ArrayList<>();
        Enumeration<?> keys = features.propertyNames();
        while (keys.hasMoreElements()) {
            featureNames.add((String) keys.nextElement());
        }

        return featureNames;
    }

    @Override
    public String toString() {
        return features.toString();
    }

}
