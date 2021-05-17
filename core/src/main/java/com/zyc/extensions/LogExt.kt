package me.hgj.jetpackmvvm.ext.util

import android.util.Log
import com.zyc.constants.AppConstants

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/27
 * @Description 日志系统
 */
private enum class LEVEL {
    V, D, I, W, E
}

const val TAG = "ZYC_ALBERT"
fun Any.logv(tag: String = TAG) =
    log(LEVEL.V, tag, this.toString())

fun Any.logd(tag: String = TAG) =
    log(LEVEL.D, tag, this.toString())

fun Any.logw(tag: String = TAG) =
    log(LEVEL.W, tag, this.toString())

fun Any.loge(tag: String = TAG) =
    log(LEVEL.E, tag, this.toString())

fun Any.logi(tag: String = TAG) {
    log(LEVEL.I, tag, this.toString())
}

private fun log(level: LEVEL, tag: String, message: String) {
    if (!AppConstants.ZDEBUG) return
    when (level) {
        LEVEL.V -> Log.v(tag, message)
        LEVEL.D -> Log.d(tag, message)
        LEVEL.I -> Log.i(tag, message)
        LEVEL.W -> Log.w(tag, message)
        LEVEL.E -> Log.e(tag, message)
    }
}