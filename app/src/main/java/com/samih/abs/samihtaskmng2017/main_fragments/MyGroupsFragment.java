package com.samih.abs.samihtaskmng2017.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.samih.abs.samihtaskmng2017.R;
import com.samih.abs.samihtaskmng2017.data.DBUtils;
import com.samih.abs.samihtaskmng2017.data.GroupAdapter;
import com.samih.abs.samihtaskmng2017.data.MyGroup;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGroupsFragment extends Fragment implements TitleAble {

    private ListView lstvGrpoups;
    private GroupAdapter groupAdapter;

    public MyGroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_groups, container, false);
        lstvGrpoups= (ListView) view.findViewById(R.id.lstVGroups);
        initListview();

        return view;
    }

    private void initListview()
    {
        if(groupAdapter==null)
        groupAdapter=new GroupAdapter(getActivity(),R.layout.itm_group);
        String userEmail=DBUtils.auth.getCurrentUser().getEmail();

        DBUtils.myUsersRef.child(userEmail.replace('.','*')+"/groupsKeys").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String,Object> groupsKeys= (HashMap<String, Object>) dataSnapshot.getValue();
                groupAdapter.clear();
                for (String gr:groupsKeys.keySet())
                {
                    DBUtils.myGroupsRef.child(gr).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            MyGroup myGroup=dataSnapshot.getValue(MyGroup.class);
                            groupAdapter.add(myGroup);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

                lstvGrpoups.setAdapter(groupAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public String getTitle()
    {
        return "My Groups";
    }

}
