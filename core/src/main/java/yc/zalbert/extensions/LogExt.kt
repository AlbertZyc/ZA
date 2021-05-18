package me.hgj.jetpackmvvm.ext.util

import android.util.Log
import yc.zalbert.constants.AppConstants

/**
 * @Author AlbertZ
 * @CreateDate  2021/5/17
 * @Description 日志系统
 */
private enum class LEVEL {
    V, D, I, W, E
}

const val TAG = "ZYC_ALBERT"
fun Any.logv(header: String) = logv(TAG,header = header)

fun Any.logd(header: String) = logd(TAG,header = header)

fun Any.logw(header: String) = logw(TAG,header = header)

fun Any.loge(header: String) = loge(TAG,header = header)

fun Any.logi(header: String) = logi(TAG,header = header)

fun Any.logi(tag: String = TAG, header: String = "") {
    log(LEVEL.I, tag, header + this.toString())
}

fun Any.logw(tag: String = TAG, header: String = "") {
    log(LEVEL.W, tag, header + this.toString())
}

fun Any.logd(tag: String = TAG, header: String = "") {
    log(LEVEL.D, tag, header + this.toString())
}

fun Any.logv(tag: String = TAG, header: String = "") {
    log(LEVEL.V, tag, header + this.toString())
}

fun Any.loge(tag: String = TAG, header: String = "") {
    log(LEVEL.E, tag, header + this.toString())
}


private fun log(level: LEVEL, tag: String, message: String) {
    if (yc.zalbert.constants.AppConstants.ZDEBUG) {
        when (level) {
            LEVEL.V -> Log.v(tag, message)
            LEVEL.D -> Log.d(tag, message)
            LEVEL.I -> Log.i(tag, message)
            LEVEL.W -> Log.w(tag, message)
            LEVEL.E -> Log.e(tag, message)
        }
    }

}