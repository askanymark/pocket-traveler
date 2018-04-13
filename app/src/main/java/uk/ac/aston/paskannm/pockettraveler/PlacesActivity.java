package uk.ac.aston.paskannm.pockettraveler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.adapter.PlaceAdapter;

public class PlacesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

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

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Set "Places" as currently open in Navigation Menu (visual clarity tweak)
        navigationView.setCheckedItem(R.id.nav_places);

        for (int i = 0; i < titles.length; i++) {
            Place place = new Place(titles[i], dates[i], thumbnails[i]);
            placeList.add(place);
        }

        placeAdapter = new PlaceAdapter(placeList);

        mRecyclerView.setAdapter(placeAdapter);
        placeAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            setCurrentCheckedNavigationItem(R.id.nav_home);
        } else if (id == R.id.nav_holidays) {
            Intent i = new Intent(this, HolidayActivity.class);
            startActivity(i);
            setCurrentCheckedNavigationItem(R.id.nav_holidays);
        } else if (id == R.id.nav_places) {
            Intent i = new Intent(this, PlacesActivity.class);
            startActivity(i);
            setCurrentCheckedNavigationItem(R.id.nav_places);
        } else if (id == R.id.nav_gallery) {
            /*
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, new GalleryFragment());
            ft.commit();
            */
        } else if (id == R.id.nav_settings) {
            /*
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, new SettingsFragment());
            ft.commit();
            */
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            return true;
        } else if (id == R.id.feedback) {

        } else if (id == R.id.help) {

        } else if (id == R.id.delete) {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setCurrentCheckedNavigationItem(@IdRes int id) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(id);
    }


}
