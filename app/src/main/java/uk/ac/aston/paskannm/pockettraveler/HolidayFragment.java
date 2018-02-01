package uk.ac.aston.paskannm.pockettraveler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.adapter.HolidayAdapter;

public class HolidayFragment extends android.support.v4.app.Fragment {

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("Holidays");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holiday, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
        mLayoutManager = new LinearLayoutManager(this.getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);
        holidayList = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            Holiday holiday = new Holiday(titles[i], dates[i], notes[i], thumbnails[i]);
            holidayList.add(holiday);
        }

        mRecyclerView.setAdapter(holidayAdapter);
        holidayAdapter.notifyDataSetChanged();
    }
}
