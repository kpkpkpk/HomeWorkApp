package com.k.homeworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.k.homeworkapp.user.User;

public class MainActivity extends AppCompatActivity {
    private EditText loginInput, passPut;
    private Button enterButton;
    private TextView checkView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginInput=(EditText) findViewById(R.id.loginInput);
        passPut=(EditText) findViewById(R.id.passPut);
        enterButton=(Button) findViewById(R.id.enterButton);
        checkView=(TextView) findViewById(R.id.checkView);
        //заранее подготовленный профиль для проверки
        final User administrator=new User("admin","admin");
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.enterButton:
                        if(User.isExist(String.valueOf(loginInput.getText()),String.valueOf(passPut.getText()))){
                            checkView.setTextColor(Color.GREEN);
                            checkView.setText(R.string.result_ok);
                        }else{
                            checkView.setTextColor(Color.RED);
                            checkView.setText(R.string.result_wrong);
                        }
                        break;
                }
            }
        };
        enterButton.setOnClickListener(listener);
    }
}