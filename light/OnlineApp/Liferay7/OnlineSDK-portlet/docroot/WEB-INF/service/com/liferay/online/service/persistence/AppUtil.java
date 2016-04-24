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

import com.liferay.online.model.App;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the app service. This utility wraps {@link com.liferay.online.service.persistence.impl.AppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pisw
 * @see AppPersistence
 * @see com.liferay.online.service.persistence.impl.AppPersistenceImpl
 * @generated
 */
@ProviderType
public class AppUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(App app) {
		getPersistence().clearCache(app);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<App> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<App> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<App> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static App update(App app) {
		return getPersistence().update(app);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static App update(App app, ServiceContext serviceContext) {
		return getPersistence().update(app, serviceContext);
	}

	/**
	* Returns all the apps where appName = &#63;.
	*
	* @param appName the app name
	* @return the matching apps
	*/
	public static List<App> findByByAppName(java.lang.String appName) {
		return getPersistence().findByByAppName(appName);
	}

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
	public static List<App> findByByAppName(java.lang.String appName,
		int start, int end) {
		return getPersistence().findByByAppName(appName, start, end);
	}

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
	public static List<App> findByByAppName(java.lang.String appName,
		int start, int end, OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .findByByAppName(appName, start, end, orderByComparator);
	}

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
	public static List<App> findByByAppName(java.lang.String appName,
		int start, int end, OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByByAppName(appName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByAppName_First(java.lang.String appName,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().findByByAppName_First(appName, orderByComparator);
	}

	/**
	* Returns the first app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByAppName_First(java.lang.String appName,
		OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .fetchByByAppName_First(appName, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByAppName_Last(java.lang.String appName,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().findByByAppName_Last(appName, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where appName = &#63;.
	*
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByAppName_Last(java.lang.String appName,
		OrderByComparator<App> orderByComparator) {
		return getPersistence().fetchByByAppName_Last(appName, orderByComparator);
	}

	/**
	* Returns the apps before and after the current app in the ordered set where appName = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param appName the app name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public static App[] findByByAppName_PrevAndNext(long onlineAppId,
		java.lang.String appName, OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence()
				   .findByByAppName_PrevAndNext(onlineAppId, appName,
			orderByComparator);
	}

	/**
	* Removes all the apps where appName = &#63; from the database.
	*
	* @param appName the app name
	*/
	public static void removeByByAppName(java.lang.String appName) {
		getPersistence().removeByByAppName(appName);
	}

	/**
	* Returns the number of apps where appName = &#63;.
	*
	* @param appName the app name
	* @return the number of matching apps
	*/
	public static int countByByAppName(java.lang.String appName) {
		return getPersistence().countByByAppName(appName);
	}

	/**
	* Returns all the apps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching apps
	*/
	public static List<App> findByByGroupId(long groupId) {
		return getPersistence().findByByGroupId(groupId);
	}

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
	public static List<App> findByByGroupId(long groupId, int start, int end) {
		return getPersistence().findByByGroupId(groupId, start, end);
	}

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
	public static List<App> findByByGroupId(long groupId, int start, int end,
		OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .findByByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static List<App> findByByGroupId(long groupId, int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByGroupId_First(long groupId,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().findByByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByGroupId_First(long groupId,
		OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .fetchByByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByGroupId_Last(long groupId,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().findByByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByGroupId_Last(long groupId,
		OrderByComparator<App> orderByComparator) {
		return getPersistence().fetchByByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the apps before and after the current app in the ordered set where groupId = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public static App[] findByByGroupId_PrevAndNext(long onlineAppId,
		long groupId, OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence()
				   .findByByGroupId_PrevAndNext(onlineAppId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the apps where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByByGroupId(long groupId) {
		getPersistence().removeByByGroupId(groupId);
	}

	/**
	* Returns the number of apps where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching apps
	*/
	public static int countByByGroupId(long groupId) {
		return getPersistence().countByByGroupId(groupId);
	}

	/**
	* Returns all the apps where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @return the matching apps
	*/
	public static List<App> findByByLanguage(java.lang.String appLanguage) {
		return getPersistence().findByByLanguage(appLanguage);
	}

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
	public static List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end) {
		return getPersistence().findByByLanguage(appLanguage, start, end);
	}

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
	public static List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end, OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .findByByLanguage(appLanguage, start, end, orderByComparator);
	}

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
	public static List<App> findByByLanguage(java.lang.String appLanguage,
		int start, int end, OrderByComparator<App> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByByLanguage(appLanguage, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByLanguage_First(java.lang.String appLanguage,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence()
				   .findByByLanguage_First(appLanguage, orderByComparator);
	}

	/**
	* Returns the first app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByLanguage_First(java.lang.String appLanguage,
		OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .fetchByByLanguage_First(appLanguage, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app
	* @throws NoSuchAppException if a matching app could not be found
	*/
	public static App findByByLanguage_Last(java.lang.String appLanguage,
		OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence()
				   .findByByLanguage_Last(appLanguage, orderByComparator);
	}

	/**
	* Returns the last app in the ordered set where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching app, or <code>null</code> if a matching app could not be found
	*/
	public static App fetchByByLanguage_Last(java.lang.String appLanguage,
		OrderByComparator<App> orderByComparator) {
		return getPersistence()
				   .fetchByByLanguage_Last(appLanguage, orderByComparator);
	}

	/**
	* Returns the apps before and after the current app in the ordered set where appLanguage = &#63;.
	*
	* @param onlineAppId the primary key of the current app
	* @param appLanguage the app language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public static App[] findByByLanguage_PrevAndNext(long onlineAppId,
		java.lang.String appLanguage, OrderByComparator<App> orderByComparator)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence()
				   .findByByLanguage_PrevAndNext(onlineAppId, appLanguage,
			orderByComparator);
	}

	/**
	* Removes all the apps where appLanguage = &#63; from the database.
	*
	* @param appLanguage the app language
	*/
	public static void removeByByLanguage(java.lang.String appLanguage) {
		getPersistence().removeByByLanguage(appLanguage);
	}

	/**
	* Returns the number of apps where appLanguage = &#63;.
	*
	* @param appLanguage the app language
	* @return the number of matching apps
	*/
	public static int countByByLanguage(java.lang.String appLanguage) {
		return getPersistence().countByByLanguage(appLanguage);
	}

	/**
	* Caches the app in the entity cache if it is enabled.
	*
	* @param app the app
	*/
	public static void cacheResult(App app) {
		getPersistence().cacheResult(app);
	}

	/**
	* Caches the apps in the entity cache if it is enabled.
	*
	* @param apps the apps
	*/
	public static void cacheResult(List<App> apps) {
		getPersistence().cacheResult(apps);
	}

	/**
	* Creates a new app with the primary key. Does not add the app to the database.
	*
	* @param onlineAppId the primary key for the new app
	* @return the new app
	*/
	public static App create(long onlineAppId) {
		return getPersistence().create(onlineAppId);
	}

	/**
	* Removes the app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param onlineAppId the primary key of the app
	* @return the app that was removed
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public static App remove(long onlineAppId)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().remove(onlineAppId);
	}

	public static App updateImpl(App app) {
		return getPersistence().updateImpl(app);
	}

	/**
	* Returns the app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	*
	* @param onlineAppId the primary key of the app
	* @return the app
	* @throws NoSuchAppException if a app with the primary key could not be found
	*/
	public static App findByPrimaryKey(long onlineAppId)
		throws com.liferay.online.exception.NoSuchAppException {
		return getPersistence().findByPrimaryKey(onlineAppId);
	}

	/**
	* Returns the app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param onlineAppId the primary key of the app
	* @return the app, or <code>null</code> if a app with the primary key could not be found
	*/
	public static App fetchByPrimaryKey(long onlineAppId) {
		return getPersistence().fetchByPrimaryKey(onlineAppId);
	}

	public static java.util.Map<java.io.Serializable, App> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the apps.
	*
	* @return the apps
	*/
	public static List<App> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<App> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<App> findAll(int start, int end,
		OrderByComparator<App> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<App> findAll(int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the apps from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of apps.
	*
	* @return the number of apps
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AppPersistence)PortletBeanLocatorUtil.locate(com.liferay.online.service.ClpSerializer.getServletContextName(),
					AppPersistence.class.getName());

			ReferenceRegistry.registerReference(AppUtil.class, "_persistence");
		}

		return _persistence;
	}

	private static AppPersistence _persistence;
}