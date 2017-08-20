package com.samih.abs.samihtaskmng2017.data;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.samih.abs.samihtaskmng2017.R;

import java.util.Date;


/**
 * Created by samih on 17/08/2017.
 */

public class TasksAdapter extends ArrayAdapter<MyTasks>
{
    public TasksAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {

            convertView=
                    LayoutInflater.from(getContext()).inflate(R.layout.itm_task,parent,false);
        }

        MyTasks task=getItem(position);

        TextView tvText= (TextView) convertView.findViewById(R.id.itmTvText);
        CheckBox cbIsCompleted= (CheckBox) convertView.findViewById(R.id.itmCBIscompleted);
        TextView tvCreatedAt= (TextView) convertView.findViewById(R.id.itmTvCreatedAt);
        TextView tvAddress= (TextView) convertView.findViewById(R.id.itmTvAddress);
        TextView tvUser= (TextView) convertView.findViewById(R.id.itmTvUser);
        Button btnGroup= (Button) convertView.findViewById(R.id.itmbtnGroup);

        tvText.setText(task.getText());
        cbIsCompleted.setChecked(task.isCompleted());
        tvAddress.setText(task.getAddress());
       //todo convert the key to real name
        tvUser.setText(task.getuKey());
        //todo convert the key to real name
        btnGroup.setText(task.getgKey());

        Date date=new Date(task.getCreatedAt());
        tvCreatedAt.setText(date.toString());


        return convertView;
    }

}
