package com.example.volleyrequestexample.volley_handler;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.volleyrequestexample.LruBitmapCache;

public class VolleySingleton {

    private static VolleySingleton mInstance;

    private RequestQueue mRequestQueue;

    private ImageLoader mImageLoader;

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

    public ImageLoader getImageLoader(Context context) {
        getRequestQueue(context);
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return mImageLoader;
    }
}
