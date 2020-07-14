package com.shamim.first_assignment.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Internet extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        if (checkInternet(context)) {
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
        }

    }

    boolean checkInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();

    }

}
