package com.ithomaslin.myapplication;

import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by thomaslin on 8/1/16.
 *
 */
public class ParallaxTransformer implements ViewPager.PageTransformer {

    private static final String TAG = ParallaxTransformer.class.getSimpleName();

    @Override
    public void transformPage(View view, float position) {

        RelativeLayout root = (RelativeLayout) ((FrameLayout) view).getChildAt(0);
        if (root == null) {
            return;
        }

        ImageView imageView = (ImageView) root.getChildAt(0);

        if (position < -1) {
            imageView.setAlpha((float) 0);
        } else if (position <= 1) {
            Matrix matrix = new Matrix();
            matrix.reset();

            float viewWidth = imageView.getWidth();
            float viewHeight = imageView.getHeight();

            float intrinsicWidth = imageView.getDrawable().getIntrinsicWidth();
            float intrinsicHeight = imageView.getDrawable().getIntrinsicHeight();

            float newWidth = viewWidth;
            float newHeight = viewHeight;

            float scale = 0.0f;

			/*
			 * if the difference in width is proportionally greater than difference in
			 * height (ex: 2.5 > 1.9) then scale the bitmap by the height factor
			 */
            if (intrinsicWidth / viewWidth > intrinsicHeight / viewHeight) {
                scale = viewHeight / intrinsicHeight;
                matrix.setScale(scale, scale);
                newWidth = intrinsicWidth * scale;
            }
			/*
			 * else, scale the bitmap by the width factor
			 */
            else {
                scale = viewWidth / intrinsicWidth;
                matrix.setScale(scale, scale);
                newHeight = intrinsicHeight * scale;
            }

			/* offset to center the view horizontally */
            float xOffset = (viewWidth - newWidth) / 2;

			/*
			 * strategy:
			 * 1) get pixels moved relative to the view frame (X)
			 * 2) move the bitmap 0.5f * X
			 */
            float xPos = -position * viewWidth * 0.5f + xOffset;

            // IGNORE BELOW THIS LINE
            float yPos = (viewHeight - newHeight) / 2;
            matrix.postTranslate(xPos, yPos);
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            imageView.setImageMatrix(matrix);
        } else {
            imageView.setAlpha((float) 0);
        }
    }
}

