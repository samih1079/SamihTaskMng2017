package com.samih.abs.samihtaskmng2017.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.samih.abs.samihtaskmng2017.R;
import com.samih.abs.samihtaskmng2017.data.DBUtils;
import com.samih.abs.samihtaskmng2017.data.MyTasks;
import com.samih.abs.samihtaskmng2017.data.MyUser;
import com.samih.abs.samihtaskmng2017.data.TasksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTasksFragment extends Fragment implements TitleAble {

    private ListView lstMyTasks;
    private TasksAdapter tasksAdapter;

    public MyTasksFragment() {
        // Required empty public constructor
        //lkjljlkjklj
        //kljlkjckljsadlk
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_tasks2, container, false);
        lstMyTasks= (ListView) view.findViewById(R.id.lstVTasks);
        lstMyTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        //todo conncet the listview to dtat source by Adpater
        initListview();
        return view;
    }

    private void initListview()
    {
        if(tasksAdapter==null)
            tasksAdapter=new TasksAdapter(getActivity(),R.layout.itm_task);

        //todo get the data source and set it to the adapter
        String userEmail=DBUtils.auth.getCurrentUser().getEmail();
        DBUtils.myTasksRef.orderByChild("uKey").equalTo(userEmail).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                tasksAdapter.clear();
//                for (int i = 0; i <dataSnapshot.getChildrenCount() ; i++)
//                {
//                    DataSnapshot ds=dataSnapshot.getChildren().iterator().next();
//                    MyTasks myTasks=ds.getValue(MyTasks.class);
//                    tasksAdapter.add(myTasks);
//                }
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    MyTasks myTasks=ds.getValue(MyTasks.class);
                    tasksAdapter.add(myTasks);
                }
                lstMyTasks.setAdapter(tasksAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public String getTitle()
    {
        return "My Tasks";
    }

}
