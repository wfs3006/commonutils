package com.wfs.commonutils.app;

import java.util.List;

public class MyConstant {
	public static final String NET_CHANGE = "net_change";//网络状态改变
	public static final String NETWORK_STATE = "network_state";//网络状态
	public static final String NET_NULL="net_null";
	public static final String NET_WIFI="net_wifi";
	public static final String NET_2G="net_2g";
	public static final String NET_3G="net_3g";
	public static final String NET_4G="net_4g";
	public static final String NOT_CONNECT = "not_connect";//都没有连上 - 网络断开
	public static final String HTTP_URL_NULL="http_url_null";
	public static final String HTTP_NET_ERROR="http_net_error";
	public static final int FIRST = 0X0001;
	public static final int SECOND = 0X0002;
	public static final int THIRD = 0X0003;
	public static final int FORTH = 0X0004;
	public static final int FIFTH = 0X0005;
	public static final int SIX = 0X0006;
	/**
	 * 判断List是否为空,非空返回true,空则返回false
	 * 
	 * @param list
	 * @return boolean
	 */
	public static boolean listNotNull(List<?> list) {
		return (null != list)&&!list.isEmpty();
	}
	/**
	 * 判断对象是否为空,非空返回true,空则返回false
	 * 
	 * @param o
	 * @return boolean
	 */
	public static boolean objectNotNull(Object o) {
			return null != o;
	}

}
