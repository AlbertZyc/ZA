package com.zyc.za.activity

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.zyc.za.CoreApplication
import com.zyc.za.viewmodel.CoreViewModel

/**
 * @Author AlbertZ
 * @CreateDate 2021/3/18
 * @Description 如果一个Activity里面有
 */

abstract class CoreFragmentContainerActivity<B : ViewDataBinding, VM : CoreViewModel> : CoreActivity<B,VM>() {

}