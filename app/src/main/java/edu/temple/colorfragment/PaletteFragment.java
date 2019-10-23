package edu.temple.colorfragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * CIS 3515 - Lab 6 Palette Activity Spanish
 * Toi Do 10/23/2019
 */

public class PaletteFragment extends Fragment {
    public static final String COLOR_KEY = "colors";

    String[] colors;

    private OnColorInteractionListener mListener;

    public PaletteFragment() {
    }


    public static PaletteFragment newInstance(String[] colors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray("colors", colors);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = getArguments().getStringArray(COLOR_KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ListView listView = (ListView)inflater.inflate(R.layout.fragment_palette, container, false);

        ArrayAdapter adapter = new ArrayAdapter((Context)mListener, android.R.layout.simple_list_item_1, colors);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mListener.onColorInteraction(adapterView.getItemAtPosition(position).toString());
            }

        });
        return listView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnColorInteractionListener) {
            mListener = (OnColorInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnColorInteractionListener{
        void onColorInteraction(String color);
    }
}
