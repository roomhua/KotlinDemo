package huahong.kotlindemo.util

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by admin on 2017/9/20.
 */
class ThreadUtil private constructor(){

    private var mThreadPoolExecutor: ThreadPoolExecutor? = null
    private val corePoolSize = 3
    private val maximumPoolSize = 6
    private val keepAliveTime: Long = 1
    private val timeUnit = TimeUnit.MINUTES
    private val workQueue = LinkedBlockingDeque<Runnable>(128)




    companion object {
      fun getInstance() : ThreadUtil {
          return Inner.threadUtil
      }
    }



    private object Inner {
        val threadUtil : ThreadUtil = ThreadUtil()
    }



    fun execute(runnable : Runnable) {

        if (mThreadPoolExecutor == null || mThreadPoolExecutor?.isShutdown as Boolean) {
            mThreadPoolExecutor = ThreadPoolExecutor(corePoolSize,maximumPoolSize, keepAliveTime,timeUnit,workQueue)
        }

        mThreadPoolExecutor?.execute(runnable)
    }


}