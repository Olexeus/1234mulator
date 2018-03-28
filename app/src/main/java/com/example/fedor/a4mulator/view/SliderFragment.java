package com.example.fedor.a4mulator.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fedor.a4mulator.R;


public class SliderFragment extends Fragment {
    PageAdapter adapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    public static SliderFragment newInstance() {

        SliderFragment fragment = new SliderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ViewPager pager = (ViewPager)view.findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) view.findViewById(R.id.layout_dots);
        adapter = new PageAdapter(view.getContext());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(viewPagerPageChangeListener);
        addBottomDots(0);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.slider_fragment, container, false);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[3];
        int[] dots_colors = getResources().getIntArray(R.array.array_dot);
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(dots_colors[0]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(dots_colors[1]);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) { //TODO pass layouts data
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

}
