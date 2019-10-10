package com.kotlin.UserCenter.myApplication

import android.app.Application
import com.kotlin.base.utils.netUtils.NetworkListener

class UserCenterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkListener.getInstance().init(this);
    }
}