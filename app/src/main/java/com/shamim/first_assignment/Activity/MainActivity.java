package com.shamim.first_assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shamim.first_assignment.Broadcast.Internet;
import com.shamim.first_assignment.R;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";
    TextView phone, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone =findViewById(R.id.phone);
       password =findViewById(R.id.password);
       login=findViewById(R.id.login);
       Log.d(TAG,"onCrate");
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {

        Log.d(TAG,"onResume");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Phone = phone.getText().toString();
                String Password = password.getText().toString();
                Log.d(TAG,"Login Button");


                if (Phone.isEmpty()  ){
                    Toast.makeText(MainActivity.this, "Phone Number Empty", Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"Phone Number Null"+" "+Phone);
                }

                else  if(Password.isEmpty()){
                    Toast.makeText(MainActivity.this, "password Empty", Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"Password Null"+" "+Password);
                }

                else if(Phone.charAt(0)!='+'|| Phone.charAt(1)!='8'|| Phone.charAt(2)!='8' || Phone.charAt(3)!='0'){
                    Log.d(TAG,"First Position Number is"+" "+Phone);
                    Toast.makeText(MainActivity.this, "Must Be First 4 Number=+880", Toast.LENGTH_LONG).show();
                }

                else if(Phone.charAt(4) != '1' ){
                    Toast.makeText(MainActivity.this, "5th Position Number is = 1 ", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"5th Position Number is"+" "+Phone);
                }
                else if(Phone.charAt(5) != '9' && Phone.charAt(5) != '8' &&
                        Phone.charAt(5) != '7' && Phone.charAt(5) != '3' &&
                        Phone.charAt(5) != '4' && Phone.charAt(5) != '5'
                        && Phone.charAt(5) != '6'){
                    Toast.makeText(MainActivity.this, "6th Position Number is =7,9,3,5 ETC ", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"6th Position Number is"+" "+Phone);

                }

                else if (Phone.length()!=14){
                    Toast.makeText(MainActivity.this, "Number Must be 15", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Phone Number Not =14"+" "+Phone);
                }

                else if (Password.length() < 5){
                    Toast.makeText(MainActivity.this, "Password Must be 5 grater than", Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Password Length Not Grater then 5"+" "+Password);
                }
                else {
                    Intent intent= new Intent(MainActivity.this,HomeScreen.class);
                    startActivity(intent);
                    Log.d(TAG,"Phone"+" "+Phone+"   "+"Password"+"  "+Password);

                    //Broadcast Receiver
                    Internet internet = new Internet();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    registerReceiver(internet, intentFilter);
                }


            }

        });



        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

}