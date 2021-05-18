package com.albert.app.ui.main

import com.albert.app.ui.viewmodel.IdealMainViewModel
import com.albert.za.R
import com.albert.za.databinding.FragmentIdealBinding
import yc.zalbert.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class IdealFragment : CoreFragment<FragmentIdealBinding, IdealMainViewModel>() {
    override fun layoutId() = R.layout.fragment_ideal

    override fun initViewModel() = IdealMainViewModel()


}