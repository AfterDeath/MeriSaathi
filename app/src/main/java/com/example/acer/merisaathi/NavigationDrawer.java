package com.example.acer.merisaathi;

import android.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener  {

    DrawerLayout drawer;
    private static final String TAG = "NavigationDrawer";
    private TextView mLatitudeTextView;
    private TextView mLongitudeTextView;
    private GoogleApiClient mGoogleApiClient;
    private Location mLocation;
    private LocationManager mLocationManager;

    private LocationRequest mLocationRequest;
    private com.google.android.gms.location.LocationListener listener;
    private long UPDATE_INTERVAL = 2 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */

    private LocationManager locationManager;
    String[] numbers=new String[2];
    int i=0;

    double lat,lang;
    String email;
    TextView emailText;
    String url; ///global bana ktha xa ahha


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences formPreference = getSharedPreferences("form",MODE_PRIVATE);

        String readfilename = "email.txt";

        FileOperations fop = new FileOperations();
        email = fop.read(readfilename);
        if(email!=null){
         //   Toast.makeText(NavigationDrawer.this,email, Toast.LENGTH_SHORT).show();
            //  Intent intent=new Intent(NavigationDrawer.this,NavigationDrawer.class);
            //  startActivity(intent);
        }

        String fname=formPreference.getString("firstname","");
        String contacts1=formPreference.getString("contacts1","");
        String contacts2=formPreference.getString("contacts2","");
        String contacts3=formPreference.getString("contacts3","");
        String contacts4=formPreference.getString("contacts4","");
        String contacts5=formPreference.getString("contacts5","");
        final String[] num1 = contacts1.split("\\:"); // escape .
        final String[] num2 = contacts2.split("\\:"); // escape .
        final String[] num3 = contacts3.split("\\:"); // escape .
        final String[] num4 = contacts4.split("\\:"); // escape .
        final String[] num5 = contacts5.split("\\:"); // escape .

        Pattern pattern1 = Pattern.compile(":");
        Pattern pattern2 = Pattern.compile(":");
        Pattern pattern3 = Pattern.compile(":");
        Pattern pattern4 = Pattern.compile(":");
        Pattern pattern5 = Pattern.compile(":");
        if(!contacts1.isEmpty()){
            Matcher matcher1 = pattern1.matcher(contacts1);
            if (matcher1.find()) {
                num1[0] = contacts1.substring(0, matcher1.start());
                numbers[i]=num1[0];
                i++;

            }
        }
        else{
            num1[0]="";
        }
        if(!contacts2.isEmpty()){
            Matcher matcher2 = pattern2.matcher(contacts2);
            if (matcher2.find()) {
                num2[0] = contacts2.substring(0, matcher2.start());
                numbers[i]=num2[0];
                i++;
            }
        }
        else {
            num2[0]="";
        }
        if(!contacts3.isEmpty()){
            Matcher matcher3 = pattern3.matcher(contacts3);
            if (matcher3.find()) {
                num3[0] = contacts3.substring(0, matcher3.start());
                numbers[i]=num3[0];
                i++;
            }
        }else {
            num3[0]="";
        }
        if(!contacts4.isEmpty()){
            Matcher matcher4 = pattern4.matcher(contacts4);
            if (matcher4.find()) {
                num4[0] = contacts4.substring(0, matcher4.start());
                numbers[i]=num4[0];
                i++;
            }
        }else {
            num4[0]="";
        }
        if(!contacts5.isEmpty()){
            Matcher matcher5 = pattern5.matcher(contacts5);
            if (matcher5.find()) {
                num5[0] = contacts5.substring(0, matcher5.start());
                numbers[i]=num5[0];
                i++;
            }
        }
        else{
            num5[0]="";
        }

        FloatingActionButton b1=(FloatingActionButton) findViewById(R.id.Navigation_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent=new Intent(NavigationDrawer.this,Emergency_Button.class);
               // startActivity(intent);
                SmsManager smsManager = SmsManager.getDefault();


                for(int i=0;i<2;i++) {

                     smsManager.sendTextMessage(numbers[i], null, "Help! I am in need. See my location at "+ url, null, null);
                }

                Intent intent=new Intent(NavigationDrawer.this,sent.class);
                startActivity(intent);

//                Toast.makeText(NavigationDrawer.this, url, Toast.LENGTH_LONG).show();
//                SmsManager smsManager = SmsManager.getDefault();
//                smsManager.sendTextMessage("9843538576", null, "Your Friend is in need. See her location at "+ url, null, null);
            }
        });
        FloatingActionButton b2=(FloatingActionButton) findViewById(R.id.Navigation_b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NavigationDrawer.this,Tips.class);
                startActivity(intent);
            }
        });
        FloatingActionButton b3=(FloatingActionButton) findViewById(R.id.Navigation_b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NavigationDrawer.this,ActualDiscussionForum.class);
                startActivity(intent);
            }
        });
        FloatingActionButton b4=(FloatingActionButton) findViewById(R.id.Navigation_b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NavigationDrawer.this,Quiz_preview.class);
                startActivity(intent);
            }
        });

        FloatingActionButton b5=(FloatingActionButton) findViewById(R.id.Navigation_b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NavigationDrawer.this,CycleTracker.class);
                startActivity(intent);
            }
        });
//        Button b6=(Button)findViewById(R.id.Navigation_b6);
//        b6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(NavigationDrawer.this,MapsActivity.class);
//                startActivity(intent);
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        emailText=(TextView)header.findViewById(R.id.NavigationDrawer_emailText);
        emailText.setText(email);


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        checkLocation(); //check whether location service is enable or not in your  phone //check whether location service is enable or not in your  phone

    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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
            Intent i = new Intent(NavigationDrawer.this, SettingsActivity.class);
            // drawer.closeDrawer(GravityCompat.START);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notifications) {
            Intent intent= new Intent(NavigationDrawer.this,Notifications.class);
            startActivity(intent);


            // Handle the camera action
        } else if (id == R.id.nav_seenearbypolicestation) {
            Intent intent= new Intent(NavigationDrawer.this,MapsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_reminders) {

        } else if (id == R.id.nav_rewards) {

        } else if (id == R.id.nav_logout) {
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                        //    Toast.makeText(NavigationDrawer.this, "Logout Successfully!", Toast.LENGTH_SHORT).show();
                        }
                    });
            String filename = "email.txt";
            FileOperations fop = new FileOperations();
            try {
                fop.delFile(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent =new Intent(NavigationDrawer.this,login.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        startLocationUpdates();

        mLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if(mLocation == null){
            startLocationUpdates();
        }
        if (mLocation != null) {

            // mLatitudeTextView.setText(String.valueOf(mLocation.getLatitude()));
            //mLongitudeTextView.setText(String.valueOf(mLocation.getLongitude()));
        } else {
         //   Toast.makeText(this, "Location not Detected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Connection Suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG, "Connection failed. Error: " + connectionResult.getErrorCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    protected void startLocationUpdates() {
        // Create the location request
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);
        // Request location updates
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationRequest, this);
        Log.d("reque", "--->>>>");
    }

    @Override
    public void onLocationChanged(Location location) {

        String msg = "Updated Location: " +
                Double.toString(location.getLatitude()) + "," +
                Double.toString(location.getLongitude());
       // mLatitudeTextView.setText(String.valueOf(location.getLatitude()));
      //  mLongitudeTextView.setText(String.valueOf(location.getLongitude() ));
      //  Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        // You can now create a LatLng Object for use with maps
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        lat=location.getLatitude();
        lang= location.getLongitude() ;
        url = "http://maps.google.com/maps?q="+ lat+ ","+lang ;
    }

    private boolean checkLocation() {
        if(!isLocationEnabled())
            showAlert();
        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                        "use this app")
                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                    }
                });
        dialog.show();
    }

    private boolean isLocationEnabled() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}



