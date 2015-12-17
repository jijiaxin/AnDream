package com.jjx.andream.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjx.andream.R;

import java.util.Locale;

/**
 * Created by jjx on 2015/11/21.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private final String ARG_SECTION_NUMBER = "section_number";
    private PlaceholderFragment fragment;
    private int flag;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(fragment.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        flag = getArguments().getInt(ARG_SECTION_NUMBER);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView mTextView = (TextView) rootView.findViewById(R.id.section_label);
        Locale l = Locale.getDefault();
        switch (flag) {
            case 0:
                mTextView.setText(getString(R.string.title_section1).toUpperCase(l));
            case 1:
                mTextView.setText(getString(R.string.title_section2).toUpperCase(l));
            case 2:
                mTextView.setText(getString(R.string.title_section3).toUpperCase(l));
            case 3:
                mTextView.setText(getString(R.string.title_section1).toUpperCase(l));
        }

        return rootView;
    }
}
