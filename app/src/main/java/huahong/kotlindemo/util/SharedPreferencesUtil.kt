package huahong.kotlindemo.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by admin on 2017/9/21.
 */
object SharedPreferencesUtil {

    private var mSharedPreferences : SharedPreferences? = null


    private fun init(context: Context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        }
    }


    fun putData(context: Context, key:String, value:Any) {

        if (mSharedPreferences == null) {
            init(context)
        }


        if(value is Int) {
            mSharedPreferences?.edit()?.putInt(key,value)?.apply()
        }else if (value is Long) {
            mSharedPreferences?.edit()?.putLong(key,value)?.apply()
        }else if (value is String) {
            mSharedPreferences?.edit()?.putString(key,value)?.apply()
        }else if (value is Boolean) {
            mSharedPreferences?.edit()?.putBoolean(key,value)?.apply()
        }else if (value is Float) {
            mSharedPreferences?.edit()?.putFloat(key,value)?.apply()
        }
    }


    fun  getStringData(context: Context, key:String, defaultValue:String) : String? {
        if (mSharedPreferences == null) {
            init(context)
        }
        return mSharedPreferences?.getString(key,defaultValue)
    }


    fun getIntData(context: Context, key:String, defaultValue:Int) : Int? {
        if (mSharedPreferences == null) {
            init(context)
        }
        return mSharedPreferences?.getInt(key,defaultValue)
    }



    fun getLongData(context: Context, key:String, defaultValue:Long) : Long? {
        if (mSharedPreferences == null) {
            init(context)
        }
        return mSharedPreferences?.getLong(key,defaultValue)
    }




    fun getBooleanData(context: Context, key:String, defaultValue:Boolean) : Boolean? {
        if (mSharedPreferences == null) {
            init(context)
        }
        return mSharedPreferences?.getBoolean(key,defaultValue)
    }




    fun getFloatData(context: Context, key:String, defaultValue:Float) : Float? {

        if (mSharedPreferences == null) {
            init(context)
        }
        return mSharedPreferences?.getFloat(key,defaultValue)
    }



    fun clear(context: Context) {
        if (mSharedPreferences == null) {
            init(context)
        }
        mSharedPreferences?.edit()?.clear()?.commit()
    }

}