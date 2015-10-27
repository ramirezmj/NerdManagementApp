package edu.jmramirez.nerdmanagementapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import edu.jmramirez.nerdmanagementapp.Adapters.UsersAdapter;
import edu.jmramirez.nerdmanagementapp.Model.UserDataMock;
import edu.jmramirez.nerdmanagementapp.R;

public class NerdsListActivity extends AppCompatActivity {

    public final static String TAG = "NerdsListActivity";
    public final static String INTENT = "POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nerds_list);

        UserDataMock users = UserDataMock.newInstance(NerdsListActivity.this);

        List<UserDataMock.UserData> userList = users.getUserList();
        UsersAdapter adapter = new UsersAdapter(this, userList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.valueOf(position));

                Intent intent = new Intent(NerdsListActivity.this, NerdsCoursesListActivity.class);
                intent.putExtra(INTENT, position);
                startActivity(intent);
            }
        });

    }
}
