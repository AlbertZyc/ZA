package yc.zalbert.za.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @Author AlbertZ
 * @CreateDate 2021/05/17
 * @Description 阿弥陀佛
 */
abstract class CoreBindingDialog<B : ViewDataBinding>(context: Context) : CoreDialog(context) {
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(savedInstanceState)
        refreshAttributes()
    }

    override fun initContentView() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), layoutId(), null, false)
        setContentView(binding.root)
    }
}