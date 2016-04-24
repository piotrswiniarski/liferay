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

package com.liferay.online.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.online.model.App;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing App in entity cache.
 *
 * @author pisw
 * @see App
 * @generated
 */
@ProviderType
public class AppCacheModel implements CacheModel<App>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AppCacheModel)) {
			return false;
		}

		AppCacheModel appCacheModel = (AppCacheModel)obj;

		if (onlineAppId == appCacheModel.onlineAppId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, onlineAppId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{onlineAppId=");
		sb.append(onlineAppId);
		sb.append(", appName=");
		sb.append(appName);
		sb.append(", appBody=");
		sb.append(appBody);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", appDescription=");
		sb.append(appDescription);
		sb.append(", appLanguage=");
		sb.append(appLanguage);
		sb.append(", release=");
		sb.append(release);
		sb.append(", live=");
		sb.append(live);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public App toEntityModel() {
		AppImpl appImpl = new AppImpl();

		appImpl.setOnlineAppId(onlineAppId);

		if (appName == null) {
			appImpl.setAppName(StringPool.BLANK);
		}
		else {
			appImpl.setAppName(appName);
		}

		if (appBody == null) {
			appImpl.setAppBody(StringPool.BLANK);
		}
		else {
			appImpl.setAppBody(appBody);
		}

		appImpl.setGroupId(groupId);
		appImpl.setCompanyId(companyId);
		appImpl.setUserId(userId);

		if (userName == null) {
			appImpl.setUserName(StringPool.BLANK);
		}
		else {
			appImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			appImpl.setCreateDate(null);
		}
		else {
			appImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			appImpl.setModifiedDate(null);
		}
		else {
			appImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (appDescription == null) {
			appImpl.setAppDescription(StringPool.BLANK);
		}
		else {
			appImpl.setAppDescription(appDescription);
		}

		if (appLanguage == null) {
			appImpl.setAppLanguage(StringPool.BLANK);
		}
		else {
			appImpl.setAppLanguage(appLanguage);
		}

		if (release == null) {
			appImpl.setRelease(StringPool.BLANK);
		}
		else {
			appImpl.setRelease(release);
		}

		appImpl.setLive(live);

		appImpl.resetOriginalValues();

		return appImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		onlineAppId = objectInput.readLong();
		appName = objectInput.readUTF();
		appBody = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		appDescription = objectInput.readUTF();
		appLanguage = objectInput.readUTF();
		release = objectInput.readUTF();

		live = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(onlineAppId);

		if (appName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appName);
		}

		if (appBody == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appBody);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (appDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appDescription);
		}

		if (appLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(appLanguage);
		}

		if (release == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(release);
		}

		objectOutput.writeBoolean(live);
	}

	public long onlineAppId;
	public String appName;
	public String appBody;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String appDescription;
	public String appLanguage;
	public String release;
	public boolean live;
}