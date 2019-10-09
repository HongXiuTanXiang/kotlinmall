package com.kotlin.UserCenter.presenter.view

import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView

interface RegisterView :BaseView{

    fun onRegisterResult(result: Boolean){

    }

    fun onLoginResult(result: Boolean){

    }

}