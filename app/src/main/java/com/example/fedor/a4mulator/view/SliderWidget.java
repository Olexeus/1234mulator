package com.example.fedor.a4mulator.view;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fedor.a4mulator.R;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by User on 3/18/2018.
 */

public class SliderWidget extends Fragment {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private String[] urls;
    private Button btnSkip, btnNext;
    Context c;                       //commit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.slider_fragment, container, false);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) view.findViewById(R.id.layout_dots);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c=(getActivity());
        urls = new String[]{
                "http://images.wisegeek.com/url-address.jpg",
                "https://www.pakistankakhudahafiz.com/pkkhnew/wp-content/uploads/2017/12/url1.jpg"
               };

        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < urls.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {

                }
            }
        });
    }



        private void addBottomDots ( int currentPage){
            dots = new TextView[urls.length];

//            int[] colorsActive = c.getResources().getIntArray(R.array.array_dot_active);
//            int[] colorsInactive = c.getResources().getIntArray(R.array.array_dot_inactive);

            dotsLayout.removeAllViews();
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(c);
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
//                dots[i].setTextColor(colorsInactive[currentPage]);
                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0)
                dots[currentPage].setTextColor(Color.WHITE);
//                dots[currentPage].setTextColor(colorsActive[currentPage]);
        }

        private int getItem ( int i){
            return viewPager.getCurrentItem() + i;
        }



        //  viewpager change listener
        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == urls.length - 1) {
                    // last page. make button text to GOT IT

                } else {
                    // still pages are left

                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        };

        /**
         * Making notification bar transparent
         */


    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ImageView imageView = new ImageView(c);
            Picasso.with(c)
                    .load(urls[position])
                    .placeholder(R.drawable.common_full_open_on_phone)
                    .error(R.drawable.ic_facebook)
                    .into(imageView);
            View view = layoutInflater.inflate((XmlPullParser) imageView, container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return urls.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

};