package com.zyc.za

import android.app.Application

/**
@Author AlbertZ
@CreateDate 2021/2/3
@Description 描述
 */
open class CoreApplication : Application() {
    private val TAG = "CoreApplication"

    companion object {
        val instance: CoreApplication by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CoreApplication()
        }
    }

    private val activityTask: MutableList<CoreActivity> = mutableListOf()

    init {

    }

    fun <T : CoreActivity> putActivity(activity: T) {
        activityTask.add(activity)
        ZLog.i(TAG, "Put Activity is ${activity::class.simpleName} in ActivityTask")
    }

    fun <T : CoreActivity> removeActivity(activity: T) {
        activityTask.remove(activity)
        ZLog.i(TAG, "Remove Activity is ${activity::class.simpleName} in ActivityTask")
    }

    fun removeAllActivities() {
        activityTask.clear()
        ZLog.i(TAG, "Remove All Activity in ActivityTask")
    }

}