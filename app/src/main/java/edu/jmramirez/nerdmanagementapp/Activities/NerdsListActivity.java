package edu.jmramirez.nerdmanagementapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import edu.jmramirez.nerdmanagementapp.Adapters.UsersAdapter;
import edu.jmramirez.nerdmanagementapp.Model.UserDataMock;
import edu.jmramirez.nerdmanagementapp.R;

public class NerdsListActivity extends AppCompatActivity {

    public final static String TAG = "NerdsListActivity";
    public final static String INTENT = "POSITION";
    UserDataMock users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nerds_list);

        users = UserDataMock.newInstance(NerdsListActivity.this);

        List<UserDataMock.UserData> userList = users.getUserList();
        UsersAdapter adapter = new UsersAdapter(this, userList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Integer numberOfCoursesEnrolled = users.getCoursesForUser(position).size();

                if (numberOfCoursesEnrolled > 0) {
                    Intent intent = new Intent(NerdsListActivity.this, NerdsCoursesListActivity.class);
                    intent.putExtra(INTENT, position);
                    startActivity(intent);
                } else {
                    Toast.makeText(NerdsListActivity.this, "This user is not enrolled in any course", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                Intent intent = new Intent(NerdsListActivity.this, AppSettingsActivity.class);
                startActivity(intent);
                return true;
        }
    }
}
