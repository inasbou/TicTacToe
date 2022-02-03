package com.in.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addplayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplayers);

        final EditText firstply=findViewById(R.id.firstply);
        final EditText secondply=findViewById(R.id.secondply);
        final Button startgame=findViewById(R.id.startbtn)  ;

       startgame.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               final String getfirstply = firstply.getText().toString();
               final String getsecondply = secondply.getText().toString();
               if (getfirstply.isEmpty() || getsecondply.isEmpty()) {
                   Toast.makeText(Addplayers.this, "please enter players names", Toast.LENGTH_SHORT).show();


               } else {
                   Intent intent = new Intent(Addplayers.this, MainActivity.class);
                   intent.putExtra("player one", getfirstply);
                   intent.putExtra("player two", getsecondply);
                   startActivity(intent);

               }
           }
           });




}}