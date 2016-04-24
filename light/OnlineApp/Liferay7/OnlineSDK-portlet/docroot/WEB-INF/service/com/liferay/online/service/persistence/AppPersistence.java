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

package com.liferay.online.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.online.exception.NoSuchAppException;
import com.liferay.online.model.App;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pisw
 * @see com.liferay.online.service.persistence.impl.AppPersistenceImpl
 * @see AppUtil
 * @generated
 */
@ProviderType
public interface AppPersistence extends BasePersistence<App> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AppUtil} to access the app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the apps where appName = &#63;.
	*
	* @param appName the app name
	* @return the matching apps
	*/
	public java.util.List<App> findByByAppName(java.lang.String appName);

	/**
	* Returns a range of all the apps where appName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appName the app name
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @return the range of matching apps
	*/
	public java.util.List<App> findByByAppName(java.lang.String appName,
		int start, int end);

	/**
	* Returns an ordered range of all the apps where appName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appName the app name
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByAppName(java.lang.String appName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns an ordered range of all the apps where appName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appName the app name
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByAppName(java.lang.String appName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByAppName_First(java.lang.String appName,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByAppName_First(java.lang.String appName,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the last app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByAppName_Last(java.lang.String appName,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByAppName_Last(java.lang.String appName,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the apps before and after the current app in the ordered set where appName = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public App[] findByByAppName_PrevAndNext(long onlineAppId,
		java.lang.String appName,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the apps where appName = &#63; from the database.
	*
	* @param appName the app name
	*/
	public void removeByByAppName(java.lang.String appName);

	/**
	* Returns the number of apps where appName = &#63;.
	*
	* @param appName the app name
	* @return the number of matching apps
	*/
	public int countByByAppName(java.lang.String appName);

	/**
	* Returns all the apps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching apps
	*/
	public java.util.List<App> findByByGroupId(long groupId);

	/**
	* Returns a range of all the apps where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @return the range of matching apps
	*/
	public java.util.List<App> findByByGroupId(long groupId, int start, int end);

	/**
	* Returns an ordered range of all the apps where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns an ordered range of all the apps where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the last app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the apps before and after the current app in the ordered set where groupId = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public App[] findByByGroupId_PrevAndNext(long onlineAppId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the apps where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByByGroupId(long groupId);

	/**
	* Returns the number of apps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching apps
	*/
	public int countByByGroupId(long groupId);

	/**
	* Returns all the apps where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @return the matching apps
	*/
	public java.util.List<App> findByByLanguage(java.lang.String appLanguage);

	/**
	* Returns a range of all the apps where appLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appLanguage the app language
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @return the range of matching apps
	*/
	public java.util.List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end);

	/**
	* Returns an ordered range of all the apps where appLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appLanguage the app language
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns an ordered range of all the apps where appLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appLanguage the app language
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching apps
	*/
	public java.util.List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByLanguage_First(java.lang.String appLanguage,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the first app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByLanguage_First(java.lang.String appLanguage,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the last app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public App findByByLanguage_Last(java.lang.String appLanguage,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Returns the last app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public App fetchByByLanguage_Last(java.lang.String appLanguage,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns the apps before and after the current app in the ordered set where appLanguage = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public App[] findByByLanguage_PrevAndNext(long onlineAppId,
		java.lang.String appLanguage,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator)
		throws NoSuchAppException;

	/**
	* Removes all the apps where appLanguage = &#63; from the database.
	*
	* @param appLanguage the app language
	*/
	public void removeByByLanguage(java.lang.String appLanguage);

	/**
	* Returns the number of apps where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @return the number of matching apps
	*/
	public int countByByLanguage(java.lang.String appLanguage);

	/**
	* Caches the app in the entity cache if it is enabled.
	*
	* @param app the app
	*/
	public void cacheResult(App app);

	/**
	* Caches the apps in the entity cache if it is enabled.
	*
	* @param apps the apps
	*/
	public void cacheResult(java.util.List<App> apps);

	/**
	* Creates a new app with the primary key. Does not add the app to the database.
	*
	* @param onlineAppId the primary key for the new app
	* @return the new app
	*/
	public App create(long onlineAppId);

	/**
	* Removes the app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param onlineAppId the primary key of the app
	* @return the app that was removed
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public App remove(long onlineAppId) throws NoSuchAppException;

	public App updateImpl(App app);

	/**
	* Returns the app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	*
	* @param onlineAppId the primary key of the app
	* @return the app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public App findByPrimaryKey(long onlineAppId) throws NoSuchAppException;

	/**
	* Returns the app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param onlineAppId the primary key of the app
	* @return the app, or <code>null</code> if a app with the primary key could not be found
	*/
	public App fetchByPrimaryKey(long onlineAppId);

	@Override
	public java.util.Map<java.io.Serializable, App> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the apps.
	*
	* @return the apps
	*/
	public java.util.List<App> findAll();

	/**
	* Returns a range of all the apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @return the range of apps
	*/
	public java.util.List<App> findAll(int start, int end);

	/**
	* Returns an ordered range of all the apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of apps
	*/
	public java.util.List<App> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator);

	/**
	* Returns an ordered range of all the apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apps
	* @param end the upper bound of the range of apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of apps
	*/
	public java.util.List<App> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the apps from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of apps.
	*
	* @return the number of apps
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}