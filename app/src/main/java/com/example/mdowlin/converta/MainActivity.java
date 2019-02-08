package com.example.mdowlin.converta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    FragTemp tempfrag;
    FragLength lengthfrag;
    FragWeight weightfrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempfrag = new FragTemp();
        lengthfrag = new FragLength();
        weightfrag = new FragWeight();
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new ThreeFragmentPagerAdapter(fragmentManager));

        viewPager.setCurrentItem(1);

    }



    public class ThreeFragmentPagerAdapter extends FragmentPagerAdapter {
        int PAGE_COUNT = 3;

        //required constructor that simply supers.
        public ThreeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // return the correct fragment based on where in pager we are.
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return tempfrag;
                case 1:
                    return lengthfrag;
                case 2:
                    return weightfrag;
                default:
                    return null;
            }
        }

        //how many total pages in the viewpager there are.  3 in this case.
        @Override
        public int getCount() {

            return PAGE_COUNT;
        }

        //getPageTitle required for the PageStripe to work and have a value.
        @Override
        public CharSequence getPageTitle(int position) {

            if(position == 0)
            {
                return "Tempurature";
            }
            else if(position == 1)
            {
                return "Length";
            }
            else
            {
                return "Weight";
            }

        }

    }

}
