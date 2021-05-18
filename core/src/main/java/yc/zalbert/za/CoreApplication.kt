package yc.zalbert.za

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.zalbert.za.BuildConfig
import yc.zalbert.constants.AppConstants
import me.hgj.jetpackmvvm.ext.util.logi

/**
 * @Author AlbertZ
 * @CreateDate 2021/2/3
 * @Description Nobody needn't a Application
 */
open class CoreApplication : Application(), Application.ActivityLifecycleCallbacks {
    private val TAG = "CoreApplication"
    private var mActivityCount = 0

    companion object {
        val instance: CoreApplication by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CoreApplication()
        }
    }

    override fun onCreate() {
        super.onCreate()
        "Application onCreate".logi()
        if (AppConstants.ZDEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        registerActivityLifecycleCallbacks(this)
    }


    /**
     * 应用进入后台
     */
    protected open fun onEnterBackground() {

    }

    protected open fun isDebug(): Boolean = BuildConfig.DEBUG

    /**
     * 应用进入前台
     */
    protected open fun onEnterForeGround() {

    }


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        mActivityCount++
        if (mActivityCount > 0) {
            onEnterForeGround()
        }
    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {
        mActivityCount--
        if (mActivityCount == 0) {
            onEnterBackground()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

}