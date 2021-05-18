package yc.zalbert.za.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel


/**
 * @Author AlbertZ
 * @CreateDate 2021/05/17
 * @Description 阿弥陀佛
 * TODO 以后扩展
 */
abstract class CoreDialog(context: Context) : AppCompatDialog(context) {
    private var width: Int = ViewGroup.LayoutParams.MATCH_PARENT
    private var height: Int = ViewGroup.LayoutParams.WRAP_CONTENT
    private var gravity: Int = Gravity.CENTER
    private var animRes: Int = -1
    private var dimAmount: Float = 0.5f
    private var alpha: Float = 1f

    protected var uiScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView()
        initialize(savedInstanceState)
        refreshAttributes()
    }

    protected open fun initContentView() {
        setContentView(layoutId())
    }

    /**
     * 刷新属性
     */
    fun refreshAttributes() {
        window!!.let {
            val params: WindowManager.LayoutParams = it.attributes
            params.width = width
            params.height = height
            params.gravity = gravity
            params.windowAnimations = animRes
            params.dimAmount = dimAmount
            params.alpha = alpha
            params.windowAnimations = animRes
            it.attributes = params
        }
    }

    override fun dismiss() {
        uiScope.cancel()
        super.dismiss()
    }

    @LayoutRes
    protected abstract fun layoutId(): Int

    protected open fun initialize(savedInstanceState: Bundle?) {

    }
}