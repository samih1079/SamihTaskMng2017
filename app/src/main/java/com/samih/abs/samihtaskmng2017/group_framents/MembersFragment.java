package com.samih.abs.samihtaskmng2017.group_framents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samih.abs.samihtaskmng2017.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MembersFragment extends Fragment {


    public MembersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_members, container, false);
    }

}
