package com.codepath.anuscorps23.onlycoin.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by anuscorps23 on 7/12/15.
 */
public class NetworkConnectivity {

    public static Boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        connectivityManager = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
