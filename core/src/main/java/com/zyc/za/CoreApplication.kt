package com.zyc.za

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.zyc.za.utils.ZLog

/**
@Author AlbertZ
@CreateDate 2021/2/3
@Description 描述
 */
open class CoreApplication : Application(), Application.ActivityLifecycleCallbacks {
    private val TAG = "CoreApplication"
    private var mActivityCount = 0

    companion object {
        val instance: CoreApplication by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CoreApplication()
        }
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    private val activityTask: MutableList<CoreActivity<*,*>> = mutableListOf()

    /**
     * 应用进入后台
     */
    fun onEnterBackground() {

    }

    /**
     * 应用进入前台
     */
    fun onEnterForeGround() {

    }

    fun <T : CoreActivity<*,*>> putActivity(activity: T) {
        activityTask.add(activity)
        ZLog.i(TAG, "Put Activity is ${activity::class.simpleName} in ActivityTask")
    }

    fun <T : CoreActivity<*,*>> removeActivity(activity: T) {
        activityTask.remove(activity)
        ZLog.i(TAG, "Remove Activity is ${activity::class.simpleName} in ActivityTask")
    }

    fun removeAllActivities() {
        activityTask.clear()
        ZLog.i(TAG, "Remove All Activity in ActivityTask")
    }

    fun getActivitiesCount() = activityTask.size

    /**
     * Activity生命周期
     */

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        mActivityCount++
        if (mActivityCount > 0) {
            onEnterForeGround()
        }
    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {
        mActivityCount--
        if (mActivityCount == 0) {
            onEnterBackground()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

}