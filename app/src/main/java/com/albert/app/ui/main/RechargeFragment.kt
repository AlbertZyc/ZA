package com.albert.app.ui.main

import com.albert.app.ui.viewmodel.RechargeMainViewModel
import com.albert.za.R
import com.albert.za.databinding.FragmentRechargeBinding
import yc.zalbert.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class RechargeFragment : CoreFragment<FragmentRechargeBinding, RechargeMainViewModel>() {
    override fun layoutId() = R.layout.fragment_recharge

    override fun initViewModel() = RechargeMainViewModel()


}