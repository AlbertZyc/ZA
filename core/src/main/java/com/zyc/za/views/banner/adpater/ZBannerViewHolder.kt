package com.zyc.za.views.banner.adpater

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
@Author AlbertZ
@CreateDate 2021/2/19
@Description 描述
 */
open class ZBannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val views: SparseArray<View> = SparseArray()

    fun <V : View> findViewById(@IdRes viewId: Int): V {
        val view = getView<V>(viewId)
        checkNotNull(view) {
            "BannerViewHolder:findViewById() must not be null"
        }
        return view
    }

    fun setText(@IdRes viewId: Int, string: CharSequence = "") {
        setText(getView(viewId), string)
    }

    fun setText(view: TextView?, string: CharSequence = "") {
        view?.text = string
    }

    @Suppress("UNCHECKED_CAST")
    private fun <V : View> getView(viewId: Int): V? {
        val view = views.get(viewId)
        if (view == null) {
            itemView.findViewById<V>(viewId)?.let {
                views.put(viewId, it)
                return it
            }
        }
        return view as? V
    }
}