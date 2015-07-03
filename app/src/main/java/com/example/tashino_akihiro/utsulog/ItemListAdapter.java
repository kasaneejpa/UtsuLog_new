package com.example.tashino_akihiro.utsulog;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by akihiro on 2015/05/30.
 */
public class ItemListAdapter extends ArrayAdapter<ItemBean> {
    public ItemListAdapter(Context context,List<ItemBean> objects){
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layout = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layout.inflate(R.layout.row, null);
        }
        ItemBean bean = getItem(position);

        TextView txtJudge= (TextView) convertView.findViewById(R.id.rowJudge);
        txtJudge.setText(String.valueOf(bean.getJudge()));
        TextView txtHeight = (TextView) convertView.findViewById(R.id.rowComment);
        txtHeight.setText(String.valueOf(bean.getComment()));
        TextView txtWeight = (TextView) convertView.findViewById(R.id.rowTime);
        txtWeight.setText(String.valueOf(bean.getDate()));

        ImageView image = (ImageView)convertView.findViewById(R.id.levelImage);
        switch(bean.getLevel()) {
            case 1:
                image.setImageResource(R.drawable.level1);
                break;
            case 2:
                image.setImageResource(R.drawable.level2);
                break;
            case 3:
                image.setImageResource(R.drawable.level3);
                break;
            case 4:
                image.setImageResource(R.drawable.level4);
                break;
        }
        return convertView;
    }
}

