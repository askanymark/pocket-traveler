package uk.ac.aston.paskannm.pockettraveler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.adapter.HolidayAdapter;

public class HolidayActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Holiday> holidayList;
    private HolidayAdapter holidayAdapter;

    String[] titles = {
            "Trip to San Diego",
            "Journey to center of Earth",
            "Misadventures in Russia"
    };

    String[] dates = {
            "12.12.2017",
            "01.01.1970",
            "12.05.1996"
    };

    String[] notes = {
            "Magnificent!",
            "You won't believe me if I told you",
            "Сука, блять!"
    };

    int[] thumbnails = {
            R.drawable.city,
            R.drawable.earth,
            R.drawable.russia
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
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
        holidayList = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            Holiday holiday = new Holiday(titles[i], dates[i], notes[i], thumbnails[i]);
            holidayList.add(holiday);
        }

        holidayAdapter = new HolidayAdapter(holidayList);

        mRecyclerView.setAdapter(holidayAdapter);
        holidayAdapter.notifyDataSetChanged();
    }
}
