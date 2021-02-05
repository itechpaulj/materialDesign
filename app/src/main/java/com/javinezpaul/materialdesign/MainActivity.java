package com.javinezpaul.materialdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button loggedin;
    EditText editusername,editpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loggedin = (Button) findViewById(R.id.signin);
        editusername = (EditText) findViewById(R.id.user);
        editpassword = (EditText) findViewById(R.id.pass);

    }

    public void loginBtn(View view){
        String getuser = editusername.getText().toString();
        String getpass = editpassword.getText().toString();
        background bg = new background(this);
        bg.execute(getuser,getpass);
    }


}