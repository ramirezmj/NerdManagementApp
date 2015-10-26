package edu.jmramirez.nerdmanagementapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends BaseAdapter {

    Context mContext;
    ArrayList <UserDataMock.UserData> mCoursesList = new ArrayList<>();

    public CoursesAdapter() {
    }

    public CoursesAdapter (Context context, List<UserDataMock.UserData> coursesList) {
        this.mContext = context;
        this.mCoursesList = (ArrayList<UserDataMock.UserData>) coursesList;
    }

    @Override
    public int getCount() {
        return this.mCoursesList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mCoursesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View elementView = convertView;

        if (elementView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            elementView = inflater.inflate(R.layout.list_item, parent, false);
        }


        ImageView courseIV = (ImageView) elementView.findViewById(R.id.courseIV);
        courseIV.setImageBitmap(this.mCoursesList.get(position).getPicture());
        TextView courseNameTV = (TextView) elementView.findViewById(R.id.courseNameTV);
        courseNameTV.setText(this.mCoursesList.get(position).getFullName());
        TextView courseCreditsTV = (TextView) elementView.findViewById(R.id.courseCreditsTV);
        courseCreditsTV.setText(String.valueOf(this.mCoursesList.get(position).getEnrolledCourses()));
        return elementView;
    }
}
