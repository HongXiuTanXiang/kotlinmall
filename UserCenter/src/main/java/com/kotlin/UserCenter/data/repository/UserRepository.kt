package com.kotlin.UserCenter.data.repository

import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.protocal.RegisterReq
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocal.BaseResponse
import io.reactivex.Observable


class UserRepository {

    fun register(mobile:String = "13951466577",pwd:String = "123456",verifyCode:String = "123456"): Observable<BaseResponse<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}