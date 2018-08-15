@file:Suppress("DEPRECATION")

package huahong.kotlindemo.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by admin on 2018/5/21.
 */
object TimeUtil {




    /**
     * 时间戳转特定格式时间
     * @param dataFormat
     * @param timeStamp
     * @return
     */
    fun formatData(dataFormat : String,timeStamp : Long) : String {
        if (timeStamp == 0.toLong()) {
            return ""
        }

        return SimpleDateFormat(dataFormat).format(Date(timeStamp * 1000))
    }


    /**
     * 将毫秒转换成秒
     * @param time
     * @return
     */
    fun convertToSecond(time : Long) : Int{
        val date : Date = Date()
        date.time = time
        return date.seconds
    }


}