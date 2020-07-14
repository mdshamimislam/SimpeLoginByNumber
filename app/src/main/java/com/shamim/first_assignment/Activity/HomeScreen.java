package com.shamim.first_assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shamim.first_assignment.Broadcast.Internet;
import com.shamim.first_assignment.R;

public class HomeScreen extends AppCompatActivity {
TextView show;
Button number;
 String TAG="HomeScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        show= findViewById(R.id.show);
        number= findViewById(R.id.number);

    }

    public void forcontact(View view) {

        StringBuilder contactBuilder = new StringBuilder("");

        String [] projection={
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
        };
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,projection,
                null,null,null);

        if (cursor !=null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                contactBuilder.append(cursor.getString(0)+"\n");
                Log.d(TAG,"Cusor"+"  "+cursor);
            }


        }
        show.setText(contactBuilder.toString());

    }

    public void lifecycle(View view) {


        Intent intent= new Intent(HomeScreen.this,Lifecycle_page.class);
        startActivity(intent);
        Log.d(TAG,"Life"+"     "+view);
    }
}