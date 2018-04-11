package uk.ac.aston.paskannm.pockettraveler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.adapter.PlaceAdapter;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Place> placeList;
    private PlaceAdapter placeAdapter;

    String[] titles = {
            "San Diego",
            "Centre of Earth",
            "Moscow"
    };

    String[] dates = {
            "12.12.2017",
            "01.01.1970",
            "12.05.1996"
    };

    int[] thumbnails = {
            R.drawable.city,
            R.drawable.earth,
            R.drawable.russia
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // Use this setting to improve performance if changes
        // in content don't change layout size of RecyclerView
        /*
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }
         */

        /*
        use this in case of Staggered GridLayoutManager
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
         */

        // using a linearlayout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        placeList = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            Place place = new Place(titles[i], dates[i], thumbnails[i]);
            placeList.add(place);
        }

        placeAdapter = new PlaceAdapter(placeList);

        mRecyclerView.setAdapter(placeAdapter);
        placeAdapter.notifyDataSetChanged();
    }
}
