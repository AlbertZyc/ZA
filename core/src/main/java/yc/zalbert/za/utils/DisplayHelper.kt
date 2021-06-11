package yc.zalbert.za.utils

import android.content.res.Resources

/**
@Author AlbertZ
@CreateDate 2021/5/20
@Description 描述
 */
class DisplayHelper {
    companion object {
        fun pixToDp(float: Float) {

        }

        fun dpToPix(dp: Float) = (dp * Resources.getSystem().displayMetrics.density + .5f)

    }


}