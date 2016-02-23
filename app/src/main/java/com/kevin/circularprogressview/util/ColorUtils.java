package com.kevin.circularprogressview.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

import com.kevin.circularprogressview.R;

/**
 * Created by XieJiaHua on 2016/2/23.
 * Company:PeanutRun Ltd.
 * Email:lylwo317@gmail.com
 */
public class ColorUtils {
    private static TypedValue value;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorPrimary(Context context, int defaultValue){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return getColor(context, android.R.attr.colorPrimary, defaultValue);

        return getColor(context, R.attr.colorPrimary, defaultValue);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static int colorPrimaryDark(Context context, int defaultValue){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return getColor(context, android.R.attr.colorPrimaryDark, defaultValue);

        return getColor(context, R.attr.colorPrimaryDark, defaultValue);
    }
    private static int getColor(Context context, int id, int defaultValue){
        if(value == null)
            value = new TypedValue();

        try{
            Resources.Theme theme = context.getTheme();
            if(theme != null && theme.resolveAttribute(id, value, true)){
                if (value.type >= TypedValue.TYPE_FIRST_INT && value.type <= TypedValue.TYPE_LAST_INT)
                    return value.data;
                else if (value.type == TypedValue.TYPE_STRING)
                    return context.getResources().getColor(value.resourceId);
            }
        } catch(Exception ex){}

        return defaultValue;
    }
}
