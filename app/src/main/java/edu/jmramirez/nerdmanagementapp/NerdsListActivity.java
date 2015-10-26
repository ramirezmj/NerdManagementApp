package edu.jmramirez.nerdmanagementapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class NerdsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nerds_list);

        UserDataMock users = UserDataMock.newInstance(NerdsListActivity.this);

        List<UserDataMock.UserData> userList = users.getUserList();
        CoursesAdapter adapter = new CoursesAdapter(this, userList);


        ListView listView = (ListView) findViewById(R.id.courses);
        listView.setAdapter(adapter);

    }
}
