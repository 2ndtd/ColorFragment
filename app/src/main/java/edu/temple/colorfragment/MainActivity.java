package edu.temple.colorfragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;

/**
 * CIS 3515 - Lab 6 Palette Activity Spanish
 * Toi Do 10/23/2019
 */
public class MainActivity extends AppCompatActivity
        implements PaletteFragment.OnColorInteractionListener{

    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasFragment = new CanvasFragment();
        setTitle("Palette Activity");

        Resources res = getResources();
        final String[] colorsEs = res.getStringArray(R.array.colors_es);

        paletteFragment = PaletteFragment.newInstance(colorsEs);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.layout1, paletteFragment)
                .add(R.id.layout2, canvasFragment)
                .commit();

        String title = res.getString(R.string.frag_name);
        setTitle(title);
    }
    @Override
    public void onColorInteraction(String color){
        canvasFragment.onColorInteraction(color);
    }

}
