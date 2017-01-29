package com.nagajothy.smazee.praestantia;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events_fragment extends Fragment {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;




    public Events_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_events_fragment, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.tab);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());

        viewPagerAdapter.addFragment(new Paper_fragment(),"Paper Presentation");
        viewPagerAdapter.addFragment(new Bot_fragment(),"Bot Race");
        viewPagerAdapter.addFragment(new Mission_fragment(),"Mission Impossible");
        viewPagerAdapter.addFragment(new Connexions_fragment(),"Technical Connexions");
        viewPagerAdapter.addFragment(new Fanatics_fragment(),"Fanout Fanatics");
        viewPagerAdapter.addFragment(new Rules_fragment(),"Updates");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;


    }

}
