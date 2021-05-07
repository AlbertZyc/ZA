package com.zyc.za.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/22
 * @Description 阿弥陀佛 顾名思义？
 */
abstract class CoreViewModel : ViewModel(), ViewModelLifecycle {
    private lateinit var lifecycleOwner: LifecycleOwner

    /**
     * 也许你需要一个方法来创建一个ViewModel
     */
    companion object {
        @JvmStatic
        fun <T : CoreViewModel> createViewModelFactory(viewModel: T): ViewModelProvider.Factory {
            return ViewModelFactory(viewModel)
        }
    }

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        this.lifecycleOwner = owner
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

}