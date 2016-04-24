/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.online.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.online.service.http.AppServiceSoap}.
 *
 * @author pisw
 * @see com.liferay.online.service.http.AppServiceSoap
 * @generated
 */
@ProviderType
public class AppSoap implements Serializable {
	public static AppSoap toSoapModel(App model) {
		AppSoap soapModel = new AppSoap();

		soapModel.setOnlineAppId(model.getOnlineAppId());
		soapModel.setAppName(model.getAppName());
		soapModel.setAppBody(model.getAppBody());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAppDescription(model.getAppDescription());
		soapModel.setAppLanguage(model.getAppLanguage());
		soapModel.setRelease(model.getRelease());
		soapModel.setLive(model.getLive());

		return soapModel;
	}

	public static AppSoap[] toSoapModels(App[] models) {
		AppSoap[] soapModels = new AppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AppSoap[][] toSoapModels(App[][] models) {
		AppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AppSoap[] toSoapModels(List<App> models) {
		List<AppSoap> soapModels = new ArrayList<AppSoap>(models.size());

		for (App model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AppSoap[soapModels.size()]);
	}

	public AppSoap() {
	}

	public long getPrimaryKey() {
		return _onlineAppId;
	}

	public void setPrimaryKey(long pk) {
		setOnlineAppId(pk);
	}

	public long getOnlineAppId() {
		return _onlineAppId;
	}

	public void setOnlineAppId(long onlineAppId) {
		_onlineAppId = onlineAppId;
	}

	public String getAppName() {
		return _appName;
	}

	public void setAppName(String appName) {
		_appName = appName;
	}

	public String getAppBody() {
		return _appBody;
	}

	public void setAppBody(String appBody) {
		_appBody = appBody;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAppDescription() {
		return _appDescription;
	}

	public void setAppDescription(String appDescription) {
		_appDescription = appDescription;
	}

	public String getAppLanguage() {
		return _appLanguage;
	}

	public void setAppLanguage(String appLanguage) {
		_appLanguage = appLanguage;
	}

	public String getRelease() {
		return _release;
	}

	public void setRelease(String release) {
		_release = release;
	}

	public boolean getLive() {
		return _live;
	}

	public boolean isLive() {
		return _live;
	}

	public void setLive(boolean live) {
		_live = live;
	}

	private long _onlineAppId;
	private String _appName;
	private String _appBody;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _appDescription;
	private String _appLanguage;
	private String _release;
	private boolean _live;
}