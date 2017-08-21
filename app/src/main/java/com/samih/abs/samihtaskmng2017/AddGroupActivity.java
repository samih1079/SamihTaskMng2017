package com.samih.abs.samihtaskmng2017;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.samih.abs.samihtaskmng2017.data.DBUtils;
import com.samih.abs.samihtaskmng2017.data.MyUser;
import com.samih.abs.samihtaskmng2017.data.UserAdapter;

import java.util.ArrayList;

public class AddGroupActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etGroupName,etEmail,etUserName;
    private ImageButton ibtnSearch,ibtnAddMember, ibtnSaveGroup;
    private ListView lstvMembersSearchResult,lstvSelectedMembers;

    private UserAdapter userAdapterSearchResult,userAdapterSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        etGroupName= (EditText) findViewById(R.id.etGroupName);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etUserName= (EditText) findViewById(R.id.etName);
        ibtnSearch= (ImageButton) findViewById(R.id.ibtnSearch);
        ibtnAddMember= (ImageButton) findViewById(R.id.ibntAddMember);
        ibtnSaveGroup = (ImageButton) findViewById(R.id.ibntSaveGroup);
        lstvMembersSearchResult= (ListView) findViewById(R.id.lstvMembersSearchResult);
        lstvSelectedMembers=(ListView)findViewById(R.id.lstvSelectedMembers);

        userAdapterSearchResult=
                new UserAdapter(this,R.layout.itm_user,UserAdapter.SEARCH_RESULT_MEMBERS);
        userAdapterSelected=
                new UserAdapter(this,R.layout.itm_user,UserAdapter.SELCETED_MEMBERS);
        lstvMembersSearchResult.setAdapter(userAdapterSearchResult);
        lstvSelectedMembers.setAdapter(userAdapterSelected);


        eventHandler();


    }

    private void eventHandler()
    {
        ibtnSaveGroup.setOnClickListener(this);
        ibtnAddMember.setOnClickListener(this);
        ibtnSearch.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {

        if(v==ibtnSearch)
        {
            search();
        }
        if(v==ibtnAddMember)
        {
            addSelectedUsers();
        }
        if(v==ibtnSaveGroup)
        {

        }

    }

    private void addSelectedUsers()
    {
        ArrayList<MyUser> selectedUsers=userAdapterSearchResult.getSelectedUsers();
        userAdapterSelected.addAll(selectedUsers);
//        for (MyUser user:selectedUsers)
//        {
//            userAdapterSelected.add(user);
//
//        }
         userAdapterSearchResult.clearSlectedUsers();

    }

    private void search()
    {
        String stEmail=etEmail.getText().toString();
        String stName=etUserName.getText().toString();
        userAdapterSearchResult.clear();

        final ProgressDialog progressDialog=ProgressDialog.show(this,"Wait","Searching",true);


        if(stEmail.length()>0)
        {
            progressDialog.show();
            //todo בגלל שיש לנו הפנייה לערך הרצוי לא נבצע שאילתא
            DBUtils.myUsersRef.child(stEmail.replace('.','*'))
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    progressDialog.dismiss();
                        if(dataSnapshot.exists())
                        {
                            MyUser myUser=dataSnapshot.getValue(MyUser.class);
                            userAdapterSearchResult.add(myUser);
                        }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        if(stName.length()>0)
        {
//            Query query=DBUtils.myUsersRef.orderByChild("name").equalTo(stName);
//            query.addListenerForSingleValueEvent(...);
            if(progressDialog.isShowing()==false)progressDialog.show();
            DBUtils.myUsersRef.orderByChild("name").equalTo(stName).
                    addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    if(progressDialog.isShowing())progressDialog.dismiss();
                    for (DataSnapshot ds:dataSnapshot.getChildren())
                    {
                        MyUser myUser=ds.getValue(MyUser.class);
                        userAdapterSearchResult.add(myUser);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

    }
}
