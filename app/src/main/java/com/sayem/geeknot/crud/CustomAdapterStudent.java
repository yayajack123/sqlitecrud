package com.sayem.geeknot.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapterStudent extends BaseAdapter {

    private Context context;
    private ArrayList<StudentsModel> studentsModelArrayList;

    public CustomAdapterStudent(Context context, ArrayList<StudentsModel> studentsModelArrayList) {

        this.context = context;
        this.studentsModelArrayList = studentsModelArrayList;
    }


    @Override
    public int getCount() {
        return studentsModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentsModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model_student, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.teachers_name);
            holder.tvnim = (TextView) convertView.findViewById(R.id.teachers_course);
            holder.tvemail = (TextView) convertView.findViewById(R.id.teachers_email);
            holder.tvphone = (TextView) convertView.findViewById(R.id.teachers_phone);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText("Name: "+studentsModelArrayList.get(position).getName());
        holder.tvnim.setText("Nim: "+studentsModelArrayList.get(position).getNim());
        holder.tvemail.setText("Email: "+studentsModelArrayList.get(position).getEmail());
        holder.tvphone.setText(""+studentsModelArrayList.get(position).getPhone());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvnim, tvemail, tvphone;
    }

}