package com.kotlin.UserCenter.service.impl

import com.kotlin.UserCenter.data.repository.UserRepository
import com.kotlin.UserCenter.service.UserService
import com.kotlin.base.rx.BaseException
import io.reactivex.Observable



class UserServiceImpl:UserService {
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        val respository = UserRepository()
        return respository.register(mobile, pwd, verifyCode).flatMap {
            if (it.status != 0){
                return@flatMap Observable.just(false)
            }
            return@flatMap Observable.just(true)
        }
    }



    override fun login(mobile: String, pwd: String): Observable<Boolean> {

        return Observable.just(true)
    }
}