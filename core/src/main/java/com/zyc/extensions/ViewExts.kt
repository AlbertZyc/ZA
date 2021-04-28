package com.zyc.extensions

import android.view.View

/**
@Author AlbertZ
@CreateDate 2021/4/27
@Description 带有限制快速点击的点击事件
 */

fun <T : View> T.click(action: (T) -> Unit) {
    setOnClickListener {
        action(this)
    }
}

fun <T : View> T.singleClick(interval: Long = 400L, action: ((T) -> Unit)?) {
    setOnClickListener(SingleClickListener(interval, action))
}

@Suppress("UNCHECKED_CAST")
class SingleClickListener<T : View>(
    private val interval: Long = 400L,
    private var clickFunc: ((T) -> Unit)?
) : View.OnClickListener {
    private var lastClickTime = 0L

    override fun onClick(v: View) {
        val nowTime = System.currentTimeMillis()
        if (nowTime - lastClickTime > interval) {
            // 单次点击事件
            if (clickFunc != null) {
                clickFunc!!(v as T)
            }
            lastClickTime = nowTime
        }
    }
}