package edu.jmramirez.nerdmanagementapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.jmramirez.nerdmanagementapp.Model.UserDataMock;
import edu.jmramirez.nerdmanagementapp.R;

public class UsersAdapter extends BaseAdapter {

    Context mContext;
    List<UserDataMock.UserData> mUsersList = new ArrayList<>();

    public UsersAdapter() {
    }

    public UsersAdapter (Context context, List<UserDataMock.UserData> usersList) {
        this.mContext = context;
        this.mUsersList = usersList;
    }

    @Override
    public int getCount() {
        return this.mUsersList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mUsersList.get(position);
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

            elementView = inflater.inflate(R.layout.list_user, parent, false);
        }

        ImageView courseIV = (ImageView) elementView.findViewById(R.id.courseIV);
        courseIV.setImageBitmap(this.mUsersList.get(position).getPicture());

        TextView courseNameTV = (TextView) elementView.findViewById(R.id.courseNameTV);
        courseNameTV.setText(this.mUsersList.get(position).getFullName());

        TextView courseCreditsTV = (TextView) elementView.findViewById(R.id.courseCreditsTV);

        Integer numberOfCoursesEnrolled = this.mUsersList.get(position).getEnrolledCourses().size();

        if (numberOfCoursesEnrolled == 1) {
            courseCreditsTV.setText("Signed in " + String.valueOf(numberOfCoursesEnrolled) + " course");
        } else if (numberOfCoursesEnrolled == 0) {
            courseCreditsTV.setText("This user is not enrolled in any course");
        } else {
            courseCreditsTV.setText("Signed in " + String.valueOf(numberOfCoursesEnrolled) + " courses");
        }
        return elementView;
    }
}
