package com.kotlin.UserCenter.data.api

import com.kotlin.UserCenter.data.protocal.RegisterReq
import com.kotlin.base.data.protocal.BaseResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {


    //Call
    @POST("/")
    fun register(@Body req: RegisterReq): Observable<BaseResponse<String>>

}