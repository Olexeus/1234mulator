package com.example.fedor.a4mulator.view;

/**
 * Created by fedor on 21.10.2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fedor.a4mulator.R;

public class FormulasFragment extends Fragment {

    PageAdapter adapter;
    public static FormulasFragment newInstance() {
        FormulasFragment fragment = new FormulasFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        SliderFragment sliderWidget = new SliderFragment();
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ineslider,new SliderWidget()).commit();

        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.replace(R.id.pust_frag,new SliderFragment());
        transaction.addToBackStack(null);
        transaction.commit();
//        ViewPager pager = (ViewPager) getView().findViewById(R.id.view_pager);
//        adapter = new PageAdapter(getContext());
//        pager.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }
}