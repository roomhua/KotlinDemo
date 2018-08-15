package huahong.kotlindemo.base

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by admin on 2017/9/18.
 */
abstract class BaseActivity : AppCompatActivity(),View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        AppManager.getInstance().addActivity(this)

        initPresenter()
        initView()
        initData()
        initListener()
    }

    abstract fun initListener()
    abstract fun initData()
    abstract fun initView()
    abstract fun initPresenter()
    abstract fun getLayoutResId(): Int
    abstract fun onViewClick(v: View?)


    override fun onPause() {
        super.onPause()
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.getInstance().removeActivity(this)
    }


    var mClickTime : Long = 0


    override fun onClick(v: View?) {
       val currentTime = System.currentTimeMillis()

        if(currentTime - mClickTime > 800) {
            onViewClick(v)
        }

        mClickTime = currentTime
    }





    protected fun startActivity(clazz: Class<Any> , flag : Boolean,parcelable : Parcelable? ,
                                name: String?) {

        val intent : Intent = Intent(this,clazz)

        if (parcelable != null) {

            intent.putExtra(name,parcelable)
        }


        startActivity(intent)

        if (flag) {
            finish()
        }

    }
}