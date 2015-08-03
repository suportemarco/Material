package com.bematech.material.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bematech.material.R;
import com.bematech.material.fragments.AboutFragment;
import com.bematech.material.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAppCompat();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupAppCompat() {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

//        <!-- NAO APAGAR -->
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

//        <!-- NAO APAGAR -->
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

//        <!-- NAO APAGAR -->
//        if (viewPager != null) {
//            setupViewPager(viewPager);
//            tabLayout.setupWithViewPager(viewPager);
//        }

//        <!-- NAO APAGAR -->
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();

                        Fragment fragment;

                        if (menuItem.getItemId() == R.id.nav_menu_home) {
                            fragment = new HomeFragment();
                            openFragment(fragment);
                            menuItem.setChecked(true);
                            return true;

                        } else if (menuItem.getItemId() == R.id.nav_menu_about) {
                            fragment = new AboutFragment();
                            openFragment(fragment);
                            menuItem.setChecked(true);
                            return true;
                        }

// else if (menuItem.getItemId() == R.id.nav_gifview) {
//                            Intent intent = new Intent(MainActivity.this, CustomGifViewActivity.class);
//                            startActivity(intent);
//                        } else if (menuItem.getItemId() == R.id.nav_home) {
//                            Intent intent = new Intent(MainActivity.this, GifActivity.class);
//                            startActivity(intent);
//                        }
                        return true;
                    }
                });
    }

    private void openFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
//        ImageListFragment fragment = new ImageListFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("type", 1);
//        fragment.setArguments(bundle);
//        adapter.addFragment(fragment, "one");
//        fragment = new ImageListFragment();
//        bundle = new Bundle();
//        bundle.putInt("type", 2);
//        fragment.setArguments(bundle);
//        adapter.addFragment(fragment, "two");
//        fragment = new ImageListFragment();
//        bundle = new Bundle();
//        bundle.putInt("type", 3);
//        fragment.setArguments(bundle);
//        adapter.addFragment(fragment, "three");


        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
