package com.example.hp.slideactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HP on 11/16/2016.
 */
public class Fragment2 extends Fragment {
    public Fragment2(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview= (ViewGroup)inflater.inflate(R.layout.fragment_main2, container, false);
        return rootview;
    }
}
