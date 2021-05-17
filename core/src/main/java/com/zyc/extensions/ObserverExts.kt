package com.zyc.livebus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/27
 * @Description 简化LiveData的订阅操作
 */

fun <T> LiveData<T>.observeNullable(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner, Observer {
        block(it)
    })
}

/**
 * 简化LiveData的订阅操作
 */
fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, block: (T) -> Unit) {
    this.observe(owner, Observer {
        if (it != null) {
            block(it)
        }
    })
}
