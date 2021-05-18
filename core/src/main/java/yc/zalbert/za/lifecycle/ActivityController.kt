package yc.zalbert.za.lifecycle

import yc.zalbert.za.activity.CoreActivity
import yc.zalbert.za.utils.ZLog
import java.util.*

/**
@Author AlbertZ
@CreateDate 2021/5/11
@Description Activity管理
 */
object ActivityController {
    private val mActivityList = LinkedList<CoreActivity<*, *>>()
    val currentActivity: CoreActivity<*, *>?
        get() = if (mActivityList.isEmpty()) {
            null
        } else {
            mActivityList.last
        }

    /**
     * activity入栈
     */
    fun pushActivity(activity: CoreActivity<*, *>) {
        ZLog.i(this, "PushActivity = ${activity.javaClass.simpleName}")
        if (mActivityList.contains(activity)) {
            if (mActivityList.last != activity) {
                mActivityList.remove(activity)
                mActivityList.add(activity)
            }
        } else {
            mActivityList.add(activity)
        }
    }

    /**
     * activity出栈
     */
    fun popActivity(activity: CoreActivity<*, *>) {
        ZLog.i(this, "PopActivity = ${activity.javaClass.simpleName}")
        mActivityList.remove(activity)
    }

    /**
     * 关闭当前activity
     */
    fun finishCurrentActivity() {
        currentActivity?.let { finishActivity(it) }
    }

    /**
     * 关闭传入的activity
     */
    fun finishActivity(activity: CoreActivity<*, *>) {
        mActivityList.remove(activity)
        activity.finish()
    }

    /**
     * 关闭传入的activity类名
     */
    fun finishActivity(clazz: Class<*>) {
        for (activity in mActivityList) {
            if (activity.javaClass == clazz) {
                mActivityList.remove(activity)
                activity.finish()
                break
            }
        }

    }

    /**
     * 关闭所有的activity
     */
    fun finishAllActivity() {
        for (activity in mActivityList) {
            activity.finish()
        }
        mActivityList.clear()
    }
}