package sarveshchavan777.inrerface2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.BaseGameUtils;

import java.io.IOException;
import java.util.List;

import sarveshchavan777.inrerface2.application.AppController;


public class MainActivity extends AppCompatActivity
        implements
        View.OnClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final java.lang.String LEADERBOARD_ID = "CgkItYPd68IBEAIQBw";
    private static final int REQUEST_LEADERBOARD = 100;
    FloatingActionButton fab;

    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs = 3;
    public int icon[] = {R.drawable.home, R.drawable.settings, R.drawable.trophy};


    //google variable
    private static int RC_SIGN_IN = 9001;
    private static final int RC_UNUSED = 5001;

    private boolean mResolvingConnectionFailure = false;
    private boolean mAutoStartSignInflow = true;


    private boolean mSignInClicked = false;
    boolean mExplicitSignOut = false;

    boolean mInSignInFlow = false; // set to true when you're in the middle of the
    // sign in flow, to know you should not attempt
    // to connect in onStart()
    static GoogleApiClient mGoogleApiClient;  // initialized in onCreate


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create the Google Api Client with access to the Play Games services
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .addApi(Drive.API).addScope(Drive.SCOPE_APPFOLDER)

                // add other APIs and scopes here as needed
                .build();

        //set
        Intent intent = getIntent();
        AppController.getInstance().setClient(mGoogleApiClient);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            //  Toast.makeText(MainActivity.this,"this is one time only",Toast.LENGTH_LONG).show();
            mSignInClicked = true;
            if (!mGoogleApiClient.isConnected()) {
                mGoogleApiClient.connect();
            }
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mTabs.setCustomTabView(R.layout.customtablayout, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.white));
        mTabs.setViewPager(mPager);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        final DemoHelperClass demoHelperClass = new DemoHelperClass(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sign in
                if (mGoogleApiClient != null && !mGoogleApiClient.isConnected()) {
                    // start the asynchronous sign in flow
                    mSignInClicked = true;
                    mGoogleApiClient.connect();
                    if (mGoogleApiClient.isConnected()) {
                        fab.setImageResource(R.drawable.gsignout);
                    }
                }

                // sign out.
                if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
                    mExplicitSignOut = true;
                    mSignInClicked = false;
                    Games.signOut(mGoogleApiClient);
                    mGoogleApiClient.disconnect();
                    // show sign-in button, hide the sign-out button
                    if (!mGoogleApiClient.isConnected()) {
                        fab.setImageResource(R.drawable.gsignin);
                    }
                }

                if(checkSound()){
                    MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.gameaudio2);
                    ring.start();
                }
            }
        });
        if (mGoogleApiClient.isConnected()) {
            fab.setImageResource(R.drawable.gsignout);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mGoogleApiClient.isConnected()) {
            mGoogleApiClient.connect();
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
    public void onConnectionFailed(ConnectionResult connectionResult) {
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
        if (requestCode == RC_SIGN_IN) {
            mSignInClicked = false;
            mResolvingConnectionFailure = false;
            if (resultCode == RESULT_OK) {
                mGoogleApiClient.connect();
            } else {
                // Bring up an error dialog to alert the user that sign-in
                // failed. The R.string.signin_failure should reference an error
                // string in your strings.xml file that tells the user they
                // could not be signed in, such as "Unable to sign in."
                BaseGameUtils.showActivityResultError(this,
                        requestCode, resultCode, R.string.signin_failure);
            }
        }
    }

   /* @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }*/
   public Boolean checkSound(){
      DemoHelperClass demoHelperClass=new DemoHelperClass(this);
       List list=demoHelperClass.getSound();
       if(list!=null){
           if( list.size()%2==0 ){
               //  Toast.makeText(getActivity(),"true",Toast.LENGTH_LONG).show();
               return true;
           }
       }
       return false;
   }
}

