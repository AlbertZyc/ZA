package yc.zalbert.za.activity

import androidx.databinding.ViewDataBinding
import yc.zalbert.za.viewmodel.CoreViewModel

/**
 * @Author AlbertZ
 * @CreateDate 2021/3/18
 * @Description 如果一个Activity里面有
 */

abstract class CoreFragmentContainerActivity<B : ViewDataBinding, VM : CoreViewModel> : CoreActivity<B,VM>() {

}