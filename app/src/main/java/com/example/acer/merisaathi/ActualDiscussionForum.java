package com.example.acer.merisaathi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ActualDiscussionForum extends AppCompatActivity {
    final HashMap<String, String> postParams = new HashMap<>();
    String url="http://192.168.1.133:8080/api/discussions";
    Context mContext;
    TextView[]tv2=new TextView[6];
    TextView[]etv2=new TextView[6];
    EditText et12;
    TextView[]tv=new TextView[6];
    TextView[]etv=new TextView[6];
    EditText et1;
    int i,j;
    Button b1,b12;
    String email;
    String fname,lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_discussion_forum);
        mContext = getApplicationContext();
        tv[0]=(TextView)findViewById(R.id.actual_discussion_forumtv1);
        tv[1]=(TextView)findViewById(R.id.actual_discussion_forumtv2);
        tv[2]=(TextView)findViewById(R.id.actual_discussion_forumtv3);
        tv[3]=(TextView)findViewById(R.id.actual_discussion_forumtv4);
        tv[4]=(TextView)findViewById(R.id.actual_discussion_forumtv5);
        tv[5]=(TextView)findViewById(R.id.actual_discussion_forumtv6);
        etv[0]=(TextView)findViewById(R.id.actual_discussion_forum_email1);
        etv[1]=(TextView)findViewById(R.id.actual_discussion_forum_email2);
        etv[2]=(TextView)findViewById(R.id.actual_discussion_forum_email3);
        etv[3]=(TextView)findViewById(R.id.actual_discussion_forum_email4);
        etv[4]=(TextView)findViewById(R.id.actual_discussion_forum_email5);
        etv[5]=(TextView)findViewById(R.id.actual_discussion_forum_email6);
        et1=(EditText)findViewById(R.id.actual_discussion_forumet1);
        b1=(Button)findViewById(R.id.actual_discussion_forumb1);

        SharedPreferences formPreference = getSharedPreferences("form",MODE_PRIVATE);
        fname=formPreference.getString("firstname","");
        lname=formPreference.getString("lastname","");


        tv2[0]=(TextView)findViewById(R.id.actual_discussion_forumtv12);
        tv2[1]=(TextView)findViewById(R.id.actual_discussion_forumtv22);
        tv2[2]=(TextView)findViewById(R.id.actual_discussion_forumtv32);
        tv2[3]=(TextView)findViewById(R.id.actual_discussion_forumtv42);
        tv2[4]=(TextView)findViewById(R.id.actual_discussion_forumtv52);
        tv2[5]=(TextView)findViewById(R.id.actual_discussion_forumtv62);
        etv2[0]=(TextView)findViewById(R.id.actual_discussion_forum_email12);
        etv2[1]=(TextView)findViewById(R.id.actual_discussion_forum_email22);
        etv2[2]=(TextView)findViewById(R.id.actual_discussion_forum_email32);
        etv2[3]=(TextView)findViewById(R.id.actual_discussion_forum_email42);
        etv2[4]=(TextView)findViewById(R.id.actual_discussion_forum_email52);
        etv2[5]=(TextView)findViewById(R.id.actual_discussion_forum_email62);
        et12=(EditText)findViewById(R.id.actual_discussion_forumet12);
        b12=(Button)findViewById(R.id.actual_discussion_forumb12);


        String readfilename = "email.txt";
        FileOperations fop = new FileOperations();
        email = fop.read(readfilename);
        if(email!=null){
//            Toast.makeText(ActualDiscussionForum.this,email, Toast.LENGTH_SHORT).show();
            //  Intent intent=new Intent(NavigationDrawer.this,NavigationDrawer.class);
            //  startActivity(intent);
        }
        final RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //  Do something with response
                        //  tv1.setText(response.toString());
                        //  Toast.makeText(MainActivity.this,"succed",Toast.LENGTH_SHORT).show();

                        //  Process the JSON
                        try{
                            // Loop through the array elements
                            for( i=0;i<2;i++){
                                // Get current json object
                                //<response.length()
                                JSONObject discussion = response.getJSONObject(i);

                                // Get the current student (json object) data
//                                String firstName = student.getString("firstname");
//                                String lastName = student.getString("lastname");
//                                String age = student.getString("age");
                                String msg=discussion.getString("message");
                                String email=discussion.getString("email");
                                etv[i].setVisibility(View.VISIBLE);
                                tv[i].setVisibility(View.VISIBLE);
                                etv[i].setText(email);
                                tv[i].setText(msg);

                                // Display the formatted json data in text view
//                                mTextView.append(firstName +" " + lastName +"\nAge : " + age);
//                                mTextView.append("\n\n");

                            }
                            for(;i<response.length();i++){
                                JSONObject discussion = response.getJSONObject(i);

                                // Get the current student (json object) data
//                                String firstName = student.getString("firstname");
//                                String lastName = student.getString("lastname");
//                                String age = student.getString("age");
                                String msg=discussion.getString("message");
                                String email=discussion.getString("email");
                                etv2[i-2].setVisibility(View.VISIBLE);
                                tv2[i-2].setVisibility(View.VISIBLE);
                                etv2[i-2].setText(email);
                                tv2[i-2].setText(msg);


                            }

                            //  mTextView.setText(response.length());

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                        //  mTextView.setText(response.length());

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred


                    }
                }
        );
        requestQueue.add(jsonArrayRequest);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postParams.put("email", fname+" "+lname+"\n"+email);
                postParams.put("message",et1.getText().toString());

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(postParams),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    VolleyLog.v("Response:%s %s", response.toString(4));
                                    Toast.makeText(ActualDiscussionForum.this,response.toString(),Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });
                etv[i].setVisibility(View.VISIBLE);
                tv[i].setVisibility(View.VISIBLE);
                etv[i].setText(email);
                tv[i].setText(et1.getText());
                requestQueue.add(req);
                et1.setText("");

                //  ApplicationController.getInstance().addToRequestQueue(req);
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postParams.put("email", email);
                postParams.put("message",et12.getText().toString());

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(postParams),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    VolleyLog.v("Response:%s %s", response.toString(4));
                                    Toast.makeText(ActualDiscussionForum.this,response.toString(),Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });
                etv2[i].setVisibility(View.VISIBLE);
                tv2[i].setVisibility(View.VISIBLE);
                etv2[i].setText(email);
                tv2[i].setText(et12.getText());
                requestQueue.add(req);
                et12.setText("");

                //  ApplicationController.getInstance().addToRequestQueue(req);
            }
        });
    }

}

