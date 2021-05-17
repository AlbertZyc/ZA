package com.zyc.app.ui.main

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zyc.za.fragment.CoreFragment
import com.zyc.za.viewmodel.CoreViewModel

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class FragmentAdapter(
    private val mutableList: MutableList<CoreFragment<*,*>>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = mutableList.size

    override fun createFragment(position: Int): Fragment {
        return mutableList[position]
    }

}