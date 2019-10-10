package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.data.protocal.RegisterReq
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.UserCenter.service.impl.UserServiceImpl
import com.kotlin.base.presenter.view.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*

open class RegisterPresenter:BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String,pwd:String){

        val userService = UserServiceImpl()


        userService.register(mobile,verifyCode,pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                this.mView.onRegisterResult(it)
            },{
                Log.e("shibai","shibai")
                this.mView.onRegisterResult(false)
            },{

            })

    }



    fun login(mobile: String,pwd: String){
        val userSevice = UserServiceImpl()

        userSevice.login(mobile,pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

            })

    }


}

