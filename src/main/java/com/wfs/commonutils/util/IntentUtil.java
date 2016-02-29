package com.wfs.commonutils.util;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;

import java.io.File;

/**
 * 
 * @ClassName: IntentUtil 
 * @Description: TODO
 * @author WangFusheng 
 * @date 2015年9月1日 上午10:42:15
 */
public class IntentUtil {

    /**
     * 请求相册
     */
    public static final int REQUEST_CODE_GETIMAGE_BYSDCARD = 1;
    /**
     * 请求相机
     */
    public static final int REQUEST_CODE_GETIMAGE_BYCAMERA = 2;
    /**
     * 请求裁剪
     */
    public static final int REQUEST_CODE_GETIMAGE_BYCROP = 3;
    /**
     * 请求视频
     */
    public static final int REQUEST_CODE_GETVIDEO = 4;
    /**
     * 请求音频
     */
    public static final int REQUEST_CODE_GETAUDIO = 5;

    /**
     * 启动相机
     *
     * @param context
     */
    public static void startCamera(Context context, File picture) {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {// 判断是否有SD卡
            Intent intent0 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent0.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(picture));
            ((Activity) context).startActivityForResult(intent0, REQUEST_CODE_GETIMAGE_BYCAMERA);
        } else {
            Toast.makeText(context, "没有SD卡", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 启动相册
     *
     * @param context
     */
    public static void startGallery(Context context) {
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        ((Activity) context).startActivityForResult(intent, REQUEST_CODE_GETIMAGE_BYSDCARD);
    }

    /**
     * 系统剪切
     *
     * @param uri
     */
    public static void startPhotoCrop(Uri uri, Context context) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        ((Activity) context).startActivityForResult(intent, REQUEST_CODE_GETIMAGE_BYCROP);
    }

    public static void startVideo(Context context) {
        Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        innerIntent.setType("video/*");
        Intent wrapperIntent = Intent.createChooser(innerIntent, null);
        ((Activity) context).startActivityForResult(wrapperIntent, REQUEST_CODE_GETVIDEO);
    }

    public static void startAudio(Context context) {
        Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        innerIntent.setType("audio/*");
        Intent wrapperIntent = Intent.createChooser(innerIntent, null);
        ((Activity) context).startActivityForResult(wrapperIntent, REQUEST_CODE_GETAUDIO);
    }
    /**
     * 
     * @Title: showSystemSetting 
     * @Description: 跳转系统设置界面
     * @author WangFusheng 
     * @param @param context    
     * @return void    
     * @throws
     */
    public static void showSystemSetting(Context context) {
        Intent intent = null;
        // 判断手机系统的版本 即API大于10 就是3.0或以上版本
        if (Build.VERSION.SDK_INT > 10) {
            intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        } else {
            intent = new Intent();
            ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
            intent.setComponent(component);
            intent.setAction("android.intent.action.VIEW");
        }
        context.startActivity(intent);
    }
    public void share(Context context,String content, Uri uri){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        if(uri!=null){
            //uri 是图片的地址
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/*");
            //当用户选择短信时使用sms_body取得文字
            shareIntent.putExtra("sms_body", content);
        }else{
            shareIntent.setType("text/plain");
        }
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        //自定义选择框的标题
        //startActivity(Intent.createChooser(shareIntent, "邀请好友"));
        //系统默认标题
        context.startActivity(shareIntent);
    }
    /**
     * 
     * @Title: callPhone 
     * @Description: 用intent启动拨打电话
     * @author WangFusheng 
     * @param @param context
     * @param @param number    
     * @return void    
     * @throws <uses-permission android:name="android.permission.CALL_PHONE" />
     */
   public static void callPhone(Context context, String number) {
       Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       context.startActivity(intent);
   }
   /**
    * 
    * @Title: SendSMSTo 
    * @Description: 发送短信
    * @author WangFusheng 
    * @param @param context
    * @param @param phoneNumber 发送者电话
    * @param @param message    发送内容
    * @return void    
    * @throws <uses-permission android:name="android.permission.SEND_SMS" /> 
    */
   public void SendSMSTo(Context context,String phoneNumber,String message){  
       if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){  
           Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));            
           intent.putExtra("sms_body", message);            
           context.startActivity(intent);  
       }  
   }

    public static void startActivity(Activity startActivity ,Class<?> objActivity){
        startActivity.startActivity(new Intent(startActivity,objActivity));
    }
    public static void startActivityWithString(Activity startActivity ,Class<?> objActivity,String content){
        Intent intent = new Intent(startActivity,objActivity);
        intent.putExtra("id",content);
        startActivity.startActivity(intent);
    }
    public static void startActivityWithInteger(Activity startActivity ,Class<?> objActivity,String paramName,int paramValue){
        Intent intent = new Intent(startActivity,objActivity);
        intent.putExtra(paramName,paramValue);
        startActivity.startActivity(intent);
    }
}
