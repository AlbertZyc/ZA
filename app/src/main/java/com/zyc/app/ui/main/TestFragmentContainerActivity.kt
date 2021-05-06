package com.zyc.app.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zyc.app.ui.viewmodel.TestFragmentContainerViewModel
import com.zyc.za.R
import com.zyc.za.activity.CoreFragmentContainerActivity
import com.zyc.za.databinding.ActivityTestFragmentContainerBinding
import com.zyc.za.databinding.TestMainActivityBinding

class TestFragmentContainerActivity :
    CoreFragmentContainerActivity<ActivityTestFragmentContainerBinding, TestFragmentContainerViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment_container)
    }

    override fun layoutId() = R.layout.activity_test_fragment_container

    override fun initViewModel() = TestFragmentContainerViewModel()
}