package sarveshchavan777.inrerface2;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import info.hoang8f.widget.FButton;


public class FaceBookLogin extends AppCompatActivity {
    LoginButton loginButton;
    String abc = "";
    String x = "";
    String idOfUser;
    CallbackManager callbackManager;
    FButton fButton, likeFb, joinFb, earnAchievement, earnAchievementTwo;
    TextView fbText, earnAchievementText, earnAchievementTwoText, rewards, rewardstwo;
    RequestQueue requestQueue;
    int i = 0;
    DemoHelperClass demoHelperClass;
    //get
    GoogleApiClient mGoogleApiClient/*=AppController.getInstance().getClient()*/;
    Typeface typeface;
    MediaPlayer mediaPlayer;

    private static final String Group_ID = "288637851555189";
    private static final String PAGE_ID = "1357616140975878";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebooklogin);
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        loginButton = (LoginButton) findViewById(R.id.login_button);
        fButton = (FButton) findViewById(R.id.cancelButton);
        likeFb = (FButton) findViewById(R.id.likeFb);
        joinFb = (FButton) findViewById(R.id.joinFb);
        fbText = (TextView) findViewById(R.id.fbText);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        joinFb.setTypeface(typeface);
        likeFb.setTypeface(typeface);
        fbText.setTypeface(typeface);
        earnAchievement = (FButton) findViewById(R.id.earnAchievement);
        earnAchievementTwo = (FButton) findViewById(R.id.earnAchievementTwo);
        requestQueue = Volley.newRequestQueue(this);
        earnAchievementText = (TextView) findViewById(R.id.earnAchievementText);
        earnAchievementTwoText = (TextView) findViewById(R.id.earnAchievementTwoText);
        rewards = (TextView) findViewById(R.id.rewards);
        rewardstwo = (TextView) findViewById(R.id.rewards2);

        rewards.setTypeface(typeface);
        earnAchievementTwoText.setTypeface(typeface);
        earnAchievementText.setTypeface(typeface);
        earnAchievement.setTypeface(typeface);
        earnAchievementTwo.setTypeface(typeface);
        rewardstwo.setTypeface(typeface);
        mGoogleApiClient = MainActivity.mGoogleApiClient;
        if(mGoogleApiClient!=null){
            if (mGoogleApiClient.isConnected()) {
                Games.setViewForPopups(MainActivity.mGoogleApiClient, findViewById(R.id.gps_popup));
            }
        }


        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                x = loginResult.getAccessToken().getToken();
                idOfUser = loginResult.getAccessToken().getUserId();
                abc = "1";

            }

            @Override
            public void onCancel() {
                //  Toast.makeText(FaceBookLogin.this, "canceled", Toast.LENGTH_LONG).show();
                abc = "0";
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(FaceBookLogin.this, "error:make sure you have internet connection & try again", Toast.LENGTH_LONG).show();
                abc = "2";
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        likeFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isLoggedIn()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "\tPlease login first" + " ", Toast.LENGTH_SHORT);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(typeface);
                    v.setTextSize(16);
                    toast.show();
                } else {
                    i = 100;
                    try {
                        //if user has fb app
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + PAGE_ID));
                        startActivity(intent);
                    } catch (Exception e) {
                        //if users doesn't have fb app
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/charetakergames/"));
                        startActivity(intent);
                    }

                }


                if(checkSound()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                            }
                        });
                    }
                }

            }
        });

        joinFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isLoggedIn()) {
                    Toast toast = Toast.makeText(FaceBookLogin.this, "\tPlease login first" + " ", Toast.LENGTH_SHORT);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(typeface);
                    v.setTextSize(16);
                    toast.show();
                } else {
                    //https://www.facebook.com/groups/charetaker/
                    try {
                        //if user has fb app
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://group/" + Group_ID));
                        startActivity(intent);
                    } catch (Exception e) {
                        //if users doesn't have fb app
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/charetaker/"));
                        startActivity(intent);
                    }

                }

                if(checkSound()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                            }
                        });
                    }
                }

            }
        });

        earnAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 100) {
                    //  GoogleApiClient client = AppController.getInstance().getClient();
                    if (mGoogleApiClient != null ) {
                        if ( mGoogleApiClient.isConnected()) {
                            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_visitor));
                            // Toast.makeText(FaceBookLogin.this,"achievement unlocked",Toast.LENGTH_LONG).show();
                        }
                    }

                }

                if(checkSound()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                            }
                        });
                    }
                }
            }
        });

        earnAchievementTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        "https://graph.facebook.com/" + Group_ID + "/members?access_token=" + x,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonArray = response.getJSONArray("data");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        if (idOfUser.equals(jsonObject.get("id"))) {
                                            //if user is group member
                                            //  Toast.makeText(FaceBookLogin.this, "Is a group member"+idOfUser, Toast.LENGTH_LONG).show();

                                            if (mGoogleApiClient != null ) {
                                                if ( mGoogleApiClient.isConnected()) {
                                                    Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_crew_member));
                                                    // Toast.makeText(FaceBookLogin.this,"achievement unlocked",Toast.LENGTH_LONG).show();
                                                }
                                            }
                                            break;
                                        }/* else {
                                            //if user is not a group member
                                            Toast.makeText(FaceBookLogin.this, "Is not a group member", Toast.LENGTH_LONG).show();
                                        }*/
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Toast.makeText(FaceBookLogin.this, "Please check your network connection and try again."+error, Toast.LENGTH_LONG).show();
                        // finish();
                    }
                }
                );
                requestQueue.add(jsonObjectRequest);

                if(checkSound()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                            }
                        });
                    }
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
        /*if (abc.equals("1")) {
         //  Toast.makeText(FaceBookLogin.this, "login sussefully", Toast.LENGTH_LONG).show();

        } else if (abc.equals("0")) {
            //do nothing
        } else {
            //do nothing
        }*/
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ring.release();
            }
        });*/
        finish();
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken == null;
    }


   /* @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }*/

    public Boolean checkSound() {
        List list = demoHelperClass.getSound();
        if (list != null) {
            if (list.size() % 2 == 0) {
                //  Toast.makeText(getActivity(),"true",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (ring != null) {
//            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    ring.release();
//                }
//            });
//        }
        demoHelperClass = null;
        likeFb.setOnClickListener(null);
        earnAchievement.setOnClickListener(null);
        earnAchievementTwo.setOnClickListener(null);
        joinFb.setOnClickListener(null);
        fButton.setOnClickListener(null);
    }
}
