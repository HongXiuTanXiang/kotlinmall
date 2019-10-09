package com.kotlin.UserCenter.service

import io.reactivex.Observable
import java.util.*

open interface UserService {

    fun register(mobile:String,verifyCode:String,pwd:String):Observable<Boolean>

    fun login(mobile: String,pwd: String):Observable<Boolean>

}