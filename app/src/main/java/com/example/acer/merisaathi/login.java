package com.example.acer.merisaathi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import java.io.File;
import java.io.IOException;

public class login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private SignInButton signInButton;
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private int SIGN_IN = 30;
    private TextView tv;
    private ImageView iv;
    private AQuery aQuery;
    private Button btn;

    String email;


    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;

    private CoordinatorLayout coordinatorlayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static final String LOG_TAG = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        coordinatorlayout= (CoordinatorLayout) findViewById(R.id.coordinator);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Log.d(LOG_TAG, "OnCreate");




//        Button demo=(Button)findViewById(R.id.demo);
//        demo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(login.this,Form.class);
//                startActivity(intent);
//            }
//        });


        String readfilename = "email.txt";
        FileOperations fop = new FileOperations();
        String text = fop.read(readfilename);
        if(text!=null){
//            Toast.makeText(login.this,text, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(login.this,NavigationDrawer.class);
            //  startActivity(intent);
        }


//        Button be=(Button) findViewById(R.id.loginButton);
//        be.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(login.this,Form.class);
//                startActivity(intent);
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        //    EditText et = (EditText) findViewById(R.id.nameText);
        //    String entry = et.getText().toString();

//                Button button = (Button) findViewById(R.id.submitButton);
//                button.setOnClickListener(new


        //  Snackbar.make(view, "You entered "+ entry, Snackbar.LENGTH_LONG)
        //          .setAction("Action", null).show();
//            }
//        });

//        StringBuilder buil = new StringBuilder();
//
//        for (int i=0;i<10;i++)
//        buil.append(getString(R.string.longtext + "\n\n\n\n"));
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addApi(Plus.API)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,Form.class);

                startActivity(intent);
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, SIGN_IN);



            }
        });

        //  tv = (TextView) findViewById(R.id.text);
        //  iv = (ImageView) findViewById(R.id.iv);
        //  btn = (Button) findViewById(R.id.logOutButton);
        aQuery = new AQuery(this);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//            }
//        });


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
          //  Toast.makeText(login.this, "Your orientation is Portrait", Toast.LENGTH_SHORT).show();
        }else{
          //  Toast.makeText(login.this, "Your orientation is Landscape", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            Toast.makeText(MainActivity.this, "You selected the Settings menu", Toast.LENGTH_SHORT).show();
//            return true;

            Snackbar.make(coordinatorlayout, "You selected the settings", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "OnStart");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "OnPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "OnStop");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "OnResume");
    }

    public void buttonClickHandler(View view) {
//        EditText et = (EditText) findViewById(R.id.nameText);
//        String entry = et.getText().toString();
//        Snackbar.make(view, "You entered "+ entry + " and clicked button", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If signin
        if (requestCode == SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Calling a new function to handle signin
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        //If the login succeed
        if (result.isSuccess()) {
            //Getting google account
            final GoogleSignInAccount acct = result.getSignInAccount();

            //Displaying name and email
            String name = acct.getDisplayName();
            final String mail = acct.getEmail();
            email=acct.getEmail().toString();

            // String photourl = acct.getPhotoUrl().toString();

            final String givenname="",familyname="",displayname="",birthday="";

            Plus.PeopleApi.load(mGoogleApiClient, acct.getId()).setResultCallback(new ResultCallback<People.LoadPeopleResult>() {
                @Override
                public void onResult(@NonNull People.LoadPeopleResult loadPeopleResult) {
                    Person person = loadPeopleResult.getPersonBuffer().get(0);

                    Log.d("GivenName ", person.getName().getGivenName());
                    Log.d("FamilyName ",person.getName().getFamilyName());
                    Log.d("DisplayName ",person.getDisplayName());
                    Log.d("gender ", String.valueOf(person.getGender())); //0 = male 1 = female
                    String gender="";
                    if(person.getGender() == 0){
                        gender = "Male";
                    }else {
                        gender = "Female";
                    }

                    if(person.hasBirthday()){
                        tv.setText(person.getName().getGivenName()+" \n"+person.getName().getFamilyName()+" \n"+gender+"\n"+person.getBirthday());
                    }else {
                        tv.setText(person.getName().getGivenName()+" \n"+person.getName().getFamilyName()+" \n"+gender);

                    }
                    aQuery.id(iv).image(acct.getPhotoUrl().toString());
                    Log.d("Uriddd",acct.getPhotoUrl().toString());
                  /*   Log.d(TAG,"CurrentLocation "+person.getCurrentLocation());
                    Log.d(TAG,"AboutMe "+person.getAboutMe());*/
                    // Log.d("Birthday ",person.getBirthday());
                    // Log.d(TAG,"Image "+person.getImage());
                }
            });
            FileOperations fop = new FileOperations();
            fop.write("email.txt", email);
            if(fop.write("email.txt", email)){
            //    Toast.makeText(getApplicationContext(), "email"+".txt created", Toast.LENGTH_SHORT).show();
            }else{
              //  Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();

            }
            Intent intent=new Intent(login.this,Form.class);

            startActivity(intent);
        } else {
            //If login fails
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }


}
