package com.example.coursedetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coursedetail.R;

import java.util.ArrayList;
import java.util.List;

public class CourseListTitleSelectionAdapter extends BaseAdapter {

    private List<String> tagList;
    private int selectedPosition=0;
    public CourseListTitleSelectionAdapter(Context context,
                                           List<String> tagList) {
        this.tagList = tagList;
    }


    @Override
    public int getCount() {
        return tagList.size();
    }

    @Override
    public Object getItem(int i) {
        return tagList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void makeSelection(int position) {
        selectedPosition = position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gridview_item_selection_textview, viewGroup, false);
            holder.textview =  view.findViewById(R.id.tv_course_list_tag);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        if (tagList.get(i).length() > 0) {
            holder.textview.setText(tagList.get(i));
        }

        if(selectedPosition==i){
            holder.textview.setBackgroundResource(R.drawable.bg_course_list_selection2);
        }else{
            holder.textview.setBackgroundResource(R.drawable.bg_course_list_selection1);
        }
        return view;

    }

    public class ViewHolder {
        public TextView textview;

    }
}
