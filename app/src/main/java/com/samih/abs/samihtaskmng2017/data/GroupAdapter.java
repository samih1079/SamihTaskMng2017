package com.samih.abs.samihtaskmng2017.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samih.abs.samihtaskmng2017.R;

/**
 * Created by samih on 20/08/2017.
 */

public class GroupAdapter extends ArrayAdapter<MyGroup>
{
    public GroupAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView= LayoutInflater.from(getContext()).
                    inflate(R.layout.itm_group,parent,false);
        TextView tvGroupName= (TextView) convertView.findViewById(R.id.itmTvGroupName);
        TextView tvOwnerName=(TextView)convertView.findViewById(R.id.itmTVGroupOwner);

        MyGroup myGroup=getItem(position);

        tvGroupName.setText(myGroup.getName());
        //todo לקבל שם אמיתי למנהל הקבוצה
        tvOwnerName.setText(myGroup.getMngrUkey());

        return convertView;
    }

}
