package com.wfs.commonutils.widget;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
/**
 * 
 * @ClassName: MyListView 
 * @Description: 此ListView被嵌入ScrollView后能自动适配
 * @author WangFusheng 
 * @date 2015年9月1日 下午2:56:57
 */
public class MyListView extends ListView {

	public MyListView(Context context) {
		super(context);

	}

	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public MyListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
		MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

}