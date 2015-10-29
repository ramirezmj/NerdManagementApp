package edu.jmramirez.nerdmanagementapp.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import edu.jmramirez.nerdmanagementapp.R;
import edu.jmramirez.nerdmanagementapp.Model.UserDataMock;

public class CoursesAdapter extends BaseAdapter {

    Context mContext;
    boolean credits, days, hours;
    List <UserDataMock.CourseData> mCoursesList = new ArrayList<>();
    TextView courseNameTV , courseNumberOfCreditsTV, courseDaysOfWeekTV, courseHoursTV;
    String daysCheckBox = "days_option";
    String hoursCheckBox = "hour_option";
    String creditsCheckBox = "credits_option";

    public CoursesAdapter() {
    }

    public CoursesAdapter (Context context, List<UserDataMock.CourseData> coursesList) {
        this.mContext = context;
        this.mCoursesList = coursesList;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        credits = sharedPreferences.getBoolean(creditsCheckBox, true);
        days = sharedPreferences.getBoolean(daysCheckBox ,true);
        hours = sharedPreferences.getBoolean(hoursCheckBox ,true);

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

            elementView = inflater.inflate(R.layout.list_course, parent, false);
        }

        /* Mandatory */
        courseNameTV = (TextView) elementView.findViewById(R.id.courseNameTV);
        courseNameTV.setText(this.mCoursesList.get(position).getTitle());

        /* Optional */
        courseDaysOfWeekTV = (TextView) elementView.findViewById(R.id.courseDaysOfWeekTV);
        courseDaysOfWeekTV.setText(this.mCoursesList.get(position).getDaysOfWeek());

        courseNumberOfCreditsTV = (TextView) elementView.findViewById(R.id.courseNumberOfCreditsTV);
        courseNumberOfCreditsTV.setText(String.valueOf(this.mCoursesList.get(position).getNumberOfCredits() + " Credits"));

        courseHoursTV = (TextView) elementView.findViewById(R.id.courseHoursTV);
        courseHoursTV.setText(this.mCoursesList.get(position).getStartsAt() + " h");

        toggleVisibility();

        return elementView;
    }

    private void toggleVisibility() {
        if (!days) {
            courseDaysOfWeekTV.setVisibility(View.INVISIBLE);
        }
        if (!credits) {
            courseNumberOfCreditsTV.setVisibility(View.INVISIBLE);
        }
        if(!hours) {
            courseHoursTV.setVisibility(View.INVISIBLE);
        }
    }
}
