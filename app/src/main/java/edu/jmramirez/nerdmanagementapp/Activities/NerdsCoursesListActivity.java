package edu.jmramirez.nerdmanagementapp.Activities;


import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatDialogFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.jmramirez.nerdmanagementapp.Adapters.CoursesAdapter;
import edu.jmramirez.nerdmanagementapp.Model.UserDataMock;
import edu.jmramirez.nerdmanagementapp.R;

public class NerdsCoursesListActivity extends AppCompatActivity {

    public final static String TAG = "NerdsCoursesList";
    public final static String INTENT = "POSITION";
    private UserDataMock courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nerds_list);

        Integer position = getIntent().getIntExtra(INTENT, 0);

        courses = UserDataMock.newInstance(NerdsCoursesListActivity.this);

        List<UserDataMock.CourseData> coursesList = courses.getCoursesForUser(position);

        CoursesAdapter adapter = new CoursesAdapter(this, coursesList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
