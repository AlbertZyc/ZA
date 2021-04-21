package com.zyc.za

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
@Author AlbertZ
@CreateDate 2021/4/21
@Description ViewModel的工厂类
 */
class ViewModelProviderFactory() :
    ViewModelProvider.AndroidViewModelFactory(CoreApplication.instance) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}