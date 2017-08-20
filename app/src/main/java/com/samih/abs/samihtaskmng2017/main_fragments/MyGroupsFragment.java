package com.samih.abs.samihtaskmng2017.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.samih.abs.samihtaskmng2017.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGroupsFragment extends Fragment implements TitleAble {

    private ListView lstvGrpoups;

    public MyGroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_groups, container, false);
        lstvGrpoups= (ListView) view.findViewById(R.id.lstVGroups);
        //todo connet the list view to the data sourse by Adapter

        return view;
    }
    public String getTitle()
    {
        return "My Groups";
    }

}
