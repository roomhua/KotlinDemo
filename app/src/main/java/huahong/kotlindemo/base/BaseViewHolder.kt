package huahong.kotlindemo.base

import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 * Created by admin on 2017/9/20.
 */
abstract class BaseViewHolder<in T>(parent: ViewGroup?) {

    protected var mRootView : View? = null
    protected var mContext : Context? = null
    private var mParent: ViewGroup? = parent


    fun init() {
        mRootView = createRootView(mContext, mParent)

        findItemView()

        mRootView?.tag = this
    }



    abstract fun findItemView()

    abstract fun createRootView(mContext: Context?, mParent: ViewGroup?): View?

    abstract fun refresh(bean: T, position: Int)





    fun getRootView(): View? {
        return mRootView
    }

    init {
        mContext = parent?.context
    }

}