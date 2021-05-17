package com.zyc.app.ui.main

import com.zyc.app.ui.viewmodel.IdealMainViewModel
import com.zyc.za.R
import com.zyc.za.databinding.FragmentIdealBinding
import com.zyc.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class IdealFragment : CoreFragment<FragmentIdealBinding, IdealMainViewModel>() {
    override fun layoutId() = R.layout.fragment_ideal

    override fun initViewModel() = IdealMainViewModel()


}