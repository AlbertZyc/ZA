package yc.zalbert.za.utils

import android.util.Log
import com.zalbert.za.BuildConfig
import yc.zalbert.za.CoreConstants


/**
@Author AlbertZ
@CreateDate 2021/2/4
@Description 描述
 */
open class ZLog {
    private var mClassName: String? = null
    private var methodName: String? = null
    private var lineNumber = 0

    /**
     * 判断是否调试环境
     * @return
     */
    open fun isDebuggable(): Boolean {
        return BuildConfig.DEBUG
    }

    private fun getFunctionName(): String? {
        val sts = Thread.currentThread().stackTrace ?: return null
        for (st in sts) {
            if (st.isNativeMethod) {
                continue
            }
            if (st.className == Thread::class.java.name) {
                continue
            }
            if (st.className == this.javaClass.name) {
                continue
            }
            return (mClassName.toString() + "[ " + Thread.currentThread().name + ": "
                    + st.fileName + ":" + st.lineNumber + " "
                    + st.methodName + " ]")
        }
        return ""
    }

    companion object {

        fun i(msg: String) {
            Log.i(CoreConstants.ZYC, "msg")
        }

        fun i(head: String, msg: String) {
            Log.i("${CoreConstants.ZYC}-$head", msg)
        }

        fun i(any: Any, msg: String) {
            Log.i("${CoreConstants.ZYC}-${any.javaClass}", msg)
        }
//        fun i(msg: String) {
//            print(CoreConstant.ZYC + msg)
//        }
//
//        fun i(head: String, msg: String) {
//            print("${CoreConstant.ZYC}-$head" + msg)
//        }
    }
}