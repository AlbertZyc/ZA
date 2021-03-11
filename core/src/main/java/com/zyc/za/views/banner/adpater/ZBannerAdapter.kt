package com.zyc.za.views.banner.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.zyc.za.R

/**
@Author AlbertZ
@CreateDate 2021/2/19
@Description 描述
 */
abstract class ZBannerAdapter<DATA> constructor(@LayoutRes private val layoutId: Int) :
    RecyclerView.Adapter<ZBannerViewHolder>() {
    private var mItemClick: ((data: DATA, position: Int) -> Unit)? = null
    private var mDataChanged: ((dataSize: Int) -> Unit)? = null
    private val mData: MutableList<DATA> = arrayListOf()
    private var mRawDataSize: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZBannerViewHolder {
        val viewHolder = ZBannerViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        )
        bindItemClick(viewHolder)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ZBannerViewHolder, position: Int) {
        val item = this.mData[position]
        holder.itemView.setTag(R.id.item_banner_data, item)
        onBindViewHolder(holder, item, position)
    }

    fun setOnItemClickListener(listener: (data: DATA, position: Int) -> Unit) {
        this.mItemClick = listener
    }

    internal fun getRwaDataSize(): Int = mRawDataSize

    internal fun setOnDataChangedListener(listener: (dataSize: Int) -> Unit) {
        this.mDataChanged = listener
    }

    protected abstract fun onBindViewHolder(holder: ZBannerViewHolder, item: DATA, position: Int)

    @Suppress("UNCHECKED_CAST")
    private fun bindItemClick(viewHolder: ZBannerViewHolder) {
        viewHolder.itemView.setOnClickListener {
            mItemClick?.let {
                val position = viewHolder.adapterPosition
                if (position == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                val item: DATA = viewHolder.itemView.getTag(R.id.item_banner_data) as DATA
                it.invoke(item, if (mRawDataSize <= 1) position else position - 1)
            }
        }
    }
}