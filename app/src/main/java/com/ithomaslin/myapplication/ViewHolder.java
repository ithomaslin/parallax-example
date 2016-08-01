package com.ithomaslin.myapplication;

import android.view.View;

/**
 * Created by thomaslin on 8/1/16.
 *
 */
public class ViewHolder {
    private View parallaxView;

    private ViewHolder() {
        this.parallaxView = null;
    }

    public ViewHolder(View parallaxView) {
        this.parallaxView = parallaxView;
    }

    public View getParallaxView() {
        return parallaxView;
    }

    public void setParallaxView(View parallaxView) { this.parallaxView = parallaxView; }
}