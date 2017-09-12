package sarveshchavan777.inrerface2.HolderActivities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.example.games.basegameutils.BaseGameUtils;

import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterHome;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class MainActivity extends AppCompatActivity
        implements
        View.OnClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {


    FloatingActionButton fab;
    int numboftabs = 3;
    public int icon[] = {R.drawable.homecartoon, R.drawable.settingscartoon, R.drawable.achievementcartoon};


    //google variable
    private static int RC_SIGN_IN = 9001;
    //    private static int RC_YOUR_UNIQUE_ID = R.string.leaderboard_1;
    private boolean mResolvingConnectionFailure = false;

    private boolean mSignInClicked = false;
    boolean mExplicitSignOut = false;

    //boolean mInSignInFlow = false; // set to true when you're in the middle of the
    // sign in flow, to know you should not attempt
    // to connect in onStart()
    public static GoogleApiClient mGoogleApiClient;  // initialized in onCreate


    DemoHelperClass demoHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_activity_main);
        ViewPager mPager;
        SlidingTabLayout mTabs;

        //mGoogleApiClientMethod();

        // Create the Google Api Client with access to the Play Games services
        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .addApi(Drive.API).addScope(Drive.SCOPE_APPFOLDER)
                .setViewForPopups(findViewById(android.R.id.content))
                // add other APIs and scopes here as needed
                .build();



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            //  Toast.makeText(MainActivity.this,"this is one time only",Toast.LENGTH_LONG).show();
            mSignInClicked = true;
            if (mGoogleApiClient != null) {
                if (!mGoogleApiClient.isConnected()) {
                    mGoogleApiClient.connect();
                }
            }

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterHome(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mTabs.setCustomTabView(R.layout.ha_customtablayout, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.white));
        mTabs.setViewPager(mPager);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sign in
                try {
                    if (mGoogleApiClient != null && !getmGoogleApiClient().isConnected()) {
                        // start the asynchronous sign in flow
                        mSignInClicked = true;
                        mGoogleApiClient.connect();
                        if (mGoogleApiClient.isConnected()) {
                            fab.setImageResource(R.drawable.gsignout);
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }


                // sign out.
                try {
                    if (mGoogleApiClient != null && getmGoogleApiClient().isConnected()) {
                        mExplicitSignOut = true;
                        mSignInClicked = false;
                        Games.signOut(mGoogleApiClient);
                        mGoogleApiClient.disconnect();
                        // show sign-in button, hide the sign-out button
                        if (!mGoogleApiClient.isConnected()) {
                            fab.setImageResource(R.drawable.gsignin);
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }


            }
        });
        if(mGoogleApiClient!=null){
            if (mGoogleApiClient.isConnected()) {
                fab.setImageResource(R.drawable.gsignout);
            }
        }
        if(mGoogleApiClient!=null){
            if (!mGoogleApiClient.isConnected()) {
                fab.setImageResource(R.drawable.gsignin);
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mGoogleApiClient!=null){
            if (!mGoogleApiClient.isConnected()) {
                mGoogleApiClient.connect();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //   mGoogleApiClient.disconnect();
    }

    @Override
    public void onClick(View view) {
       /*if (view.getId() == R.id.sign_in_button) {
            // start the asynchronous sign in flow
            mSignInClicked = true;
            mGoogleApiClient.connect();
        }
        else if (view.getId() == R.id.sign_out_button) {
            // sign out.
            if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
                mExplicitSignOut = true;
                mSignInClicked=false;
                Games.signOut(mGoogleApiClient);
               mGoogleApiClient.disconnect();
                // show sign-in button, hide the sign-out button
               // findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
               // findViewById(R.id.sign_out_button).setVisibility(View.GONE);
           }
        }*/
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        //  show sign-out button, hide the sign-in button
        fab.setImageResource(R.drawable.gsignout);
        // (your code here: update UI, enable functionality that depends on sign in, etc)
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (mResolvingConnectionFailure) {
            // Already resolving
            return;
        }

        // If the sign in button was clicked or if auto sign-in is enabled,
        // launch the sign-in flow
        if (mSignInClicked /*|| mAutoStartSignInflow*/) {
            //  mAutoStartSignInflow = false;
            mSignInClicked = false;
            mResolvingConnectionFailure = true;

            // Attempt to resolve the connection failure using BaseGameUtils.
            // The R.string.signin_other_error value should reference a generic
            // error string in your strings.xml file, such as "There was
            // an issue with sign in, please try again later."
            if (!BaseGameUtils.resolveConnectionFailure(this,
                    mGoogleApiClient, connectionResult,
                    RC_SIGN_IN, R.string.signin_other_error)) {
                mResolvingConnectionFailure = false;
            }
        }
        // Put code here to display the sign-in button
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        //Toast.makeText(getApplicationContext(), "called", Toast.LENGTH_LONG).show();


        if (requestCode == RC_SIGN_IN) {
            mSignInClicked = false;
            mResolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                if(mGoogleApiClient!=null){
                    mGoogleApiClient.connect();
                }


            } else {
                // Bring up an error dialog to alert the user that sign-in
                // failed. The R.string.signin_failure should reference an error
                // string in your strings.xml file that tells the user they
                // could not be signed in, such as "Unable to sign in."
                BaseGameUtils.showActivityResultError(this,
                        requestCode, resultCode, R.string.signin_failure);
            }
        }

        if (/*requestCode == RC_YOUR_UNIQUE_ID*/
               /* &&*/ resultCode == GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED) {
       if(mGoogleApiClient!=null){
           MainActivity.mGoogleApiClient.disconnect();
           fab.setImageResource(R.drawable.gsignin);
       }

            // update your logic here (show login btn, hide logout btn).
            //Toast.makeText(getApplicationContext(), "result reconnect req", Toast.LENGTH_LONG).show();
        }
    }

    /*public Boolean checkSound() {
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        List list = demoHelperClass.getSound();
        if (list != null) {
            if (list.size() % 2 == 0) {
                //  Toast.makeText(getActivity(),"true",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fab.setOnClickListener(null);

    }

    public static GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

}

