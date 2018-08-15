package huahong.kotlindemo.login

import android.view.View
import android.widget.EditText
import android.widget.Toast
import huahong.kotlindemo.MainActivity
import huahong.kotlindemo.R
import huahong.kotlindemo.base.BaseActivity
import huahong.kotlindemo.bean.UserInfo
import huahong.kotlindemo.login.presenter.LoginPresenter
import huahong.kotlindemo.login.presenter.LoginPresenterImp

/**
 * Created by admin on 2018/6/8.
 */
class LoginActivity : BaseActivity(),LoginView {
    override fun loginSuccess(string: String) {
        if ("注册成功" == string) {
            Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
        }else {
            startActivity(MainActivity().javaClass,true,null,null)
        }
    }

    override fun loginFailure(string: String) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
    }

    var et_name : EditText? = null
    var et_psw : EditText? = null
    var loginPresenter : LoginPresenter? = null



    override fun initListener() {
       findViewById(R.id.bt).setOnClickListener(this)
       findViewById(R.id.bt1).setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun initView() {
        et_name = findViewById(R.id.et12) as EditText
        et_psw = findViewById(R.id.et2) as EditText
    }

    override fun initPresenter() {
        loginPresenter = LoginPresenterImp(this)
    }

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun onViewClick(v: View?) {

        val info : UserInfo = UserInfo()
        info.userName = et_name?.text.toString()
        info.password = et_psw?.text.toString()
        when(v?.id){
            R.id.bt ->  { loginPresenter?.userLogin(info)}
            R.id.bt1 ->  {loginPresenter?.userRegister(info)}
        }
    }
}