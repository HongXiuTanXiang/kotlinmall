package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView

open class BaseMVPActivity<T: BasePresenter<*>>:BaseActivity(),BaseView {

    lateinit var mPresenter:T

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}