package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.weidgets.ProgressLoading

open class BaseMVPActivity<T: BasePresenter<*>>:BaseActivity(),BaseView {

    lateinit var mPresenter:T

    lateinit var mLoadingDialog:ProgressLoading


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoadingDialog = ProgressLoading.create(this)
    }

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoding() {
        mLoadingDialog.hideLoading()
    }

    override fun onError() {
        mLoadingDialog.hideLoading()
    }



}