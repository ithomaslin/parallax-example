package com.ithomaslin.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        List<Integer> images = Arrays.asList(
                R.raw.background1,
                R.raw.background2,
                R.raw.background3,
                R.raw.background4);

        pager.setPageTransformer(false, new ParallaxTransformer());
        pager.setAdapter(new ParallaxPageAdapter(this, images));
        pager.setOffscreenPageLimit(images.size());

    }
}
