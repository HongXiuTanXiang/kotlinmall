package com.kotlin.UserCenter.service.impl

import com.kotlin.UserCenter.service.UserService
import io.reactivex.Observable
import java.util.*

class UserServiceImpl:UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun login(mobile: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)
    }
}