package com.samih.abs.samihtaskmng2017.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.samih.abs.samihtaskmng2017.R;

import java.util.ArrayList;

/**
 * Created by samih on 21/08/2017.
 */

public class UserAdapter extends ArrayAdapter<MyUser>
{
    private int target;
    public final static int GROUPSMEMBERS=1;
    public final static int SEARCH_RESULT_MEMBERS=2;
    public final static int SELCETED_MEMBERS=3;
    public final static int SPINNER_MEMBERS=4;
    private ArrayList<MyUser> selectedUsers;
    public UserAdapter(Context context, int resource,int target) {
        super(context, resource);
        this.target=target;
        selectedUsers=new ArrayList<MyUser>();
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView= LayoutInflater.from(getContext())
                    .inflate(R.layout.itm_user,parent,false);
        TextView tvName= (TextView) convertView.findViewById(R.id.itmtvUserName);
        TextView tvEamil= (TextView) convertView.findViewById(R.id.itmtvUserEmail);
        ImageButton ibtnCall= (ImageButton) convertView.findViewById(R.id.itmBtnUserCall);
        ImageButton ibtnDel= (ImageButton) convertView.findViewById(R.id.itmBtnUserDel);
        CheckBox cbSelect=(CheckBox)convertView.findViewById(R.id.itmCBSelect);

        final MyUser myUser=getItem(position);

        tvEamil.setText(myUser.getEmail());
        tvName.setText(myUser.getName());

        switch (target)
        {
            case GROUPSMEMBERS:
                ibtnDel.setVisibility(View.GONE);
                cbSelect.setVisibility(View.GONE);
                ibtnCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        call(myUser.getPhone());
                    }
                });
            break;
            case SEARCH_RESULT_MEMBERS:
                ibtnCall.setVisibility(View.GONE);
                ibtnDel.setVisibility(View.GONE);
                cbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                    {
                        select(myUser,isChecked);

                    }
                });

                break;
            case SELCETED_MEMBERS:
                ibtnCall.setVisibility(View.GONE);
                cbSelect.setVisibility(View.GONE);
                ibtnDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteMemeber(myUser);
                    }
                });
                break;
            case SPINNER_MEMBERS:
                ibtnCall.setVisibility(View.GONE);
                cbSelect.setVisibility(View.GONE);
                ibtnDel.setVisibility(View.GONE);
                break;
        }


        return convertView;
    }

    //todo delete user from the selected memebres
    private void deleteMemeber(MyUser myUser)
    {
        remove(myUser);
    }



    private void select(MyUser myUser, boolean isChecked)
    {
        if (isChecked)
        {
            selectedUsers.add(myUser);
        }
        else
        {
            selectedUsers.remove(myUser);
        }
    }
    public ArrayList<MyUser> getSelectedUsers() {
        return selectedUsers;
    }
    //todo make call by intent
    private void call(String phone)
    {

    }

    public void clearSlectedUsers() {
        selectedUsers.clear();
    }
}
