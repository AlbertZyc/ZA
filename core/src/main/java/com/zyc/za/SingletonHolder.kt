package com.zyc.za

import android.os.Parcelable

/**
 * @Author AlbertZ
 * @CreateDate 2021/2/4
 * @Description 带参单例
 */
open class SingletonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T =
        instance ?: synchronized(this) {
            instance ?: creator!!(arg).apply {
                instance = this
            }
        }
}