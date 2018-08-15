package huahong.kotlindemo.login.presenter

import huahong.kotlindemo.bean.UserInfo

/**
 * Created by admin on 2018/6/8.
 */
interface LoginPresenter {


    fun userLogin(info : UserInfo)

    fun userRegister(info : UserInfo)
}