package com.example.raj.attendencerecord;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit_Student extends AppCompatActivity {
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__student);

        Button loadButton = (Button)findViewById(R.id.buttonSAVE);
        assert loadButton != null;
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText adm = (EditText)findViewById(R.id.register);
                String qu = "SELECT * FROM STUDENT WHERE regno = '" + adm.getText().toString().toUpperCase() + "'";
                Cursor cr = AppBase.handler.execQuery(qu);
                if(cr==null||cr.getCount()==0)
                {
                    Toast.makeText(getBaseContext(),"No Such Student",Toast.LENGTH_SHORT).show();
                }else
                {
                    cr.moveToFirst();
                    try {
                        EditText name = (EditText) findViewById(R.id.edit_name);
                        EditText roll = (EditText) findViewById(R.id.roll);
                        EditText contact = (EditText) findViewById(R.id.contact);
                        assert name != null;
                        name.setText(cr.getString(0));
                        assert roll != null;
                        roll.setText(cr.getString(4));
                        assert contact != null;
                        contact.setText(cr.getString(3));
                    }catch (Exception e)
                    {}
                }
            }
        });


        Button saveEdit = (Button)findViewById(R.id.buttonSAVE);
        assert saveEdit != null;
        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.edit_name);
                EditText roll = (EditText) findViewById(R.id.roll);
                EditText contact = (EditText) findViewById(R.id.contact);
                EditText adm = (EditText)findViewById(R.id.register);

                String qu = "UPDATE STUDENT SET name = '" + name.getText().toString() + "' , " +
                        " roll = " + roll.getText().toString() + " , contact = '" + contact.getText().toString() + "' " +
                        "WHERE regno = '" + adm.getText().toString().toUpperCase() + "'";
                Log.d("Edit_Student", qu);
                if(AppBase.handler.execAction(qu))
                {
                    Toast.makeText(getBaseContext(),"Edit Saved", Toast.LENGTH_SHORT).show();
                    activity.finish();

                }else
                    Toast.makeText(getBaseContext(),"Error Occured", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

