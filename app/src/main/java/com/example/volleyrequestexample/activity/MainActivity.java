package com.example.volleyrequestexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import com.example.volleyrequestexample.R;
import com.example.volleyrequestexample.volley_handler.VolleySingleton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private static final String REQUEST_TAG = "string request first";

    private Button buttonGetReq;
    private Button buttonPostReq;
    private Button buttonDeleteReq;
    private Button buttonPutReq;
    private Button buttonImageListReq;

    private RequestQueue mRequestQueue;

    private StringRequest mStringRequest;

  //  private String BASE_URL = "http://www.mocky.io/v2/5c4042583500006f2eec3c01";
    private String BASE_URL = "http://httpbin.org/";

    private DiskBasedCache mCache;

    private com.android.volley.Network mNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGetReq = (Button) findViewById(R.id.button_get);
        buttonPostReq = (Button) findViewById(R.id.button_post);
        buttonDeleteReq = (Button) findViewById(R.id.button_delete);
        buttonPutReq = (Button) findViewById(R.id.button_put);
        buttonImageListReq = (Button) findViewById(R.id.button_image_list);

        buttonGetReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendGetRequestAndPrintResponse();
            }
        });

        buttonPostReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPostRequestAndPrintResponse();
            }
        });
        buttonDeleteReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDeleteRequestAndPrintResponse();
            }
        });
        buttonPutReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPutRequestAndPrintResponse();
            }
        });
        buttonImageListReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImageListActivity.class));
            }
        });
    }


    @Override
    protected void onStop() {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(REQUEST_TAG);
        }
        super.onStop();
    }

    private void sendGetRequestAndPrintResponse() {

        // mRequestQueue = Volley.newRequestQueue(this);

        // mCache = new DiskBasedCache(getCacheDir(),4*1024*1024);
        //  mNetwork = new BasicNetwork(new HurlStack());
        //  mRequestQueue = new RequestQueue(mCache,mNetwork);
        //  mRequestQueue.start();

        String url = "get?param1=hello";


        mRequestQueue = VolleySingleton.getmInstance(this.getApplicationContext()).getRequestQueue(this.getApplicationContext());

        mStringRequest = new StringRequest(Request.Method.GET, BASE_URL + url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, response.toString());
                Toast.makeText(MainActivity.this, "Response : " + response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, error.toString());
                Toast.makeText(MainActivity.this, "Error : " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mStringRequest.setTag(REQUEST_TAG);
        mRequestQueue.add(mStringRequest);
    }

    private void sendPostRequestAndPrintResponse() {

        String url = "post";

        mRequestQueue = VolleySingleton.getmInstance(this.getApplicationContext()).getRequestQueue(this.getApplicationContext());

        mStringRequest = new StringRequest(Request.Method.POST, BASE_URL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i(TAG, response.toString());
                        Toast.makeText(MainActivity.this, "Response : " + response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.i(TAG, error.toString());
                        Toast.makeText(MainActivity.this, "Error : " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Alif");
                params.put("domain", "http://itsalif.info");

                return params;
            }
        };
        mStringRequest.setTag(REQUEST_TAG);
        mRequestQueue.add(mStringRequest);
    }

    private void sendDeleteRequestAndPrintResponse(){

        String url = "delete";

        mRequestQueue = VolleySingleton.getmInstance(this.getApplicationContext()).getRequestQueue(this.getApplicationContext());

         mStringRequest = new StringRequest(Request.Method.DELETE, BASE_URL + url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i(TAG, response.toString());
                        Toast.makeText(MainActivity.this, "Response : " + response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, error.toString());
                        Toast.makeText(MainActivity.this, "Error : " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                }
        );
        mStringRequest.setTag(REQUEST_TAG);
        mRequestQueue.add(mStringRequest);
    }

    private void sendPutRequestAndPrintResponse(){
        String url = "put";

        mRequestQueue = VolleySingleton.getmInstance(this.getApplicationContext()).getRequestQueue(this.getApplicationContext());

        mStringRequest = new StringRequest(Request.Method.PUT, BASE_URL + url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i(TAG, response.toString());
                        Toast.makeText(MainActivity.this, "Response : " + response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.i(TAG, error.toString());
                        Toast.makeText(MainActivity.this, "Error : " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String> ();
                params.put("name", "Alif");
                params.put("domain", "http://itsalif.info");

                return params;
            }

        };
        mStringRequest.setTag(REQUEST_TAG);
        mRequestQueue.add(mStringRequest);
    }

}
