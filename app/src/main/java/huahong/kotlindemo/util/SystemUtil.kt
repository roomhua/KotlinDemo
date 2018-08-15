package huahong.kotlindemo.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import huahong.kotlindemo.base.MyApp

/**
 * Created by admin on 2018/8/15.
 */
object SystemUtil {


    /**
     * 检查WIFI是否连接
     */
    fun isWifiConnected() : Boolean {
        val connectivityManager : ConnectivityManager = MyApp.instance.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null
    }

    /**
     * 检查手机网络(4G/3G/2G)是否连接
     */
    fun isMobileNetworkConnected() : Boolean {
        val connectivityManager : ConnectivityManager = MyApp.instance.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null
    }


    /**
     * 检查是否有可用网络
     */
    fun isNetworkConnected() : Boolean {
        val connectivityManager : ConnectivityManager = MyApp.instance.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null
    }


    /**
     * 保存文字到剪贴板
     */
    fun copyToClipBoard(text : String) {
        val clipData : ClipData = ClipData.newPlainText("url",text)
        val manager : ClipboardManager = MyApp.instance.applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        manager.primaryClip = clipData
        ToastUtil.shortTimeShow("已复制到剪贴板")
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dp2px(dpValue: Float) : Int{
        return (MyApp.instance.applicationContext.resources.displayMetrics.density * dpValue + 0.5f).toInt()
    }


    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dp(pxValue: Float) : Int{
        return (pxValue / MyApp.instance.applicationContext.resources.displayMetrics.density + 0.5f).toInt()
    }


}