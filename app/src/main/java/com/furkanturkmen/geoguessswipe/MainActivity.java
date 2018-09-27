package com.furkanturkmen.geoguessswipe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GeoObject> mGeoObjects = new ArrayList<>();
    int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_EUROPES[i]));
        }
        RecyclerView mGeoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        /*
        Add a touch helper to the RecyclerView to recognize when a user swipes to delete a list entry.
        An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
        and uses callbacks to signal when a user is performing these actions.
        */
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =

                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target){
                        return false;
                    }


                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        //Log.d("Europe")                        
                        int position = viewHolder.getAdapterPosition();

                        if((mGeoObjects.get(viewHolder.getAdapterPosition()).isGeoEurope() && swipeDir == ItemTouchHelper.LEFT) ||
                        (!mGeoObjects.get(viewHolder.getAdapterPosition()).isGeoEurope() && swipeDir == ItemTouchHelper.RIGHT)){
                            Toast.makeText(MainActivity.this, "Goed", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Fout", Toast.LENGTH_SHORT).show();
                        }
                        mAdapter.notifyItemChanged(viewHolder.getAdapterPosition());

                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);

    }
}
