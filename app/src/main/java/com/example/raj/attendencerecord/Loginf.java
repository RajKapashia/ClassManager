package com.example.raj.attendencerecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class Loginf extends AppCompatActivity {
    ImageButton h, s, l, b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginf);
        String[] itemname5 = {
                "Teacher", "Student"


        };
        tv=(TextView)findViewById(R.id.textView);
        Integer[] imgid5 = {
                R.drawable.teacher,
                R.drawable.stud,

        };


        CustomListAdapter adapter = new CustomListAdapter(this, itemname5, imgid5);
        ListView list = (ListView) findViewById(R.id.lv1);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                switch(position) {
                    case 0:
                        Intent intent4 = new Intent(Loginf.this, AppBase.class);
                        startActivity(intent4);
                        break;
                    case 1:
                        Intent intent5 = new Intent(Loginf.this, AppBase.class);
                        startActivity(intent5);
                        break;

                }

            }
        });
    }


}