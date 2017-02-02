package com.example.oleksandr.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.MaskFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Oleksandr on 19.01.2017.
 */

public class PictureUtils{

    public static Bitmap getScaledBitmap(String path, Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay()
                .getSize(size);
        return getScaledBitmap(path, size.x, size.y);
    }
    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        //читання розмірв зображення
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);

            float srcWidth = options.outWidth;
            float srcHeight = options.outHeight;

            //вичислення ступення масштабування
            int inSampleSize = 1;

            if (srcHeight > destHeight || srcWidth > destWidth) {
                if (srcHeight > destHeight) {
                    inSampleSize = Math.round(srcHeight / destHeight);
                } else {
                    inSampleSize = Math.round(srcWidth / destWidth);
                }
            }

            options = new BitmapFactory.Options();
            options.inSampleSize = inSampleSize;

            return BitmapFactory.decodeFile(path, options);
    }
}
