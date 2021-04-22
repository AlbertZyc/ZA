package com.zyc.za.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
@Author AlbertZ
@CreateDate 2021/4/22
@Description 阿弥陀佛 顾名思义？
 */
abstract class CoreViewModel : ViewModel(), ViewModelLifecycle {
    private lateinit var lifecycle: LifecycleOwner

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
        this.lifecycle = owner
    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}