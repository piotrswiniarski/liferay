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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the appBody column in App.
 *
 * @author pisw
 * @see App
 * @generated
 */
@ProviderType
public class AppAppBodyBlobModel {
	public AppAppBodyBlobModel() {
	}

	public AppAppBodyBlobModel(long onlineAppId) {
		_onlineAppId = onlineAppId;
	}

	public AppAppBodyBlobModel(long onlineAppId, Blob appBodyBlob) {
		_onlineAppId = onlineAppId;
		_appBodyBlob = appBodyBlob;
	}

	public long getOnlineAppId() {
		return _onlineAppId;
	}

	public void setOnlineAppId(long onlineAppId) {
		_onlineAppId = onlineAppId;
	}

	public Blob getAppBodyBlob() {
		return _appBodyBlob;
	}

	public void setAppBodyBlob(Blob appBodyBlob) {
		_appBodyBlob = appBodyBlob;
	}

	private long _onlineAppId;
	private Blob _appBodyBlob;
}