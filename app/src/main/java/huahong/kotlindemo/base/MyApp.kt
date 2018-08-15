package huahong.kotlindemo.base

import org.litepal.LitePalApplication

/**
 * Created by admin on 2018/6/8.
 */
class MyApp : LitePalApplication() {

    companion object {
        lateinit var instance : MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}