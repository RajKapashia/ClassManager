package com.example.raj.attendencerecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {
Button b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_design_login_form);
        b11 = (Button) findViewById(R.id.button11);

        b11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPage.this, Loginf.class);
                startActivity(i);

            }
        });

    }
}