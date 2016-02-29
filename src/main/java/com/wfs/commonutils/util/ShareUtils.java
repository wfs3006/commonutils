package com.wfs.commonutils.util;

import android.app.Activity;
import android.content.Intent;
/**
 * 
 * @ClassName: ShareUtils 
 * @Description: 分享辅助
 * @author WangFusheng 
 * @date 2015年9月1日 下午2:40:38
 */
public class ShareUtils {
	/**
	 * 调用系统安装了的应用分享
	 * @param context
	 * @param title
	 * @param url
	 */
	public static void showShareMore(Activity context, final String title,
			final String url) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "分享：" + title);
		intent.putExtra(Intent.EXTRA_TEXT, title + " " + url);
		context.startActivity(Intent.createChooser(intent, "选择分享"));
	}
}
