package com.kotlin.UserCenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.RegisterPresenter
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.ui.activity.BaseMVPActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterView {

    override fun onRegisterResult(result: Boolean) {
        super.onRegisterResult(result)
        toast("注册成功")
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
            toast("注册")
            mPresenter.register("","","")

        })
    }
}
