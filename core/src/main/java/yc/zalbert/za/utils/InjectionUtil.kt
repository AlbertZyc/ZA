package yc.zalbert.za.utils

import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import yc.zalbert.za.CoreApplication

/**
 *@Author AlbertZ
 *@CreateDate 2021/3/17
 *@Description 好用的扩展类
 * 如果注入方法本身就具有同名的方法，该方法无法生效，且无法找到其调用
 */
open class InjectionUtil {
    /**
     * Int类型资源ID，直接作为颜色使用
     * eg: R.color.white.asColor()
     */
    fun Int.asColor() = ContextCompat.getColor(CoreApplication.instance, this)

    /**
     * Int类型资源ID，直接作为Drawable使用
     * eg: R.color.white.asColor()
     */
    fun Int.asDrawable() = ContextCompat.getDrawable(CoreApplication.instance, this)

    /**
     * View直接VISIBLE
     * eg:findViewById(xx).show()
     */
    fun View.show() {
        this.visibility = View.VISIBLE
    }

    /**
     * View直接GONE
     * eg:findViewById(xx).hide()
     */
    fun View.hide() {
        this.visibility = View.GONE
    }


    /**
     * eg:findViewById(xx).inVisible()
     */
    fun View.inVisible() {
        this.visibility = View.INVISIBLE
    }


    fun View.setWidthHeight(w: Int, h: Int) {
        this.layoutParams.apply {
            height = h
            width = w
        }
    }


    fun View.setWidth(w: Int) {
        this.setWidthHeight(w, this.height)
    }

    fun View.setHeight(h: Int) {
        this.setWidthHeight(this.width, h)
    }

    /**
     * View可以直接设置margin
     */
    fun View.setMargin(start: Int, top: Int, end: Int, bottom: Int) {
        (this.layoutParams as ViewGroup.MarginLayoutParams).apply {
            marginStart = start
            topMargin = top
            marginEnd = end
            bottomMargin = bottom
        }
    }

}