package com.kevin.circularprogressview.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by XieJiaHua on 2016/2/23.
 * Company:PeanutRun Ltd.
 * Email:lylwo317@gmail.com
 */
public class DimensionUtils {
    public static int dpToPx(Context context, int dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()) + 0.5);
    }
}
