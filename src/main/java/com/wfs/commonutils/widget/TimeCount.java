package com.wfs.commonutils.widget;

import android.os.CountDownTimer;
import android.widget.TextView;
/**
 * 
 * @ClassName: TimeCount 
 * @Description: 倒计时
 * @author WangFusheng 
 * @date 2015年11月18日 上午11:34:19
 */
public class TimeCount extends CountDownTimer {
	TextView reSend;
		public TimeCount(long millisInFuture, long countDownInterval,TextView tv) {
			super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
			this.reSend = tv;
		}
		@Override
		public void onFinish() {//计时完毕时触发
			reSend.setText("重新发送");
			reSend.setClickable(true);
		}
		@Override
		public void onTick(long millisUntilFinished){//计时过程显示
			reSend.setClickable(false);
			reSend.setText(millisUntilFinished /1000+"秒");
		}
		}