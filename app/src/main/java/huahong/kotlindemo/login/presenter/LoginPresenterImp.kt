package huahong.kotlindemo.login.presenter

import huahong.kotlindemo.bean.UserInfo
import huahong.kotlindemo.login.LoginView
import org.litepal.crud.DataSupport

/**
 * Created by admin on 2018/6/8.
 */
class LoginPresenterImp(loginView: LoginView) : LoginPresenter {

    var loginView : LoginView? = loginView

    override fun userRegister(info: UserInfo) {

        if (info.save()) {
            loginView?.loginSuccess("注册成功")
        }else {
            loginView?.loginFailure("注册失败")
        }

    }

    override fun userLogin(info: UserInfo) {
       val datas : List<UserInfo>? = DataSupport.where("userName = ?" , info.userName).find(UserInfo().javaClass)

        if (datas != null && datas.isNotEmpty()) {
            loginView?.loginSuccess("成功")
        }else{
            loginView?.loginFailure("帐号或密码错误")
        }

    }


}