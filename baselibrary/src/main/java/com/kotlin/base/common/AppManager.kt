package com.kotlin.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor(){

    private val activityStack: Stack<Activity> = Stack()

    companion object{
        val instance: AppManager by lazy { AppManager() }
    }

    /*入栈*/
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /*出栈*/
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /*当前activity*/
    fun currentActivity():Activity{
        return activityStack.lastElement()
    }

    /*结束所有activity*/
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }

        activityStack.clear()
    }

    /*退出*/
    fun exitApp(context:Context){
        this.finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}