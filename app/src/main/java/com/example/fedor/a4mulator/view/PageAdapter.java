package com.example.fedor.a4mulator.view;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fedor.a4mulator.R;

/**
 * Created by User on 3/23/2018.
 */

//public class PageAdapter extends FragmentPagerAdapter {
//    private int num = 3;
//
//    public PageAdapter(FragmentManager fragmentManager) {
//        super(fragmentManager);
//    }
//
//    @Override
//    public int getCount() {
//        return  num;
//    }
//
//    @Override
//    public SlidePage getItem(int position) {
//        switch (position) {
//            case 0:
//                return SlidePage.newInstance("EMail");
//            case 1:
//                return SlidePage.newInstance("Alert");
//            case 2:
//                return SlidePage.newInstance("Dialer");
//            default:
//                return null;
//        }
//    }
//}
class PageAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

//    int[] resources = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

    public PageAdapter(Context context) {
        context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
//        return resources.length;
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.slide_page_fragment, container, false);

//        ImageView ivIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
//        ivIcon.setImageResource(resources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}