package edu.temple.colorfragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * CIS 3515 - Lab 6 Palette Activity Spanish
 * Toi Do 10/23/2019
 */
public class CanvasFragment extends Fragment {


    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_canvas, container, false);
    }

    public void onColorInteraction(String color){
        getView().setBackgroundColor(Color.parseColor(color));
    }
}

