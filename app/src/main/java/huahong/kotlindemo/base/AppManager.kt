package huahong.kotlindemo.base

import android.app.Activity
import java.util.*

/**
 * Created by admin on 2018/5/18.
 */
class AppManager private constructor(){



    companion object {
        fun getInstance() :  AppManager{
           return Inner.appManager
        }

        private var activityStack : Stack<Activity> = Stack()

    }


    private object Inner {
        val appManager : AppManager = AppManager()

    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity : Activity) {
        activityStack.add(activity)

    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity() : Activity? {

        try {
            val activity : Activity = activityStack.lastElement()
            return activity
        }catch (e :Exception) {
            return null
        }
    }


    /**
     * 获取当前Activity的前一个Activity
     */
    fun preActivity() : Activity? {

        val index = activityStack.size - 2
        if (index < 0) {
            return null
        }

        val activity : Activity = activityStack.get(index)
        return activity
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity : Activity?) {

        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }

    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {

        val activity : Activity = activityStack.lastElement()
        finishActivity(activity)
    }


    /**
     * 移除指定的Activity
     */
    fun removeActivity(activity : Activity?) {

        if (activity != null) {
            activityStack.remove(activity)
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity (clazz: Class<Activity>) {
        try {
            activityStack.filter { it.javaClass == clazz }.forEach { finishActivity(it) }
        }catch (e : Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        if (activityStack.size > 0) {
            activityStack.forEach { it.finish() }
        }
        activityStack.clear()
    }


    /**
     * 返回到指定的activity
     */
    fun returnToActivity(clazz: Class<Activity>) {

            while (activityStack.size != 0) {

                if (activityStack.peek().javaClass == clazz) {
                    break
                }else {
                    finishActivity(activityStack.peek())
                }
            }
    }

}