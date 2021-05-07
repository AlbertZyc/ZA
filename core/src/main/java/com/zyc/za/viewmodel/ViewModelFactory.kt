package com.zyc.za.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @Author AlbertZ
 * @CreateDate 2021/4/22
 * @Description 显然这个ViewModel带了参数
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val viewModel: CoreViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}