package com.zyc.app.ui.main

import com.zyc.app.ui.viewmodel.SettingMainViewModel
import com.zyc.za.R
import com.zyc.za.databinding.FragmentSettingBinding
import com.zyc.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class SettingFragment : CoreFragment<FragmentSettingBinding, SettingMainViewModel>() {
    override fun layoutId() = R.layout.fragment_setting

    override fun initViewModel() = SettingMainViewModel()


}