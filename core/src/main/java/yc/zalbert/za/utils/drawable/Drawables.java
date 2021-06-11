package yc.zalbert.za.utils.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.Display;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.IntDef;
import androidx.annotation.RequiresApi;
import androidx.databinding.BindingAdapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import yc.zalbert.za.utils.DisplayHelper;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;


public class Drawables {
    private static final String TAG = "Drawables";

    private static final int INVALID = 0;
    private static final int[] tmpPadding = new int[4];

    // normal, checked, checkable, enabled, focused, pressed, selected
    @RequiresApi(api = Build.VERSION_CODES.O)
    @BindingAdapter(value = {
            "app:marginHorizontal"

    }, requireAll = false)
    public static void setMarginHorizontal(View view, int margin) {
        Drawable defaultDrawable = view.getBackground();
        defaultDrawable = new InsetDrawable(defaultDrawable, DisplayHelper.Companion.dpToPix(margin),
                0,
                DisplayHelper.Companion.dpToPix(margin),
                0);
        view.setBackground(defaultDrawable);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @BindingAdapter(value = {
            "app:marginVertical"

    }, requireAll = false)
    public static void setMarginVertical(View view, int margin) {
        Drawable defaultDrawable = view.getBackground();
        defaultDrawable = new InsetDrawable(defaultDrawable, 0,
                DisplayHelper.Companion.dpToPix(margin),
                0,
                DisplayHelper.Companion.dpToPix(margin));
        view.setBackground(defaultDrawable);
    }

    @BindingAdapter(value = {
            "app:paddingVertical"
    }, requireAll = false)
    public static void setPaddingVertical(View view, int padding) {
        view.setPadding(view.getPaddingStart(), padding, view.getPaddingEnd(), padding);
    }


    @IntDef({
            ShapeMode.RECTANGLE,
            ShapeMode.OVAL,
            ShapeMode.LINE,
            ShapeMode.RING,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShapeMode {
        int RECTANGLE = GradientDrawable.RECTANGLE;
        int OVAL = GradientDrawable.OVAL;
        /**
         * 画线时，有几点特性必须要知道的：
         * 1. 只能画水平线，画不了竖线；
         * 2. 线的高度是通过stroke的android:width属性设置的；
         * 3. size的android:height属性定义的是整个形状区域的高度；
         * 4. size的height必须大于stroke的width，否则，线无法显示；
         * 5. 线在整个形状区域中是居中显示的；
         * 6. 线左右两边会留有空白间距，线越粗，空白越大；
         * 7. 引用虚线的view需要添加属性android:layerType，值设为"software"，否则显示不了虚线。
         */
        int LINE = GradientDrawable.LINE;
        int RING = GradientDrawable.RING;
    }

    @IntDef({
            GradientType.LINEAR,
            GradientType.RADIAL,
            GradientType.SWEEP
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientType {
        int LINEAR = 0;
        int RADIAL = 1;
        int SWEEP = 2;
    }

    @IntDef({
            Orientation.TOP_BOTTOM,
            Orientation.TR_BL,
            Orientation.RIGHT_LEFT,
            Orientation.BR_TL,
            Orientation.BOTTOM_TOP,
            Orientation.BL_TR,
            Orientation.LEFT_RIGHT,
            Orientation.TL_BR
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
        int TOP_BOTTOM = 0;
        int TR_BL = 1;
        int RIGHT_LEFT = 2;
        int BR_TL = 3;
        int BOTTOM_TOP = 4;
        int BL_TR = 5;
        int LEFT_RIGHT = 6;
        int TL_BR = 7;
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({PARAMETER, FIELD})
    @interface DP {
    }
}
