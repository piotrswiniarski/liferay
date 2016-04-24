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

import com.liferay.online.service.AppLocalServiceUtil;
import com.liferay.online.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class AppClp extends BaseModelImpl<App> implements App {
	public AppClp() {
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
	public long getPrimaryKey() {
		return _onlineAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOnlineAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _onlineAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getOnlineAppId() {
		return _onlineAppId;
	}

	@Override
	public void setOnlineAppId(long onlineAppId) {
		_onlineAppId = onlineAppId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setOnlineAppId", long.class);

				method.invoke(_appRemoteModel, onlineAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppName() {
		return _appName;
	}

	@Override
	public void setAppName(String appName) {
		_appName = appName;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setAppName", String.class);

				method.invoke(_appRemoteModel, appName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppBody() {
		return _appBody;
	}

	@Override
	public void setAppBody(String appBody) {
		_appBody = appBody;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setAppBody", String.class);

				method.invoke(_appRemoteModel, appBody);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_appRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_appRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_appRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_appRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_appRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_appRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppDescription() {
		return _appDescription;
	}

	@Override
	public void setAppDescription(String appDescription) {
		_appDescription = appDescription;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setAppDescription",
						String.class);

				method.invoke(_appRemoteModel, appDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppLanguage() {
		return _appLanguage;
	}

	@Override
	public void setAppLanguage(String appLanguage) {
		_appLanguage = appLanguage;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setAppLanguage", String.class);

				method.invoke(_appRemoteModel, appLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRelease() {
		return _release;
	}

	@Override
	public void setRelease(String release) {
		_release = release;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setRelease", String.class);

				method.invoke(_appRemoteModel, release);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLive() {
		return _live;
	}

	@Override
	public boolean isLive() {
		return _live;
	}

	@Override
	public void setLive(boolean live) {
		_live = live;

		if (_appRemoteModel != null) {
			try {
				Class<?> clazz = _appRemoteModel.getClass();

				Method method = clazz.getMethod("setLive", boolean.class);

				method.invoke(_appRemoteModel, live);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAppRemoteModel() {
		return _appRemoteModel;
	}

	public void setAppRemoteModel(BaseModel<?> appRemoteModel) {
		_appRemoteModel = appRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _appRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_appRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			AppLocalServiceUtil.addApp(this);
		}
		else {
			AppLocalServiceUtil.updateApp(this);
		}
	}

	@Override
	public App toEscapedModel() {
		return (App)ProxyUtil.newProxyInstance(App.class.getClassLoader(),
			new Class[] { App.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AppClp clone = new AppClp();

		clone.setOnlineAppId(getOnlineAppId());
		clone.setAppName(getAppName());
		clone.setAppBody(getAppBody());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAppDescription(getAppDescription());
		clone.setAppLanguage(getAppLanguage());
		clone.setRelease(getRelease());
		clone.setLive(getLive());

		return clone;
	}

	@Override
	public int compareTo(App app) {
		long primaryKey = app.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppClp)) {
			return false;
		}

		AppClp app = (AppClp)obj;

		long primaryKey = app.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{onlineAppId=");
		sb.append(getOnlineAppId());
		sb.append(", appName=");
		sb.append(getAppName());
		sb.append(", appBody=");
		sb.append(getAppBody());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", appDescription=");
		sb.append(getAppDescription());
		sb.append(", appLanguage=");
		sb.append(getAppLanguage());
		sb.append(", release=");
		sb.append(getRelease());
		sb.append(", live=");
		sb.append(getLive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.online.model.App");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>onlineAppId</column-name><column-value><![CDATA[");
		sb.append(getOnlineAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appName</column-name><column-value><![CDATA[");
		sb.append(getAppName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appBody</column-name><column-value><![CDATA[");
		sb.append(getAppBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appDescription</column-name><column-value><![CDATA[");
		sb.append(getAppDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appLanguage</column-name><column-value><![CDATA[");
		sb.append(getAppLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>release</column-name><column-value><![CDATA[");
		sb.append(getRelease());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>live</column-name><column-value><![CDATA[");
		sb.append(getLive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _appRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.online.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}