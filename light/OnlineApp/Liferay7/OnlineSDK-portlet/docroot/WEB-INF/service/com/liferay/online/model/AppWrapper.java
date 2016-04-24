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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link App}.
 * </p>
 *
 * @author pisw
 * @see App
 * @generated
 */
@ProviderType
public class AppWrapper implements App, ModelWrapper<App> {
	public AppWrapper(App app) {
		_app = app;
	}

	@Override
	public Class<?> getModelClass() {
		return App.class;
	}

	@Override
	public String getModelClassName() {
		return App.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("onlineAppId", getOnlineAppId());
		attributes.put("appName", getAppName());
		attributes.put("appBody", getAppBody());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("appDescription", getAppDescription());
		attributes.put("appLanguage", getAppLanguage());
		attributes.put("release", getRelease());
		attributes.put("live", getLive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long onlineAppId = (Long)attributes.get("onlineAppId");

		if (onlineAppId != null) {
			setOnlineAppId(onlineAppId);
		}

		String appName = (String)attributes.get("appName");

		if (appName != null) {
			setAppName(appName);
		}

		String appBody = (String)attributes.get("appBody");

		if (appBody != null) {
			setAppBody(appBody);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String appDescription = (String)attributes.get("appDescription");

		if (appDescription != null) {
			setAppDescription(appDescription);
		}

		String appLanguage = (String)attributes.get("appLanguage");

		if (appLanguage != null) {
			setAppLanguage(appLanguage);
		}

		String release = (String)attributes.get("release");

		if (release != null) {
			setRelease(release);
		}

		Boolean live = (Boolean)attributes.get("live");

		if (live != null) {
			setLive(live);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new AppWrapper((App)_app.clone());
	}

	@Override
	public int compareTo(com.liferay.online.model.App app) {
		return _app.compareTo(app);
	}

	/**
	* Returns the app body of this app.
	*
	* @return the app body of this app
	*/
	@Override
	public java.lang.String getAppBody() {
		return _app.getAppBody();
	}

	/**
	* Returns the app description of this app.
	*
	* @return the app description of this app
	*/
	@Override
	public java.lang.String getAppDescription() {
		return _app.getAppDescription();
	}

	/**
	* Returns the app language of this app.
	*
	* @return the app language of this app
	*/
	@Override
	public java.lang.String getAppLanguage() {
		return _app.getAppLanguage();
	}

	/**
	* Returns the app name of this app.
	*
	* @return the app name of this app
	*/
	@Override
	public java.lang.String getAppName() {
		return _app.getAppName();
	}

	/**
	* Returns the company ID of this app.
	*
	* @return the company ID of this app
	*/
	@Override
	public long getCompanyId() {
		return _app.getCompanyId();
	}

	/**
	* Returns the create date of this app.
	*
	* @return the create date of this app
	*/
	@Override
	public Date getCreateDate() {
		return _app.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _app.getExpandoBridge();
	}

	/**
	* Returns the group ID of this app.
	*
	* @return the group ID of this app
	*/
	@Override
	public long getGroupId() {
		return _app.getGroupId();
	}

	/**
	* Returns the live of this app.
	*
	* @return the live of this app
	*/
	@Override
	public boolean getLive() {
		return _app.getLive();
	}

	/**
	* Returns the modified date of this app.
	*
	* @return the modified date of this app
	*/
	@Override
	public Date getModifiedDate() {
		return _app.getModifiedDate();
	}

	/**
	* Returns the online app ID of this app.
	*
	* @return the online app ID of this app
	*/
	@Override
	public long getOnlineAppId() {
		return _app.getOnlineAppId();
	}

	/**
	* Returns the primary key of this app.
	*
	* @return the primary key of this app
	*/
	@Override
	public long getPrimaryKey() {
		return _app.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _app.getPrimaryKeyObj();
	}

	/**
	* Returns the release of this app.
	*
	* @return the release of this app
	*/
	@Override
	public java.lang.String getRelease() {
		return _app.getRelease();
	}

	/**
	* Returns the user ID of this app.
	*
	* @return the user ID of this app
	*/
	@Override
	public long getUserId() {
		return _app.getUserId();
	}

	/**
	* Returns the user name of this app.
	*
	* @return the user name of this app
	*/
	@Override
	public java.lang.String getUserName() {
		return _app.getUserName();
	}

	/**
	* Returns the user uuid of this app.
	*
	* @return the user uuid of this app
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _app.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _app.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _app.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _app.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this app is live.
	*
	* @return <code>true</code> if this app is live; <code>false</code> otherwise
	*/
	@Override
	public boolean isLive() {
		return _app.isLive();
	}

	@Override
	public boolean isNew() {
		return _app.isNew();
	}

	@Override
	public void persist() {
		_app.persist();
	}

	/**
	* Sets the app body of this app.
	*
	* @param appBody the app body of this app
	*/
	@Override
	public void setAppBody(java.lang.String appBody) {
		_app.setAppBody(appBody);
	}

	/**
	* Sets the app description of this app.
	*
	* @param appDescription the app description of this app
	*/
	@Override
	public void setAppDescription(java.lang.String appDescription) {
		_app.setAppDescription(appDescription);
	}

	/**
	* Sets the app language of this app.
	*
	* @param appLanguage the app language of this app
	*/
	@Override
	public void setAppLanguage(java.lang.String appLanguage) {
		_app.setAppLanguage(appLanguage);
	}

	/**
	* Sets the app name of this app.
	*
	* @param appName the app name of this app
	*/
	@Override
	public void setAppName(java.lang.String appName) {
		_app.setAppName(appName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_app.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this app.
	*
	* @param companyId the company ID of this app
	*/
	@Override
	public void setCompanyId(long companyId) {
		_app.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this app.
	*
	* @param createDate the create date of this app
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_app.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_app.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_app.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_app.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this app.
	*
	* @param groupId the group ID of this app
	*/
	@Override
	public void setGroupId(long groupId) {
		_app.setGroupId(groupId);
	}

	/**
	* Sets whether this app is live.
	*
	* @param live the live of this app
	*/
	@Override
	public void setLive(boolean live) {
		_app.setLive(live);
	}

	/**
	* Sets the modified date of this app.
	*
	* @param modifiedDate the modified date of this app
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_app.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_app.setNew(n);
	}

	/**
	* Sets the online app ID of this app.
	*
	* @param onlineAppId the online app ID of this app
	*/
	@Override
	public void setOnlineAppId(long onlineAppId) {
		_app.setOnlineAppId(onlineAppId);
	}

	/**
	* Sets the primary key of this app.
	*
	* @param primaryKey the primary key of this app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_app.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_app.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the release of this app.
	*
	* @param release the release of this app
	*/
	@Override
	public void setRelease(java.lang.String release) {
		_app.setRelease(release);
	}

	/**
	* Sets the user ID of this app.
	*
	* @param userId the user ID of this app
	*/
	@Override
	public void setUserId(long userId) {
		_app.setUserId(userId);
	}

	/**
	* Sets the user name of this app.
	*
	* @param userName the user name of this app
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_app.setUserName(userName);
	}

	/**
	* Sets the user uuid of this app.
	*
	* @param userUuid the user uuid of this app
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_app.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.online.model.App> toCacheModel() {
		return _app.toCacheModel();
	}

	@Override
	public com.liferay.online.model.App toEscapedModel() {
		return new AppWrapper(_app.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _app.toString();
	}

	@Override
	public com.liferay.online.model.App toUnescapedModel() {
		return new AppWrapper(_app.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _app.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppWrapper)) {
			return false;
		}

		AppWrapper appWrapper = (AppWrapper)obj;

		if (Validator.equals(_app, appWrapper._app)) {
			return true;
		}

		return false;
	}

	@Override
	public App getWrappedModel() {
		return _app;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _app.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _app.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_app.resetOriginalValues();
	}

	private final App _app;
}