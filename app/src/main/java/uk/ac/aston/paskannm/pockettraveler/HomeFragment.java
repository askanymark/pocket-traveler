package uk.ac.aston.paskannm.pockettraveler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("Home");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_holidays).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_home, new HolidayFragment());
                ft.commit();
                */
                Intent i = new Intent(getActivity(), HolidayActivity.class);
                startActivity(i);
                ((MainActivity)getActivity()).setCurrentCheckedNavigationItem(R.id.nav_holidays);
            }
        });

        view.findViewById(R.id.button_places).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_home, new PlacesFragment());
                ft.commit();
                ((MainActivity)getActivity()).setCurrentCheckedNavigationItem(R.id.nav_places);
            }
        });

        view.findViewById(R.id.button_gallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_home, new GalleryFragment());
                ft.commit();
                ((MainActivity)getActivity()).setCurrentCheckedNavigationItem(R.id.nav_gallery);
            }
        });

        view.findViewById(R.id.button_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_home, new SettingsFragment());
                ft.commit();
                ((MainActivity)getActivity()).setCurrentCheckedNavigationItem(R.id.nav_settings);
            }
        });
    }
}
