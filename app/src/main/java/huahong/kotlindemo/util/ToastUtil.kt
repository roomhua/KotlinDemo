package huahong.kotlindemo.util

import android.view.Gravity
import android.widget.Toast
import huahong.kotlindemo.base.MyApp

/**
 * Created by admin on 2018/8/15.
 */
object ToastUtil {

    private var toast : Toast? = null


    fun shortTimeShow(text: String) {
       if (toast == null) {
           toast = Toast.makeText(MyApp.instance,text,Toast.LENGTH_SHORT)
       }else{
           toast?.cancel()
           toast?.duration = Toast.LENGTH_SHORT
           toast?.setText(text)
       }
        toast?.setGravity(Gravity.CENTER,0,0)
        toast?.show()
    }


    fun longTimeShow(text: String) {
        if (toast == null) {
            toast = Toast.makeText(MyApp.instance,text,Toast.LENGTH_LONG)
        }else{
            toast?.cancel()
            toast?.duration = Toast.LENGTH_LONG
            toast?.setText(text)
        }
        toast?.setGravity(Gravity.CENTER,0,0)
        toast?.show()
    }
}