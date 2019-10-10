package com.kotlin.UserCenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.RegisterPresenter
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.common.AppManager
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.ui.activity.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterView {


    private var pressTime: Long = 0

    override fun onRegisterResult(result: Boolean) {
        super.onRegisterResult(result)
        if (result == true){
            toast("注册成功")
        } else {
            toast("zhu ce shi bai")
        }

    }

    override fun onLoginResult(result: Boolean) {
        super.onLoginResult(result)
        toast("登录成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        this.mPresenter = RegisterPresenter()
        this.mPresenter.mView = this

        mRegisterButton.setOnClickListener({

            this.showLoading()
            mPresenter.register(mMobileET.text.toString(),mVerifyCodeET.text.toString(),mPwdET.text.toString())

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val time = System.currentTimeMillis()

        if ( time - this.pressTime > 2000){
            toast("再按一次退出程序")
            this.pressTime = time;
        } else{
            AppManager.instance.exitApp(this)
        }
    }
}
