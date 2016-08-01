package com.ithomaslin.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by thomaslin on 8/1/16.
 *
 */
public class ParallaxPageAdapter extends PagerAdapter {
    private final LayoutInflater inflater;
    private final List<Integer> images;

    public ParallaxPageAdapter(Context context, List<Integer> images) {
        this.inflater = LayoutInflater.from(context);
        this.images = images;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View parallaxContainer = inflater.inflate(R.layout.page_layout, container, false);
        ImageView image = (ImageView) parallaxContainer.findViewById(R.id.image);
        ViewHolder holder = new ViewHolder(image);

        image.setImageResource(images.get(position));
        container.addView(parallaxContainer);
        parallaxContainer.setTag(holder);
        return parallaxContainer;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
