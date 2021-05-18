package com.albert.app.ui.main

import android.os.Bundle
//import com.alibaba.android.arouter.facade.annotation.Route
import com.albert.app.ui.viewmodel.TestMainViewModel
import com.albert.za.R
import com.albert.za.databinding.TestMainActivityBinding
import com.alibaba.android.arouter.facade.annotation.Route
import yc.zalbert.constants.RouteConstants
import yc.zalbert.extensions.singleClick
import yc.zalbert.za.activity.CoreActivity

@Route(path = RouteConstants.TEST_MAIN)
class TestMainActivity : CoreActivity<TestMainActivityBinding, TestMainViewModel>() {

    override fun layoutId(): Int = R.layout.test_main_activity
    override fun initViewModel() = TestMainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun onInitObserver() {
        super.onInitObserver()
        viewModel.testBLiveData.observe(this, {
            binding.tvCenter.text = it.age.toString()
        })
    }

    override fun addViewAction() {
        super.addViewAction()
        binding.tvCenter.singleClick {
            viewModel.postData()
        }
    }
}