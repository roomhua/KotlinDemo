package huahong.kotlindemo.login

/**
 * Created by admin on 2018/6/8.
 */
interface LoginView {

    fun loginSuccess(string: String)


    fun loginFailure(string: String)
}