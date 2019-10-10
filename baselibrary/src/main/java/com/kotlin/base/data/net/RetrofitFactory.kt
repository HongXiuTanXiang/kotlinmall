package com.kotlin.base.data.net

import com.kotlin.base.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



class RetrofitFactory private constructor(){

    companion object{
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private var retrofit: Retrofit
    private val interceptor:Interceptor

    init {

        interceptor = BaseInterceptor()

        retrofit = Retrofit.Builder()
            .baseUrl(Constant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient? {

        return OkHttpClient.Builder()
            .addInterceptor(this.interceptor)
            .addInterceptor(initlogInterceptor())
            .connectTimeout(Constant.TIME_OUT,TimeUnit.SECONDS)
            .build()
    }

    private fun initlogInterceptor(): Interceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service:Class<T>): T{
        return this.retrofit.create(service)
    }

}