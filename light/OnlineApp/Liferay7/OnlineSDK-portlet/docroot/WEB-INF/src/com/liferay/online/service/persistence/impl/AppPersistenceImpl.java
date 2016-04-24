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

package com.liferay.online.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.online.exception.NoSuchAppException;
import com.liferay.online.model.App;
import com.liferay.online.model.impl.AppImpl;
import com.liferay.online.model.impl.AppModelImpl;
import com.liferay.online.service.persistence.AppPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pisw
 * @see AppPersistence
 * @see com.liferay.online.service.persistence.AppUtil
 * @generated
 */
@ProviderType
public class AppPersistenceImpl extends BasePersistenceImpl<App>
	implements AppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AppUtil} to access the app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYAPPNAME =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByAppName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYAPPNAME =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByAppName",
			new String[] { String.class.getName() },
			AppModelImpl.APPNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYAPPNAME = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByAppName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the apps where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the matching apps
	 */
	@Override
	public List<App> findByByAppName(String appName) {
		return findByByAppName(appName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<App> findByByAppName(String appName, int start, int end) {
		return findByByAppName(appName, start, end, null);
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
	@Override
	public List<App> findByByAppName(String appName, int start, int end,
		OrderByComparator<App> orderByComparator) {
		return findByByAppName(appName, start, end, orderByComparator, true);
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
	@Override
	public List<App> findByByAppName(String appName, int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYAPPNAME;
			finderArgs = new Object[] { appName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYAPPNAME;
			finderArgs = new Object[] { appName, start, end, orderByComparator };
		}

		List<App> list = null;

		if (retrieveFromCache) {
			list = (List<App>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (App app : list) {
					if (!Validator.equals(appName, app.getAppName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APP_WHERE);

			boolean bindAppName = false;

			if (appName == null) {
				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_1);
			}
			else if (appName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_3);
			}
			else {
				bindAppName = true;

				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppName) {
					qPos.add(appName);
				}

				if (!pagination) {
					list = (List<App>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<App>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first app in the ordered set where appName = &#63;.
	 *
	 * @param appName the app name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByAppName_First(String appName,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByAppName_First(appName, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appName=");
		msg.append(appName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first app in the ordered set where appName = &#63;.
	 *
	 * @param appName the app name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByAppName_First(String appName,
		OrderByComparator<App> orderByComparator) {
		List<App> list = findByByAppName(appName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app in the ordered set where appName = &#63;.
	 *
	 * @param appName the app name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByAppName_Last(String appName,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByAppName_Last(appName, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appName=");
		msg.append(appName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last app in the ordered set where appName = &#63;.
	 *
	 * @param appName the app name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByAppName_Last(String appName,
		OrderByComparator<App> orderByComparator) {
		int count = countByByAppName(appName);

		if (count == 0) {
			return null;
		}

		List<App> list = findByByAppName(appName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public App[] findByByAppName_PrevAndNext(long onlineAppId, String appName,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = findByPrimaryKey(onlineAppId);

		Session session = null;

		try {
			session = openSession();

			App[] array = new AppImpl[3];

			array[0] = getByByAppName_PrevAndNext(session, app, appName,
					orderByComparator, true);

			array[1] = app;

			array[2] = getByByAppName_PrevAndNext(session, app, appName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected App getByByAppName_PrevAndNext(Session session, App app,
		String appName, OrderByComparator<App> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APP_WHERE);

		boolean bindAppName = false;

		if (appName == null) {
			query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_1);
		}
		else if (appName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_3);
		}
		else {
			bindAppName = true;

			query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppName) {
			qPos.add(appName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(app);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<App> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apps where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 */
	@Override
	public void removeByByAppName(String appName) {
		for (App app : findByByAppName(appName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(app);
		}
	}

	/**
	 * Returns the number of apps where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching apps
	 */
	@Override
	public int countByByAppName(String appName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYAPPNAME;

		Object[] finderArgs = new Object[] { appName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APP_WHERE);

			boolean bindAppName = false;

			if (appName == null) {
				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_1);
			}
			else if (appName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_3);
			}
			else {
				bindAppName = true;

				query.append(_FINDER_COLUMN_BYAPPNAME_APPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppName) {
					qPos.add(appName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYAPPNAME_APPNAME_1 = "app.appName IS NULL";
	private static final String _FINDER_COLUMN_BYAPPNAME_APPNAME_2 = "app.appName = ?";
	private static final String _FINDER_COLUMN_BYAPPNAME_APPNAME_3 = "(app.appName IS NULL OR app.appName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGROUPID =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPID =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByGroupId",
			new String[] { Long.class.getName() },
			AppModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYGROUPID = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching apps
	 */
	@Override
	public List<App> findByByGroupId(long groupId) {
		return findByByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<App> findByByGroupId(long groupId, int start, int end) {
		return findByByGroupId(groupId, start, end, null);
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
	@Override
	public List<App> findByByGroupId(long groupId, int start, int end,
		OrderByComparator<App> orderByComparator) {
		return findByByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<App> findByByGroupId(long groupId, int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYGROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<App> list = null;

		if (retrieveFromCache) {
			list = (List<App>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (App app : list) {
					if ((groupId != app.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APP_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<App>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<App>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByGroupId_First(long groupId,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByGroupId_First(groupId, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByGroupId_First(long groupId,
		OrderByComparator<App> orderByComparator) {
		List<App> list = findByByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByGroupId_Last(long groupId,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByGroupId_Last(groupId, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByGroupId_Last(long groupId,
		OrderByComparator<App> orderByComparator) {
		int count = countByByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<App> list = findByByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public App[] findByByGroupId_PrevAndNext(long onlineAppId, long groupId,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = findByPrimaryKey(onlineAppId);

		Session session = null;

		try {
			session = openSession();

			App[] array = new AppImpl[3];

			array[0] = getByByGroupId_PrevAndNext(session, app, groupId,
					orderByComparator, true);

			array[1] = app;

			array[2] = getByByGroupId_PrevAndNext(session, app, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected App getByByGroupId_PrevAndNext(Session session, App app,
		long groupId, OrderByComparator<App> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APP_WHERE);

		query.append(_FINDER_COLUMN_BYGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(app);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<App> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByByGroupId(long groupId) {
		for (App app : findByByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(app);
		}
	}

	/**
	 * Returns the number of apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching apps
	 */
	@Override
	public int countByByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYGROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APP_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYGROUPID_GROUPID_2 = "app.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYLANGUAGE =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByLanguage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYLANGUAGE =
		new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, AppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByLanguage",
			new String[] { String.class.getName() },
			AppModelImpl.APPLANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYLANGUAGE = new FinderPath(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByLanguage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the apps where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @return the matching apps
	 */
	@Override
	public List<App> findByByLanguage(String appLanguage) {
		return findByByLanguage(appLanguage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<App> findByByLanguage(String appLanguage, int start, int end) {
		return findByByLanguage(appLanguage, start, end, null);
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
	@Override
	public List<App> findByByLanguage(String appLanguage, int start, int end,
		OrderByComparator<App> orderByComparator) {
		return findByByLanguage(appLanguage, start, end, orderByComparator, true);
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
	@Override
	public List<App> findByByLanguage(String appLanguage, int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYLANGUAGE;
			finderArgs = new Object[] { appLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYLANGUAGE;
			finderArgs = new Object[] { appLanguage, start, end, orderByComparator };
		}

		List<App> list = null;

		if (retrieveFromCache) {
			list = (List<App>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (App app : list) {
					if (!Validator.equals(appLanguage, app.getAppLanguage())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APP_WHERE);

			boolean bindAppLanguage = false;

			if (appLanguage == null) {
				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_1);
			}
			else if (appLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_3);
			}
			else {
				bindAppLanguage = true;

				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppLanguage) {
					qPos.add(appLanguage);
				}

				if (!pagination) {
					list = (List<App>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<App>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first app in the ordered set where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByLanguage_First(String appLanguage,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByLanguage_First(appLanguage, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appLanguage=");
		msg.append(appLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the first app in the ordered set where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByLanguage_First(String appLanguage,
		OrderByComparator<App> orderByComparator) {
		List<App> list = findByByLanguage(appLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last app in the ordered set where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app
	 * @throws NoSuchAppException if a matching app could not be found
	 */
	@Override
	public App findByByLanguage_Last(String appLanguage,
		OrderByComparator<App> orderByComparator) throws NoSuchAppException {
		App app = fetchByByLanguage_Last(appLanguage, orderByComparator);

		if (app != null) {
			return app;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appLanguage=");
		msg.append(appLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAppException(msg.toString());
	}

	/**
	 * Returns the last app in the ordered set where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching app, or <code>null</code> if a matching app could not be found
	 */
	@Override
	public App fetchByByLanguage_Last(String appLanguage,
		OrderByComparator<App> orderByComparator) {
		int count = countByByLanguage(appLanguage);

		if (count == 0) {
			return null;
		}

		List<App> list = findByByLanguage(appLanguage, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public App[] findByByLanguage_PrevAndNext(long onlineAppId,
		String appLanguage, OrderByComparator<App> orderByComparator)
		throws NoSuchAppException {
		App app = findByPrimaryKey(onlineAppId);

		Session session = null;

		try {
			session = openSession();

			App[] array = new AppImpl[3];

			array[0] = getByByLanguage_PrevAndNext(session, app, appLanguage,
					orderByComparator, true);

			array[1] = app;

			array[2] = getByByLanguage_PrevAndNext(session, app, appLanguage,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected App getByByLanguage_PrevAndNext(Session session, App app,
		String appLanguage, OrderByComparator<App> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APP_WHERE);

		boolean bindAppLanguage = false;

		if (appLanguage == null) {
			query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_1);
		}
		else if (appLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_3);
		}
		else {
			bindAppLanguage = true;

			query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppLanguage) {
			qPos.add(appLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(app);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<App> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apps where appLanguage = &#63; from the database.
	 *
	 * @param appLanguage the app language
	 */
	@Override
	public void removeByByLanguage(String appLanguage) {
		for (App app : findByByLanguage(appLanguage, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(app);
		}
	}

	/**
	 * Returns the number of apps where appLanguage = &#63;.
	 *
	 * @param appLanguage the app language
	 * @return the number of matching apps
	 */
	@Override
	public int countByByLanguage(String appLanguage) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYLANGUAGE;

		Object[] finderArgs = new Object[] { appLanguage };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APP_WHERE);

			boolean bindAppLanguage = false;

			if (appLanguage == null) {
				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_1);
			}
			else if (appLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_3);
			}
			else {
				bindAppLanguage = true;

				query.append(_FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppLanguage) {
					qPos.add(appLanguage);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_1 = "app.appLanguage IS NULL";
	private static final String _FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_2 = "app.appLanguage = ?";
	private static final String _FINDER_COLUMN_BYLANGUAGE_APPLANGUAGE_3 = "(app.appLanguage IS NULL OR app.appLanguage = '')";

	public AppPersistenceImpl() {
		setModelClass(App.class);
	}

	/**
	 * Caches the app in the entity cache if it is enabled.
	 *
	 * @param app the app
	 */
	@Override
	public void cacheResult(App app) {
		entityCache.putResult(AppModelImpl.ENTITY_CACHE_ENABLED, AppImpl.class,
			app.getPrimaryKey(), app);

		app.resetOriginalValues();
	}

	/**
	 * Caches the apps in the entity cache if it is enabled.
	 *
	 * @param apps the apps
	 */
	@Override
	public void cacheResult(List<App> apps) {
		for (App app : apps) {
			if (entityCache.getResult(AppModelImpl.ENTITY_CACHE_ENABLED,
						AppImpl.class, app.getPrimaryKey()) == null) {
				cacheResult(app);
			}
			else {
				app.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all apps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AppImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the app.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(App app) {
		entityCache.removeResult(AppModelImpl.ENTITY_CACHE_ENABLED,
			AppImpl.class, app.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<App> apps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (App app : apps) {
			entityCache.removeResult(AppModelImpl.ENTITY_CACHE_ENABLED,
				AppImpl.class, app.getPrimaryKey());
		}
	}

	/**
	 * Creates a new app with the primary key. Does not add the app to the database.
	 *
	 * @param onlineAppId the primary key for the new app
	 * @return the new app
	 */
	@Override
	public App create(long onlineAppId) {
		App app = new AppImpl();

		app.setNew(true);
		app.setPrimaryKey(onlineAppId);

		app.setCompanyId(companyProvider.getCompanyId());

		return app;
	}

	/**
	 * Removes the app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param onlineAppId the primary key of the app
	 * @return the app that was removed
	 * @throws NoSuchAppException if a app with the primary key could not be found
	 */
	@Override
	public App remove(long onlineAppId) throws NoSuchAppException {
		return remove((Serializable)onlineAppId);
	}

	/**
	 * Removes the app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the app
	 * @return the app that was removed
	 * @throws NoSuchAppException if a app with the primary key could not be found
	 */
	@Override
	public App remove(Serializable primaryKey) throws NoSuchAppException {
		Session session = null;

		try {
			session = openSession();

			App app = (App)session.get(AppImpl.class, primaryKey);

			if (app == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(app);
		}
		catch (NoSuchAppException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected App removeImpl(App app) {
		app = toUnwrappedModel(app);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(app)) {
				app = (App)session.get(AppImpl.class, app.getPrimaryKeyObj());
			}

			if (app != null) {
				session.delete(app);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (app != null) {
			clearCache(app);
		}

		return app;
	}

	@Override
	public App updateImpl(App app) {
		app = toUnwrappedModel(app);

		boolean isNew = app.isNew();

		AppModelImpl appModelImpl = (AppModelImpl)app;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (app.getCreateDate() == null)) {
			if (serviceContext == null) {
				app.setCreateDate(now);
			}
			else {
				app.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!appModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				app.setModifiedDate(now);
			}
			else {
				app.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (app.isNew()) {
				session.save(app);

				app.setNew(false);
			}
			else {
				app = (App)session.merge(app);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AppModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((appModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYAPPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { appModelImpl.getOriginalAppName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYAPPNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYAPPNAME,
					args);

				args = new Object[] { appModelImpl.getAppName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYAPPNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYAPPNAME,
					args);
			}

			if ((appModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { appModelImpl.getOriginalGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYGROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPID,
					args);

				args = new Object[] { appModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYGROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYGROUPID,
					args);
			}

			if ((appModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYLANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						appModelImpl.getOriginalAppLanguage()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYLANGUAGE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYLANGUAGE,
					args);

				args = new Object[] { appModelImpl.getAppLanguage() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BYLANGUAGE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYLANGUAGE,
					args);
			}
		}

		entityCache.putResult(AppModelImpl.ENTITY_CACHE_ENABLED, AppImpl.class,
			app.getPrimaryKey(), app, false);

		app.resetOriginalValues();

		return app;
	}

	protected App toUnwrappedModel(App app) {
		if (app instanceof AppImpl) {
			return app;
		}

		AppImpl appImpl = new AppImpl();

		appImpl.setNew(app.isNew());
		appImpl.setPrimaryKey(app.getPrimaryKey());

		appImpl.setOnlineAppId(app.getOnlineAppId());
		appImpl.setAppName(app.getAppName());
		appImpl.setAppBody(app.getAppBody());
		appImpl.setGroupId(app.getGroupId());
		appImpl.setCompanyId(app.getCompanyId());
		appImpl.setUserId(app.getUserId());
		appImpl.setUserName(app.getUserName());
		appImpl.setCreateDate(app.getCreateDate());
		appImpl.setModifiedDate(app.getModifiedDate());
		appImpl.setAppDescription(app.getAppDescription());
		appImpl.setAppLanguage(app.getAppLanguage());
		appImpl.setRelease(app.getRelease());
		appImpl.setLive(app.isLive());

		return appImpl;
	}

	/**
	 * Returns the app with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the app
	 * @return the app
	 * @throws NoSuchAppException if a app with the primary key could not be found
	 */
	@Override
	public App findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAppException {
		App app = fetchByPrimaryKey(primaryKey);

		if (app == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return app;
	}

	/**
	 * Returns the app with the primary key or throws a {@link NoSuchAppException} if it could not be found.
	 *
	 * @param onlineAppId the primary key of the app
	 * @return the app
	 * @throws NoSuchAppException if a app with the primary key could not be found
	 */
	@Override
	public App findByPrimaryKey(long onlineAppId) throws NoSuchAppException {
		return findByPrimaryKey((Serializable)onlineAppId);
	}

	/**
	 * Returns the app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the app
	 * @return the app, or <code>null</code> if a app with the primary key could not be found
	 */
	@Override
	public App fetchByPrimaryKey(Serializable primaryKey) {
		App app = (App)entityCache.getResult(AppModelImpl.ENTITY_CACHE_ENABLED,
				AppImpl.class, primaryKey);

		if (app == _nullApp) {
			return null;
		}

		if (app == null) {
			Session session = null;

			try {
				session = openSession();

				app = (App)session.get(AppImpl.class, primaryKey);

				if (app != null) {
					cacheResult(app);
				}
				else {
					entityCache.putResult(AppModelImpl.ENTITY_CACHE_ENABLED,
						AppImpl.class, primaryKey, _nullApp);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AppModelImpl.ENTITY_CACHE_ENABLED,
					AppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return app;
	}

	/**
	 * Returns the app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param onlineAppId the primary key of the app
	 * @return the app, or <code>null</code> if a app with the primary key could not be found
	 */
	@Override
	public App fetchByPrimaryKey(long onlineAppId) {
		return fetchByPrimaryKey((Serializable)onlineAppId);
	}

	@Override
	public Map<Serializable, App> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, App> map = new HashMap<Serializable, App>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			App app = fetchByPrimaryKey(primaryKey);

			if (app != null) {
				map.put(primaryKey, app);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			App app = (App)entityCache.getResult(AppModelImpl.ENTITY_CACHE_ENABLED,
					AppImpl.class, primaryKey);

			if (app == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, app);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (App app : (List<App>)q.list()) {
				map.put(app.getPrimaryKeyObj(), app);

				cacheResult(app);

				uncachedPrimaryKeys.remove(app.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AppModelImpl.ENTITY_CACHE_ENABLED,
					AppImpl.class, primaryKey, _nullApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the apps.
	 *
	 * @return the apps
	 */
	@Override
	public List<App> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<App> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<App> findAll(int start, int end,
		OrderByComparator<App> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<App> findAll(int start, int end,
		OrderByComparator<App> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<App> list = null;

		if (retrieveFromCache) {
			list = (List<App>)finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APP;

				if (pagination) {
					sql = sql.concat(AppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<App>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<App>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the apps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (App app : findAll()) {
			remove(app);
		}
	}

	/**
	 * Returns the number of apps.
	 *
	 * @return the number of apps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AppModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the app persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AppImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APP = "SELECT app FROM App app";
	private static final String _SQL_SELECT_APP_WHERE_PKS_IN = "SELECT app FROM App app WHERE onlineAppId IN (";
	private static final String _SQL_SELECT_APP_WHERE = "SELECT app FROM App app WHERE ";
	private static final String _SQL_COUNT_APP = "SELECT COUNT(app) FROM App app";
	private static final String _SQL_COUNT_APP_WHERE = "SELECT COUNT(app) FROM App app WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "app.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No App exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No App exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AppPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"release"
			});
	private static final App _nullApp = new AppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<App> toCacheModel() {
				return _nullAppCacheModel;
			}
		};

	private static final CacheModel<App> _nullAppCacheModel = new CacheModel<App>() {
			@Override
			public App toEntityModel() {
				return _nullApp;
			}
		};
}