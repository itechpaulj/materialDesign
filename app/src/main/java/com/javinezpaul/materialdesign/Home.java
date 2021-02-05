package com.javinezpaul.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;




public class Home extends AppCompatActivity {
    String username, password;
    TextView settextusername, settextpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Intent intent = getIntent();
        username = intent.getExtras().getString("username");
        password = intent.getExtras().getString("password");

        settextusername =  (TextView) findViewById(R.id.getusername);
        settextpassword =  (TextView) findViewById(R.id.getpassword);

        settextusername.setText(username);
        settextpassword.setText(password);
    }
}
