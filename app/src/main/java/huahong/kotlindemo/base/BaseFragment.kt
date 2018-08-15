package huahong.kotlindemo.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by admin on 2017/9/20.
 */
abstract class BaseFragment : Fragment(),View.OnClickListener {

    protected var mRootView : View? = null
    protected var mContext : Context? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mContext == null) {
            mContext = container?.context
        }


        if (mRootView == null) {
            mRootView = createRootView(inflater,container)
        }else {

            if (mRootView?.parent != null) {

                val parent : ViewGroup = mRootView?.parent as ViewGroup

                parent.removeView(mRootView)
            }

        }

        return mRootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initPresenter()
        initView()
        initData()
        initListener()
    }

    abstract fun initListener()
    abstract fun initData()
    abstract fun initView()
    abstract fun initPresenter()
    abstract fun createRootView(inflater: LayoutInflater?, container: ViewGroup?): View?
    abstract fun onViewClick(v: View?)




    var mClickTime : Long = 0


    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()

        if(currentTime - mClickTime > 800) {
            onViewClick(v)
        }

        mClickTime = currentTime
    }



  protected  fun findViewById(v : View? , resId : Int) : View? {

        if (v == null) {
            return mRootView?.findViewById(resId)

        }else{
            return v
        }

    }


   protected fun findViewById(v : View? ,rv : View?, resId : Int) : View? {

        if (v == null) {
            return rv?.findViewById(resId)
        }else{
            return v
        }

    }

}