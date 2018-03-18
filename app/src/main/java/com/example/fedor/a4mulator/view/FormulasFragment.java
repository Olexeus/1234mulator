package com.example.fedor.a4mulator.view;

/**
 * Created by fedor on 21.10.2017.
 */

        import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fedor.a4mulator.R;

public class FormulasFragment extends Fragment {
    public static FormulasFragment newInstance() {
        FormulasFragment fragment = new FormulasFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }
}