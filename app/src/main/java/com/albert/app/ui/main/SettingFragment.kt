package com.albert.app.ui.main

import com.albert.app.ui.viewmodel.SettingMainViewModel
import com.albert.za.R
import com.albert.za.databinding.FragmentSettingBinding
import yc.zalbert.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class SettingFragment : CoreFragment<FragmentSettingBinding, SettingMainViewModel>() {
    override fun layoutId() = R.layout.fragment_setting

    override fun initViewModel() = SettingMainViewModel()
    override fun onResume() {
        super.onResume()
    }
    override fun getUserVisibleHint(): Boolean {

        return super.getUserVisibleHint()
    }
}