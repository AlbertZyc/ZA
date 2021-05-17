package com.zyc.app.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.zyc.app.ui.viewmodel.TestFragmentContainerViewModel
import com.zyc.za.R
import com.zyc.za.activity.CoreFragmentContainerActivity
import com.zyc.za.databinding.ActivityTestFragmentContainerBinding
import com.zyc.za.fragment.CoreFragment

class TestFragmentContainerActivity :
    CoreFragmentContainerActivity<ActivityTestFragmentContainerBinding, TestFragmentContainerViewModel>() {

    private var fragments: MutableList<CoreFragment<*, *>> =
        mutableListOf(RechargeFragment(), IdealFragment(), SettingFragment())
    private lateinit var fragmentAdapter: FragmentAdapter
    private var menuItem: MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            bnvBottom.apply {
                itemIconTintList = null
                setOnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.m_recharge -> {
                            binding.vp.currentItem = 0
                        }
                        R.id.m_ideal -> {
                            binding.vp.currentItem = 1
                        }
                        R.id.m_setting -> {
                            binding.vp.currentItem = 2
                        }
                    }
                    true
                }


                setOnNavigationItemReselectedListener {
                    when (it.itemId) {
                        R.id.m_recharge -> {
                            showToast("别点了，就是这个")
                        }
                        R.id.m_ideal -> {
                            showToast("别点了，就是这个")
                        }
                        R.id.m_setting -> {
                            showToast("别点了，就是这个")
                        }
                    }
                }
            }
            fragmentAdapter = FragmentAdapter(
                fragments,
                supportFragmentManager,
                lifecycle
            )
            vp.let {
                it.adapter = fragmentAdapter
                it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (menuItem != null) {
                            menuItem!!.isChecked = false;
                        } else {
                            bnvBottom.menu.getItem(0).isChecked = false;
                        }
                        menuItem = bnvBottom.menu.getItem(position);
                        menuItem!!.isChecked = true;
                    }
                })
            }
        }

    }

    override fun layoutId() = R.layout.activity_test_fragment_container

    override fun initViewModel() = TestFragmentContainerViewModel()
}