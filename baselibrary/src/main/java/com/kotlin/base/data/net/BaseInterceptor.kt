package com.kotlin.base.data.net

import okhttp3.Interceptor
import okhttp3.Response

class BaseInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain!!.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("charset","utf-8")
            .build()
        return  chain!!.proceed(request)
    }
}