package com.samih.abs.samihtaskmng2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
    }
    // Initialize Firebase Auth
//        auth = FirebaseAuth.getInstance();
//        firebaseUser = auth.getCurrentUser();
//        if (firebaseUser == null) {
//            // Not signed in, launch the Sign In activity
//            startActivity(new Intent(this, LogInActivity.class));
//            finish();
//            return;
//        } else {
//            String userName = firebaseUser.getDisplayName();
//            if (firebaseUser.getPhotoUrl() != null) {
//                String   photoUrl = firebaseUser.getPhotoUrl().toString();
//            }
//        }
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference refMyUsers=database.getReference("MyUsers");
    DatabaseReference refmyGroups=database.getReference("MyGroups");
    DatabaseReference refMyTasks=database.getReference("MyTasks");
    //TODO how to retrieve Hashmap
//        refMyUsers.child("a3@a3*com").child("groupsKeys").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                HashMap<String,Object> groupsKeys= (HashMap<String, Object>) dataSnapshot.getValue();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    //TODO how to retrieve user object by ref and updating List
//        refMyUsers.child("a3@a3*com").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                MyUser myUser=dataSnapshot.getValue(MyUser.class);
//                myUser.addGruopsKeys("gg1");
//                myUser.addGruopsKeys("gg2");
//                refMyUsers.child("a3@a3*com").child("groupsKeys").child("gg3").setValue(true);
//              //Todo remove child
//                refMyUsers.child("a3@a3*com").child("groupsKeys").child("gg3").removeValue();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
////TODO MyUsers order by Child "name"
//        refMyUsers.orderByChild("name").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
//                {
//                    MyUser myUser=dataSnapshot1.getValue(MyUser.class);
//                    myUser.getName();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


//
//        MyUser u=new MyUser();
//        u.setName("s3");
//        u.setuKey_email("a4@a4.com");
//        u.setPhone("055555");
//        u.addTasksKey("t1");
//        u.addTasksKey("t2");
//        u.addTasksKey("t3");
//        u.addGruopsKeys("g1");
//
//        refMyUsers.child(u.getuKey_email()).setValue(u);
//
//        MyGroup myGroup=new MyGroup();
//        myGroup.setName("g1");
//        myGroup.setMngrUkey(u.getuKey_email());
//        myGroup.setgKey(refmyGroups.push().getKey());
//        refmyGroups.child(myGroup.getgKey()).setValue(myGroup);
//
//        MyTasks myTasks=new MyTasks();
//        myTasks.setgKey(myGroup.getgKey());
//        myTasks.setuKey(u.getuKey_email());
//        myTasks.setText("do H.W");
//        myTasks.setCompleted(false);
//        myTasks.setCreatedAt(System.currentTimeMillis());
//        myTasks.settKey(refMyTasks.push().getKey());
//        refMyTasks.child(myTasks.gettKey()).setValue(myTasks);

}
