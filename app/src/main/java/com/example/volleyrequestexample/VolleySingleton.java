package com.example.volleyrequestexample;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton mInstance;

    private RequestQueue mRequestQueue;

    public static VolleySingleton getmInstance(Context context){

        if (mInstance == null){

            mInstance = new VolleySingleton(context);

        }

        return mInstance;

    }

    private VolleySingleton(Context context){

        mRequestQueue = getRequestQueue(context);
    }

    public RequestQueue getRequestQueue(Context context){

        if (mRequestQueue == null){

            mRequestQueue = Volley.newRequestQueue(context);

        }

        return mRequestQueue;
    }
}
