package com.zyc.app.ui.main

import com.zyc.app.ui.viewmodel.RechargeMainViewModel
import com.zyc.za.R
import com.zyc.za.databinding.FragmentRechargeBinding
import com.zyc.za.fragment.CoreFragment

/**
@Author AlbertZ
@CreateDate 2021/5/14
@Description 描述
 */
class RechargeFragment : CoreFragment<FragmentRechargeBinding, RechargeMainViewModel>() {
    override fun layoutId() = R.layout.fragment_recharge

    override fun initViewModel() = RechargeMainViewModel()


}