package sarveshchavan777.inrerface2;


import android.app.Dialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.chartboost.ChartboostAdapter;
import com.google.ads.mediation.unity.UnityAdapter;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;


import java.util.Random;
import java.util.ArrayList;
import java.util.List;


import com.chartboost.sdk.Chartboost;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;

import info.hoang8f.widget.FButton;


public class Personality extends AppCompatActivity implements RewardedVideoAdListener {
    List<Questions> quesList;
    boolean clicked = false;
    ImageView /*imageView,*/ imageView2, leftImage, rightImage, hint1,/* whatsapp, fbmessganger,*/
            master, hint2, gems, bomb, correctImage;
    ImageView cracker1, cracker2, cracker3, cracker4/*, cracker5, cracker6*/;
    DemoHelperClass demoHelperClass;
    Questions currentQ;
    int qid;
    TextView tvQ, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20;
    TextView tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b;
    FButton tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29;
    FButton tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b;
    StringBuffer stringBuffer = new StringBuffer(10);
    StringBuffer stringBuffer2 = new StringBuffer(10);
    TextView textView, textView2, tvt, incorrect, /*dollartext, plusTwo,*/
            queNum, diffLevel, solvedText, triviaKnowldegText;
    TextView diamondtext;
    LinearLayout l1, l2;
    ArrayList list = new ArrayList();
    //  ArrayList<TextView> list3 = new ArrayList();
    Toolbar toolbar;
    TextView textViewArrayAbove[] = new TextView[20];
    TextView textfirst[] = new TextView[10];
    TextView textsecound[] = new TextView[10];
    FButton textViewArrayBelow[] = new FButton[18];
    Button textViewBelowFirst[] = new Button[10];
    Button textViewBelowsecond[] = new Button[10];
    //variable declared
    private AdView mAdView;
    private RewardedVideoAd mAd;
    FButton watchVideo;
    FButton watchVideoBoom;
    Boolean bluehintclicked = false;
    Boolean boomClicked = false;
    BootstrapProgressBar bootstrapProgressBar;
    private static final java.lang.String LEADERBOARD_ID = "CgkItYPd68IBEAIQBw";
    GoogleApiClient mGoogleApiClient;/*= AppController.getInstance().getClient();*/
    MediaPlayer ring;
    Typeface chunkfive, grobold, openSansBold, openSansSemiBold, shablagooital, titilliumWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Chartboost.startWithAppId(this, "593121b843150f14e9d9f526", "71b3e71b07e19f035092fdc411c461f217cb54df");
        Chartboost.onCreate(this);
        setContentView(R.layout.personality);
        //Type casting All
        incorrect = (TextView) findViewById(R.id.incorrect);
        incorrect.setVisibility(View.INVISIBLE);
        tvQ = (TextView) findViewById(R.id.textQuestion);
        tvt = (TextView) findViewById(R.id.textviewpersonality);
        imageView2 = (ImageView) findViewById(R.id.leftpersonality);
        leftImage = (ImageView) findViewById(R.id.lefticon);
        l1 = (LinearLayout) findViewById(R.id.layout1);
        l1.setVisibility(View.VISIBLE);
        l2 = (LinearLayout) findViewById(R.id.layout2);
        l2.setVisibility(View.VISIBLE);
        rightImage = (ImageView) findViewById(R.id.righticon);
        correctImage = (ImageView) findViewById(R.id.correctImage);
        correctImage.setVisibility(View.INVISIBLE);
        master = (ImageView) findViewById(R.id.master);
        master.setVisibility(View.INVISIBLE);
        hint1 = (ImageView) findViewById(R.id.hint);
        hint1.setVisibility(View.VISIBLE);
        diamondtext = (TextView) findViewById(R.id.diamondtext);
        hint2 = (ImageView) findViewById(R.id.hint2);
        hint2.setVisibility(View.VISIBLE);
        gems = (ImageView) findViewById(R.id.imageView);
        queNum = (TextView) findViewById(R.id.questionNumber);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        diffLevel = (TextView) findViewById(R.id.difflevel);
        solvedText = (TextView) findViewById(R.id.solvedText);
        bomb = (ImageView) findViewById(R.id.bomb);
        triviaKnowldegText = (TextView) findViewById(R.id.triviaKnowledgeText);
        bootstrapProgressBar = (BootstrapProgressBar) findViewById(R.id.bottomTriviaKnowledgeBar);
        cracker1 = (ImageView) findViewById(R.id.cracker1);
        cracker2 = (ImageView) findViewById(R.id.cracker2);
        cracker3 = (ImageView) findViewById(R.id.cracker3);
        cracker4 = (ImageView) findViewById(R.id.cracker4);
        cracker1.setVisibility(View.INVISIBLE);
        cracker2.setVisibility(View.INVISIBLE);
        cracker3.setVisibility(View.INVISIBLE);
        cracker4.setVisibility(View.INVISIBLE);

        mGoogleApiClient = MainActivity.mGoogleApiClient;
        if (mGoogleApiClient != null) {
            if (mGoogleApiClient.isConnected()) {
                Games.setViewForPopups(MainActivity.mGoogleApiClient, findViewById(R.id.gps_popup));
            }
        }


        // Initialize the Google Mobile Ads SDK
        MobileAds.initialize(this, getString(R.string.Test_admob_app_id));

        //adcolony
        /*adcolony removed*/

        //chartboost
        final Bundle bundle = new ChartboostAdapter.ChartboostExtrasBundleBuilder()
                .build();





        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            // banner  admob.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdView = (AdView) findViewById(R.id.adView);
                    AdRequest adRequest = new AdRequest.Builder()
                            .addNetworkExtrasBundle(ChartboostAdapter.class, bundle)
                            .build();
                    mAdView.loadAd(adRequest); //Your code to show add

                }
            }, 3000000);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        } else {
            // banner  admob.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdView = (AdView) findViewById(R.id.adView);
                    AdRequest adRequest = new AdRequest.Builder()
                            .addNetworkExtrasBundle(ChartboostAdapter.class, bundle)
                            .build();
                    mAdView.loadAd(adRequest); //Your code to show add
                }
            }, 20000);
        }

        /*if (DemoHelperClass.adsHelper == 1) {
            // banner  admob.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdView = (AdView) findViewById(R.id.adView);
                    AdRequest adRequest = new AdRequest.Builder()
                            .addNetworkExtrasBundle(ChartboostAdapter.class, bundle)
                            .build();
                    mAdView.loadAd(adRequest); //Your code to show add

                }
            }, 3000000);
        } else {
            // banner  admob.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdView = (AdView) findViewById(R.id.adView);
                    AdRequest adRequest = new AdRequest.Builder()
                            .addNetworkExtrasBundle(ChartboostAdapter.class, bundle)
                            //c .addNetworkExtrasBundle(AdColonyAdapter.class, AdColonyBundleBuilder.build())
                            .build();
                    mAdView.loadAd(adRequest); //Your code to show add

                }
            }, 27000);
        }*/

        //Native ads


        // RewardedVideoAd=Get reference to singleton RewardedVideoAd object
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadAdRewardedVideo();

        tv11 = (TextView) findViewById(R.id.text11);
        tv12 = (TextView) findViewById(R.id.text12);
        tv13 = (TextView) findViewById(R.id.text13);
        tv14 = (TextView) findViewById(R.id.text14);
        tv15 = (TextView) findViewById(R.id.text15);
        tv16 = (TextView) findViewById(R.id.text16);
        tv17 = (TextView) findViewById(R.id.text17);
        tv18 = (TextView) findViewById(R.id.text18);
        tv19 = (TextView) findViewById(R.id.text19);
        tv20 = (TextView) findViewById(R.id.text20);

        tv11b = (TextView) findViewById(R.id.text11b);
        tv12b = (TextView) findViewById(R.id.text12b);
        tv13b = (TextView) findViewById(R.id.text13b);
        tv14b = (TextView) findViewById(R.id.text14b);
        tv15b = (TextView) findViewById(R.id.text15b);
        tv16b = (TextView) findViewById(R.id.text16b);
        tv17b = (TextView) findViewById(R.id.text17b);
        tv18b = (TextView) findViewById(R.id.text18b);
        tv19b = (TextView) findViewById(R.id.text19b);
        tv20b = (TextView) findViewById(R.id.text20b);

        tv21 = (FButton) findViewById(R.id.text21);
        tv22 = (FButton) findViewById(R.id.text22);
        tv23 = (FButton) findViewById(R.id.text23);
        tv24 = (FButton) findViewById(R.id.text24);
        tv25 = (FButton) findViewById(R.id.text25);
        tv26 = (FButton) findViewById(R.id.text26);
        tv27 = (FButton) findViewById(R.id.text27);
        tv28 = (FButton) findViewById(R.id.text28);
        tv29 = (FButton) findViewById(R.id.text29);

        tv21b = (FButton) findViewById(R.id.text21b);
        tv22b = (FButton) findViewById(R.id.text22b);
        tv23b = (FButton) findViewById(R.id.text23b);
        tv24b = (FButton) findViewById(R.id.text24b);
        tv25b = (FButton) findViewById(R.id.text25b);
        tv26b = (FButton) findViewById(R.id.text26b);
        tv27b = (FButton) findViewById(R.id.text27b);
        tv28b = (FButton) findViewById(R.id.text28b);
        tv29b = (FButton) findViewById(R.id.text29b);

        //array is created here so that it will pass the value of this array to the global varable array so it can be used in other mothds
        final TextView textViewArrayAbove2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        final TextView textfirst2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20};
        final TextView textsecound2[] = {tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        final FButton textViewArrayBelow2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};
        final FButton textViewBelowFirst2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29};
        final FButton textViewBelowsecond2[] = {tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};


        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i] = textViewArrayAbove2[i];
        }

        for (int i = 0; i < 10; i++) {
            textfirst[i] = textfirst2[i];
            textsecound[i] = textsecound2[i];
        }

        for (int i = 0; i < 10; i++) {
            textsecound[i] = textsecound2[i];
        }
        for (int i = 0; i < 18; i++) {
            textViewArrayBelow[i] = textViewArrayBelow2[i];
        }
        for (int i = 0; i < 9; i++) {
            textViewBelowFirst[i] = textViewBelowFirst2[i];
        }
        for (int i = 0; i < 9; i++) {
            textViewBelowsecond[i] = textViewBelowsecond2[i];
        }

        //type faces--
        // final Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Semibold.ttf");
        shablagooital = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        titilliumWeb = Typeface.createFromAsset(getAssets(), "fonts/TitilliumWeb-Bold.ttf");
        chunkfive = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
        grobold = Typeface.createFromAsset(getAssets(), "fonts/grobold.ttf");
        openSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Semibold.ttf");
        openSansBold = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");

        tvt.setTypeface(shablagooital);
        diamondtext.setTypeface(titilliumWeb);
        incorrect.setTypeface(shablagooital);
        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].setTypeface(titilliumWeb);
        }
        for (int i = 0; i < 18; i++) {
            textViewArrayBelow[i].setTypeface(chunkfive);
        }
        queNum.setTypeface(grobold);
        diffLevel.setTypeface(shablagooital);
        solvedText.setTypeface(titilliumWeb);
        triviaKnowldegText.setTypeface(shablagooital);

        //onClick listener for backbutton,hint1image
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                /* Obtain String from Intent  */
                if (intent != null) {
                    String clicked = intent.getStringExtra("Key");

                    for (int i = 0; i < 180; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, SecoundSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 180; i < 360; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, SportsSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 360; i < 600; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, GeoSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 600; i < 780; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, ScienceSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 780; i < 900; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, ArtsSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 900; i < 1120; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(Personality.this, EntertainmentSlidingMain.class);
                            startActivity(intent2);
                            finish();
                        }
                    }
                }
                if (checkSound()) {
                    ring = MediaPlayer.create(Personality.this, R.raw.knife);
                    ring.start();
                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            ring.release();
                        }
                    });
                }
            }

        });

        hint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(Personality.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.hintdialog);
                dialog.setCancelable(true);

                TextView freehintdialog = (TextView) dialog.findViewById(R.id.freehinttext);
                TextView reavel1 = (TextView) dialog.findViewById(R.id.reavel1);
                TextView reavel11 = (TextView) dialog.findViewById(R.id.reavel11);
                reavel1.setTypeface(shablagooital);
                reavel11.setTypeface(shablagooital);
                freehintdialog.setTypeface(shablagooital);
                dialog.show();
                Button cancel = (Button) dialog.findViewById(R.id.cancel);
                cancel.setTypeface(shablagooital);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                Button ok = (Button) dialog.findViewById(R.id.ok);
                ok.setTypeface(shablagooital);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String hint = currentQ.getANSWER() + currentQ.getANSWER2();
                        Integer hintLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();

                        //if bomb has been used for the qid then dont do reqular hint1
                        //if current question is not solved and answer boxes is greater than 3 then only hint1 is visible and can use.

                        //hint1 without boom
                        if (returnBoomIdUsed() != qid) {
                            if (returnQid() != qid && returnHint1Used() != qid && currentQ.getANSWER().length() + currentQ.getANSWER2().length() > 3) {

                                //random numbers are 0,1,2,3,4
                                ArrayList<Integer> numbers = new ArrayList<>();
                                Random randomGenerator = new Random();
                                //this will generate 5 numbers
                                if (hintLength > 5) {
                                    while (numbers.size() < 5) {
                                        int random = randomGenerator.nextInt(hintLength - 1) + 1;
                                        if (!numbers.contains(random)) {
                                            numbers.add(random);
                                        }
                                    }
                                }

                                //this will generate 4 numbers
                                if (hintLength > 4) {
                                    while (numbers.size() < 4) {
                                        int random = randomGenerator.nextInt(hintLength - 1) + 1;
                                        if (!numbers.contains(random)) {
                                            numbers.add(random);
                                        }
                                    }
                                }

                                //this will generate 3 numbers
                                if (hintLength > 3) {
                                    while (numbers.size() < 3) {
                                        int random = randomGenerator.nextInt(hintLength - 1) + 1;
                                        if (!numbers.contains(random)) {
                                            numbers.add(random);
                                        }
                                    }
                                }

                                //random number vale are stored in table 4,5,6,9,10 and even hint is  tore in table 3;
                                demoHelperClass.insertHint(qid);
                                if (hintLength > 3) {
                                    demoHelperClass.insertA1(numbers.get(0));
                                } else {
                                    demoHelperClass.insertA1(0);
                                }
                                if (hintLength > 4) {
                                    demoHelperClass.insertA2(numbers.get(1));
                                } else {
                                    demoHelperClass.insertA2(0);
                                }
                                if (hintLength > 5) {
                                    demoHelperClass.insertA3(numbers.get(2));
                                } else {
                                    demoHelperClass.insertA3(0);
                                }
                                if (hintLength > 8) {
                                    demoHelperClass.insertA4(numbers.get(3));
                                } else {
                                    demoHelperClass.insertA4(0);
                                }
                                if (hintLength > 12) {
                                    demoHelperClass.insertA5(numbers.get(4));
                                } else {
                                    demoHelperClass.insertA5(0);
                                }


                                //the alphabet of the random number are store here
                                String xx = "", yy = "", zz = "", pp = "", qq = "";

                                if (hintLength > 3) {
                                    xx = Character.toString(hint.charAt(numbers.get(0))).toUpperCase();
                                }
                                if (hintLength > 4) {
                                    yy = Character.toString(hint.charAt(numbers.get(1))).toUpperCase();
                                }
                                if (hintLength > 5) {
                                    zz = Character.toString(hint.charAt(numbers.get(2))).toUpperCase();
                                }
                                if (hintLength > 8) {
                                    pp = Character.toString(hint.charAt(numbers.get(3))).toUpperCase();
                                }
                                if (hintLength > 12) {
                                    qq = Character.toString(hint.charAt(numbers.get(4))).toUpperCase();
                                }


                                //this list store the postion of visisble boxes of above
                                int length = currentQ.getANSWER().length();
                                int length2 = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();


                                for (int i = 0; i < length; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < length2; j++) {
                                    arrayList.add(j + 10);
                                }

                                //before setting the above boxes text remove text if user has enter the text that is refresh
                                refreshBoxesboth();


                                //setting the text for the above boxes
                                if (hintLength > 3) {
                                    textViewArrayAbove[arrayList.get(numbers.get(0))].setText(xx);
                                }
                                if (hintLength > 4) {
                                    textViewArrayAbove[arrayList.get(numbers.get(1))].setText(yy);
                                }
                                if (hintLength > 5) {
                                    textViewArrayAbove[arrayList.get(numbers.get(2))].setText(zz);
                                }
                                if (hintLength > 6) {
                                    textViewArrayAbove[arrayList.get(numbers.get(3))].setText(pp);
                                }
                                if (hintLength > 7) {
                                    textViewArrayAbove[arrayList.get(numbers.get(4))].setText(qq);
                                }
                                arrayList.clear();
                                numbers.clear();


                                //now removing the 1,2,3,4,5, respectively option boxes which has same alphabets that are random generated
                                //1st
                                if (hintLength > 3) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(xx)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //2nd
                                if (hintLength > 4) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(yy)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //3rd
                                if (hintLength > 5) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(zz)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }

                                //4th
                                if (hintLength > 8) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(pp)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }


                                //5th
                                if (hintLength > 12) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(qq)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (hintLength > 3) {
                                    hint1.setVisibility(View.INVISIBLE);
                                }
                                if (hintLength <= 3) {
                                    //  Toast.makeText(Personality.this, "Free hint not available for less than 4 ", Toast.LENGTH_LONG).show();
                                    Toast toast = Toast.makeText(Personality.this, "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                                    v.setTypeface(shablagooital);
                                    v.setTextSize(12);
                                    toast.show();
                                }
                            }

                        }

                        //hint1 with boom
                        if (returnQid() != qid && returnHint1Used() != qid) {
                            if (returnBoomIdUsed() == qid) {
                                refreshBoxesboth();
                                demoHelperClass.insertHint(qid);
                                if (hintLength > 3) {
                                    demoHelperClass.insertA1(0);
                                } else {
                                    demoHelperClass.insertA1(0);
                                }
                                if (hintLength > 4) {
                                    demoHelperClass.insertA2(1);
                                } else {
                                    demoHelperClass.insertA2(0);
                                }
                                if (hintLength > 5) {
                                    demoHelperClass.insertA3(2);
                                } else {
                                    demoHelperClass.insertA3(0);
                                }
                                if (hintLength > 8) {
                                    demoHelperClass.insertA4(3);
                                } else {
                                    demoHelperClass.insertA4(0);
                                }
                                if (hintLength > 12) {
                                    demoHelperClass.insertA5(4);
                                } else {
                                    demoHelperClass.insertA5(0);
                                }


                                //this list store the postion of visisble boxes of above
                                int length = currentQ.getANSWER().length();
                                int length2 = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();


                                for (int i = 0; i < length; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < length2; j++) {
                                    arrayList.add(j + 10);
                                }


                                //setting the text of above boxes
                                String bothAnswer = currentQ.getANSWER() + currentQ.getANSWER2();

                                if (hintLength > 3) {

                                    textViewArrayAbove[arrayList.get(0)].setText(bothAnswer.substring(0, 1).toUpperCase());
                                }
                                if (hintLength > 4) {

                                    textViewArrayAbove[arrayList.get(1)].setText(bothAnswer.substring(1, 2).toUpperCase());
                                }
                                if (hintLength > 5) {

                                    textViewArrayAbove[arrayList.get(2)].setText(bothAnswer.substring(2, 3).toUpperCase());
                                }
                                if (hintLength > 8) {

                                    textViewArrayAbove[arrayList.get(3)].setText(bothAnswer.substring(3, 4).toUpperCase());
                                }
                                if (hintLength > 12) {

                                    textViewArrayAbove[arrayList.get(4)].setText(bothAnswer.substring(4, 5).toUpperCase());

                                }
                                arrayList.clear();


                                //now removing the below boxes
                                if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() >= 4) {
                                    String char1 = bothAnswer.substring(0, 1);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //2nd
                                if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() >= 5) {
                                    String char1 = bothAnswer.substring(1, 2);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //3rd
                                if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() >= 6) {
                                    String char1 = bothAnswer.substring(2, 3);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //4th
                                if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() >= 9) {
                                    String char1 = bothAnswer.substring(3, 4);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //5th
                                if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() >= 13) {
                                    String char1 = bothAnswer.substring(4, 5);
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(char1)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }

                                }
                                removeKachra();
                            }

                            if (hintLength > 3) {
                                hint1.setVisibility(View.INVISIBLE);
                            }
                            if (hintLength <= 3) {
                                // Toast.makeText(Personality.this, "Free hint not available for less than 4 boxes", Toast.LENGTH_LONG).show();

                                Toast toast = Toast.makeText(Personality.this, "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                                v.setTypeface(shablagooital);
                                v.setTextSize(12);
                                toast.show();
                            }
                        }
                        dialog.dismiss();
                        if (mGoogleApiClient.isConnected()) {
                            checkAchievementOne();
                            checkAchievementTwo();
                        }

                        if (checkSound()) {
                            ring = MediaPlayer.create(Personality.this, R.raw.gameaudio2);
                            ring.start();

                            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    ring.release();
                                }
                            });
                        }
                    }
                });

            }

        });//Hint1 getover here

       /* whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                currentQ.getQUESTION());
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                try {
                    startActivity(sendIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Personality.this, "Please Install Whatsapp", Toast.LENGTH_LONG).show();
                }
            }
        });*/
        /*fbmessganger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent
                        .putExtra(Intent.EXTRA_TEXT,
                                currentQ.getQUESTION());
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.facebook.orca");
                try {
                    startActivity(sendIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Personality.this, "Please Install Facebook Messenger", Toast.LENGTH_LONG).show();
                }

            }
        });*/


        //someSqlite stuff
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = demoHelperClass.getWritableDatabase();
        if (demoHelperClass.getCheckQadded() != null) {
            if (demoHelperClass.getCheckQadded().size() == 0) {
                demoHelperClass.addquestions();
                demoHelperClass.insertCheckQadded(1);
            }
        }


        quesList = demoHelperClass.getAllOfTheQuestions();
        Intent intent = getIntent();

        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            //@@ 11

            for (int i = 0; i <= 1119; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    currentQ = quesList.get(qid = i);
                    if (i == 1119) {
                        rightImage.setVisibility(View.INVISIBLE);
                    }
                    break;
                }
            }

        }

        //methods calls
        correctlayout();
        view1();
        view2();

        //if id is 0 then left image is invisble
        if (qid == 0) {
            leftImage.setVisibility(View.INVISIBLE);
        }

        //checking id hint is used if yes then hint is invisible
        if (returnHint1Used() == qid) {
            hint1.setVisibility(View.INVISIBLE);
            fillingBoxes();
        }

        //if question is not solved check if boom is used if used then boom is invisible and boomMethod is called
        //check if qid is solved if yes then dont call boomMethod
        if (returnQid() != qid) {
            if (returnBoomIdUsed() == qid) {
                bomb.setVisibility(View.INVISIBLE);
                boomMethod();
            }
        }

        //after question has solved setting the answer text
        if (returnQid() == qid) {
            for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
            }
            correctImage.setVisibility(View.VISIBLE);
        }
        if (returnQid() == qid) {
            for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());

            }
        }

        xmlColor();
        allAnimation();
        List list = demoHelperClass.getGems();
        int gemstext = (Integer) list.get(list.size() - 1);
        diamondtext.setText(String.valueOf(gemstext));
        visiblityOfrightleft();
        diffque();
        List list2 = demoHelperClass.GetQid();
        solvedText.setText(String.valueOf(list2.size()));
        //if boxes less than or eual to 3 then hint1 invisble
        if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
            //  hint1.setVisibility(View.INVISIBLE);
            hint1.setImageResource(R.drawable.noidea1cartoon);
        } else {
            hint1.setImageResource(R.drawable.idea1cartoon);
        }
        list.clear();
        sqLiteDatabase.close();
    }//onCreate ends here


    //Animations method called in Oncreate and right and left;
    private void allAnimation() {

        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.11, 10);
        myAnim.setInterpolator(interpolator);
        tvQ.startAnimation(myAnim);


        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            public void run() {
                master.startAnimation(inFromLeftAnimation());
                master.setVisibility(View.VISIBLE);   //for interval...
            }
        };
        handler.postDelayed(runnable, 150); //for initial delay..*//*

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].startAnimation(myAnim);
        }

        /*//animation for below fbuttons
        final Animation myAnim2 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator2 = new MyBounceInterpolator(0.05, 0);
        myAnim2.setInterpolator(interpolator2);*/

        //this will animated only the boxes below which has some character
        //this is imp because after using bomb and hint1 some boxes has setText="".
       /* for (int i = 0; i < currentQ.getRANDOMANS1().length(); i++) {
            if(textViewBelowFirst[i].getText()==""){
                textViewBelowFirst[i].startAnimation(myAnim2);
            }

        }
        for (int j = 0; j < currentQ.getRANDOMANS2().length(); j++) {
           if(textViewBelowsecond[j].getText()==""){
               textViewBelowsecond[j].startAnimation(myAnim2);
           }
        }*/

        /*final Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            int i = 0;

            public void run() {
                for (int i = 0; i < textViewArrayBelow.length; i++) {
                    textViewArrayBelow[i].clearAnimation();
                }  //for interval...
            }
        };
        handler2.postDelayed(runnable2, 2000);*/
    }

    public void crackerAnimation() {

        final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(300);
        fadeOut.setDuration(300);
        final Animation fadeOut2 = new AlphaAnimation(1, 0);
        fadeOut2.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut2.setStartOffset(400);
        fadeOut2.setDuration(600);


        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {

            public void run() {
                cracker1.setVisibility(View.VISIBLE);
                //for interval...
            }
        };
        handler.postDelayed(runnable, 150);

        final Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker11);
                cracker3.setVisibility(View.VISIBLE);
                cracker4.setVisibility(View.VISIBLE);
            }
        };
        handler2.postDelayed(runnable2, 200);

        final Handler handler3 = new Handler();
        Runnable runnable3 = new Runnable() {

            public void run() {
                cracker2.setVisibility(View.VISIBLE);
                cracker1.setImageResource(R.drawable.cracker22);
                cracker3.setImageResource(R.drawable.cracker11);
                cracker4.setImageResource(R.drawable.cracker11);
                //for interval...
            }
        };
        handler3.postDelayed(runnable3, 250);

        final Handler handler4 = new Handler();
        Runnable runnable4 = new Runnable() {

            public void run() {

                cracker1.setImageResource(R.drawable.cracker33);
                cracker2.setImageResource(R.drawable.cracker11);
                cracker3.setImageResource(R.drawable.cracker22);
                cracker4.setImageResource(R.drawable.cracker22);

            }
        };
        handler4.postDelayed(runnable4, 300);

        final Handler handler5 = new Handler();
        Runnable runnable5 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker44);
                cracker2.setImageResource(R.drawable.cracker22);
                cracker3.setImageResource(R.drawable.cracker33);
                cracker4.setImageResource(R.drawable.cracker33);
            }
        };
        handler5.postDelayed(runnable5, 350);

        final Handler handler6 = new Handler();
        Runnable runnable6 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker55);
                cracker2.setImageResource(R.drawable.cracker33);
                cracker3.setImageResource(R.drawable.cracker44);
                cracker4.setImageResource(R.drawable.cracker44);
            }
        };
        handler6.postDelayed(runnable6, 400);

        final Handler handler7 = new Handler();
        Runnable runnable7 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker66);
                cracker2.setImageResource(R.drawable.cracker44);
                cracker3.setImageResource(R.drawable.cracker55);
                cracker4.setImageResource(R.drawable.cracker55);
            }
        };
        handler7.postDelayed(runnable7, 450);

        final Handler handler8 = new Handler();
        Runnable runnable8 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker77);
                cracker2.setImageResource(R.drawable.cracker55);
                cracker3.setImageResource(R.drawable.cracker66);
                cracker4.setImageResource(R.drawable.cracker66);
                //for interval...
            }
        };
        handler8.postDelayed(runnable8, 500);


        final Handler handler9 = new Handler();
        Runnable runnable9 = new Runnable() {

            public void run() {
                cracker1.setImageResource(R.drawable.cracker88);
                cracker2.setImageResource(R.drawable.cracker66);
                cracker3.setImageResource(R.drawable.cracker77);
                cracker4.setImageResource(R.drawable.cracker77);
                //for interval...
            }
        };
        handler9.postDelayed(runnable9, 550);

        final Handler handler10 = new Handler();
        Runnable runnable10 = new Runnable() {

            public void run() {

                cracker2.setImageResource(R.drawable.cracker77);
                cracker3.setImageResource(R.drawable.cracker88);
                cracker4.setImageResource(R.drawable.cracker99);
                //for interval...
            }
        };
        handler10.postDelayed(runnable10, 600);

        final Handler handler11 = new Handler();
        Runnable runnable11 = new Runnable() {

            public void run() {
                cracker1.setAnimation(fadeOut2);
                cracker2.setImageResource(R.drawable.cracker99);
                //for interval...
            }
        };
        handler11.postDelayed(runnable11, 650);


        final Handler handler12 = new Handler();
        Runnable runnable12 = new Runnable() {

            public void run() {
                cracker1.setVisibility(View.INVISIBLE);
                cracker3.setAnimation(fadeOut2);
                cracker4.setAnimation(fadeOut2);

                //for interval...
            }
        };
        handler12.postDelayed(runnable12, 680);

        final Handler handler13 = new Handler();
        Runnable runnable13 = new Runnable() {

            public void run() {
                cracker2.startAnimation(fadeOut);
                //for interval...
            }
        };
        handler13.postDelayed(runnable13, 730);

        final Handler handler14 = new Handler();
        Runnable runnable14 = new Runnable() {

            public void run() {

                cracker3.setVisibility(View.INVISIBLE);
                cracker4.setVisibility(View.INVISIBLE);
                //for interval...
            }
        };
        handler14.postDelayed(runnable14, 780);


        final Handler handler15 = new Handler();
        Runnable runnable15 = new Runnable() {

            public void run() {
                cracker2.setVisibility(View.INVISIBLE);
                //for interval...
            }
        };
        handler15.postDelayed(runnable15, 830);


        cracker1.setImageResource(R.drawable.cracker11);
        cracker2.setImageResource(R.drawable.cracker22);
        cracker3.setImageResource(R.drawable.cracker33);
        cracker4.setImageResource(R.drawable.cracker44);
    }

    //Animation method
    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(600);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

   /* private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(600);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }*/

    /*public AnimationSet animationSet() {
        AnimationSet as = new AnimationSet(true);
        Animation bottomToTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        bottomToTop.setDuration(1500);
        bottomToTop.setInterpolator(new AccelerateInterpolator());
        as.addAnimation(bottomToTop);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1600);
        as.addAnimation(fadeOut);
        return as;
    }*/


    public void view1() {
        tvQ.setText(currentQ.getQUESTION());
        //Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");
        tvQ.setTypeface(openSansBold);
    }


    public void check() {
        int y = tv11.length() + tv12.length() + tv13.length() + tv14.length() + tv15.length() + tv16.length() + tv17.length() + tv18.length() + tv19.length() + tv20.length();
        int y2 = tv11b.length() + tv12b.length() + tv13b.length() + tv14b.length() + tv15b.length() + tv16b.length() + tv17b.length() + tv18b.length() + tv19b.length() + tv20b.length();
        if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() == y + y2) {
            String x = (stringBuffer.append(tv11.getText()).append(tv12.getText()).append(tv13.getText()).append(tv14.getText()).append(tv15.getText()).append(tv16.getText()).append(tv17.getText()).append(tv18.getText()).append(tv19.getText()).append(tv20.getText())).toString();
            String x2 = (stringBuffer2.append(tv11b.getText()).append(tv12b.getText()).append(tv13b.getText()).append(tv14b.getText()).append(tv15b.getText()).append(tv16b.getText()).append(tv17b.getText()).append(tv18b.getText()).append(tv19b.getText()).append(tv20b.getText())).toString();
            if (x.equalsIgnoreCase(currentQ.getANSWER()) && x2.equalsIgnoreCase(currentQ.getANSWER2())) {
                //@@ 3
                if (qid < 1119 && qid != 179 && qid != 359 && qid != 599 && qid != 779 && qid != 899) {
                    demoHelperClass.InsertQid(qid);

                    //updating leaderboard score
                    if (mGoogleApiClient.isConnected()) {
                        DemoHelperClass demoHelperClass = new DemoHelperClass(Personality.this);
                        List xyz = demoHelperClass.GetQid();
                        int noOfSolvedQuestion = xyz.size();
                        //multiplying the no of solved Questions by 5
                        int leaderboardScore = noOfSolvedQuestion * 5;
                        Games.Leaderboards.submitScore(mGoogleApiClient, LEADERBOARD_ID, leaderboardScore);
                        xyz.clear();
                    }

                    //updating the achievement
                    if (mGoogleApiClient.isConnected()) {
                        checkAchievementOne();
                        checkAchievementTwo();
                    }

                    //setting the text for number of correct question solved
                    List list2 = demoHelperClass.GetQid();
                    solvedText.setText(String.valueOf(list2.size()));
                    //  int adddollar = 2;
                    //  demoHelperClass.InsertDollar(adddollar);
                    String stringanswer;
                    stringanswer = currentQ.getANSWER() + " " + currentQ.getANSWER2();
                    qid = qid + 1;
                    currentQ = quesList.get(qid);
                    //left
                    //@@ 4
                    if (qid <= 1119) {
                        leftImage.setVisibility(View.VISIBLE);
                    }
                    //right
                    //@@ 5
                    if (qid == 1119) {
                        rightImage.setVisibility(View.INVISIBLE);
                    }
                    //    Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
                    //   Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
                    //set up dialog
                    final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.maindialog);
                    dialog.setCancelable(false);


                    //there are a lot of settings, for dialog, check them all out!
                    //set up text
                    //   TextView dialogTitle = (TextView) dialog.findViewById(R.id.dialogtitle);
                    TextView correct = (TextView) dialog.findViewById(R.id.correct);
                    //   dialogTitle.setTypeface(typeface);
                    correct.setTypeface(shablagooital);

                    //admob
                    /*AdView mAdView2 = (AdView) dialog.findViewById(R.id.adView2);
                    AdRequest adRequest = new AdRequest.Builder().build();
                    mAdView2.loadAd(adRequest);*/

                    NativeExpressAdView adViewNativeads = (NativeExpressAdView) dialog.findViewById(R.id.adViewNativeads);
                    AdRequest request = new AdRequest.Builder().build();
                    adViewNativeads.loadAd(request);


                    //Animation
                    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                    // Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 70);
                    myAnim.setInterpolator(interpolator);
                    correct.startAnimation(myAnim);
                    TextView answerorrect = (TextView) dialog.findViewById(R.id.answercorrect);
                    answerorrect.setTypeface(chunkfive);
                    answerorrect.setText(stringanswer.toUpperCase());
                    //giving additional information
                    //@@ 6
                  /*  for (int i = 0; i < 40; i++) {
                        if (qid == i) {
                            String[] arrayT = getResources().getStringArray(R.array.myarray);
                            text.setText(arrayT[i - 1]);
                            break;
                        }
                    }*/
                    //set up button (Next Button)
                    Button button = (Button) dialog.findViewById(R.id.Button01);
                    button.setTypeface(chunkfive);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            master.setVisibility(View.INVISIBLE);
                            allAnimation();
                            view1();
                            view2();
                            correctlayout();
                            fillingBoxes();
                            queNum.setText(String.valueOf(qid + 1));
                            visiblityOfrightleft();
                            diffque();


                            //if the answer boxes are greater than three then also hint1 invisible
                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                hint1.setVisibility(View.INVISIBLE);
                            }

                            clicked = false;
                            //if question hint is already used then hint invisible
                            if (returnHint1Used() == qid) {
                                hint1.setVisibility(View.INVISIBLE);
                            }
                            //else is very imp
                            else {
                                hint1.setVisibility(View.VISIBLE);
                            }

                            //if question is solved then hint1 invisible
                            if (returnQid() == qid) {
                                hint1.setVisibility(View.INVISIBLE);
                            }


                            //check if boom is used if used then boom is invisible
                            //and call bomb method
                            if (returnQid() != qid) {
                                if (returnBoomIdUsed() == qid) {
                                    boomMethod();
                                    bomb.setVisibility(View.INVISIBLE);
                                } else {
                                    bomb.setVisibility(View.VISIBLE);
                                }
                            }

                            //after question has solved setting the answer text
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                                }
                                correctImage.setVisibility(View.VISIBLE);
                            }
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                                }
                            }

                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                //  hint1.setVisibility(View.INVISIBLE);
                                hint1.setImageResource(R.drawable.noidea1cartoon);
                            } else {
                                hint1.setImageResource(R.drawable.idea1cartoon);
                            }

                            dialog.cancel();

                            if (checkSound()) {
                                ring = MediaPlayer.create(Personality.this, R.raw.wooden_stick);
                                ring.start();
                            }
                        }
                    });

                    dialog.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);


                    if (checkSound()) {
                        ring = MediaPlayer.create(Personality.this, R.raw.victory);
                        ring.start();


                        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {

                                ring.release();
                            }
                        });

                    }

//                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                        @Override
//                        public void onCompletion(MediaPlayer mediaPlayer) {
//
//                            ring.release();
//                        }
//                    });
                }
                //@@ 7
                else if (qid == 1119 || qid == 179 || qid == 359 || qid == 599 || qid == 779 || qid == 899) {
                    // demoHelperClass.InsertDollar(adddollar);
                    // final Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/shablagooital.ttf");
                    Toast toast = Toast.makeText(this, "\tcorrect \t", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.transparent2));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgreen2));
                    v.setTypeface(shablagooital);
                    v.setTextSize(20);
                    toast.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);
                    demoHelperClass.InsertQid(qid);

                    //updating leaderboard score
                    if (mGoogleApiClient.isConnected()) {
                        DemoHelperClass demoHelperClass = new DemoHelperClass(Personality.this);
                        List xyz = demoHelperClass.GetQid();
                        int noOfSolvedQuestion = xyz.size();
                        //multiplying the no of solved Questions by 5
                        int leaderboardScore = noOfSolvedQuestion * 5;
                        Games.Leaderboards.submitScore(mGoogleApiClient, LEADERBOARD_ID, leaderboardScore);
                    }

                    //updating the achievement
                    if (mGoogleApiClient.isConnected()) {
                        checkAchievementOne();
                        checkAchievementTwo();
                    }

                    currentQ = quesList.get(qid);
                    view2();
                    correctlayout();
                    hint1.setVisibility(View.INVISIBLE);
                    //setting the text for number of correct question solved
                    List list2 = demoHelperClass.GetQid();
                    solvedText.setText(String.valueOf(list2.size()));
                    list2.clear();

                    clicked = false;
                }
            } else {
                incorrectAnimation();
                stringBuffer.setLength(0);
                stringBuffer2.setLength(0);
            }
        }
    }//end of check

   /* public void check() {
        int y = tv11.length() + tv12.length() + tv13.length() + tv14.length() + tv15.length() + tv16.length() + tv17.length() + tv18.length() + tv19.length() + tv20.length();
        int y2 = tv11b.length() + tv12b.length() + tv13b.length() + tv14b.length() + tv15b.length() + tv16b.length() + tv17b.length() + tv18b.length() + tv19b.length() + tv20b.length();
        if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() == y + y2) {
            String x = (stringBuffer.append(tv11.getText()).append(tv12.getText()).append(tv13.getText()).append(tv14.getText()).append(tv15.getText()).append(tv16.getText()).append(tv17.getText()).append(tv18.getText()).append(tv19.getText()).append(tv20.getText())).toString();
            String x2 = (stringBuffer2.append(tv11b.getText()).append(tv12b.getText()).append(tv13b.getText()).append(tv14b.getText()).append(tv15b.getText()).append(tv16b.getText()).append(tv17b.getText()).append(tv18b.getText()).append(tv19b.getText()).append(tv20b.getText())).toString();
            if (x.equalsIgnoreCase(currentQ.getANSWER()) && x2.equalsIgnoreCase(currentQ.getANSWER2())) {
                //@@ 3
                if (qid < 1119 && qid != 179 && qid != 359 && qid != 599 && qid != 779 && qid != 899) {

                    demoHelperClass.InsertQid(qid);

                    //updating leaderboard score
                    if (mGoogleApiClient.isConnected()) {
                        DemoHelperClass demoHelperClass = new DemoHelperClass(Personality.this);
                        List xyz = demoHelperClass.GetQid();
                        int noOfSolvedQuestion = xyz.size();
                        //multiplying the no of solved Questions by 5
                        int leaderboardScore = noOfSolvedQuestion * 5;
                        Games.Leaderboards.submitScore(mGoogleApiClient, LEADERBOARD_ID, leaderboardScore);
                    }

                    //updating the achievement
                    if (mGoogleApiClient.isConnected()) {
                        checkAchievementOne();
                        checkAchievementTwo();
                    }
                    //setting the text for number of correct question solved
                    List list2 = demoHelperClass.GetQid();
                    solvedText.setText(Integer.toString(list2.size()));
                    //  int adddollar = 2;
                    //  demoHelperClass.InsertDollar(adddollar);
                    String stringanswer = "";
                    stringanswer = currentQ.getANSWER() + " " + currentQ.getANSWER2();
                    qid = qid + 1;
                    currentQ = quesList.get(qid);
                    //left
                    //@@ 4
                    if (qid <= 1119) {
                        leftImage.setVisibility(View.VISIBLE);
                    }
                    //right
                    //@@ 5
                    if (qid == 1119) {
                        rightImage.setVisibility(View.INVISIBLE);
                    }
                    Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
                    Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");

                    //set up dialog
                    final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.maindialog);
                    dialog.setCancelable(false);

                    //there are a lot of settings, for dialog, check them all out!
                    //set up textcheck
                    // TextView dialogTitle = (TextView) dialog.findViewById(R.id.dialogtitle);
                    TextView correct = (TextView) dialog.findViewById(R.id.correct);
                    // dialogTitle.setTypeface(typeface);
                    correct.setTypeface(typeface2);

                    //admob
                    *//*AdView mAdView2 = (AdView) dialog.findViewById(R.id.adView2);
                    AdRequest adRequest = new AdRequest.Builder().build();
                    mAdView2.loadAd(adRequest);*//*

                    NativeExpressAdView adViewNativeads = (NativeExpressAdView) dialog.findViewById(R.id.adViewNativeads);
                    AdRequest request = new AdRequest.Builder().build();
                    adViewNativeads.loadAd(request);


                    //Animation
                    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                    // Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 70);
                    myAnim.setInterpolator(interpolator);
                    correct.startAnimation(myAnim);
                    TextView answerorrect = (TextView) dialog.findViewById(R.id.answercorrect);
                    answerorrect.setTypeface(typeface);
                    answerorrect.setText(stringanswer.toUpperCase());
                    //giving additional information
                    //@@ 6
                  *//*  for (int i = 0; i < 40; i++) {
                        if (qid == i) {
                            String[] arrayT = getResources().getStringArray(R.array.myarray);
                            text.setText(arrayT[i - 1]);
                            break;
                        }
                    }*//*
                    //set up button (Next Button)
                    Button button = (Button) dialog.findViewById(R.id.Button01);
                    button.setTypeface(typeface);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            master.setVisibility(View.INVISIBLE);
                            allAnimation();
                            view1();
                            view2();
                            correctlayout();
                            fillingBoxes();
                            queNum.setText(Integer.toString(qid + 1));
                            visiblityOfrightleft();
                            diffque();


                            //if the answer boxes are greater than three then also hint1 invisible
                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                hint1.setVisibility(View.INVISIBLE);
                            }

                            clicked = false;
                            //if question hint is already used then hint invisible
                            if (returnHint1Used() == qid) {
                                hint1.setVisibility(View.INVISIBLE);
                            }
                            //else is very imp
                            else {
                                hint1.setVisibility(View.VISIBLE);
                            }

                            //if question is solved then hint1 invisible
                            if (returnQid() == qid) {
                                hint1.setVisibility(View.INVISIBLE);
                            }


                            //check if boom is used if used then boom is invisible
                            //and call bomb method
                            if (returnQid() != qid) {
                                if (returnBoomIdUsed() == qid) {
                                    boomMethod();
                                    bomb.setVisibility(View.INVISIBLE);
                                } else {
                                    bomb.setVisibility(View.VISIBLE);
                                }
                            }

                            //after question has solved setting the answer text
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                                }
                                correctImage.setVisibility(View.VISIBLE);
                            }
                            if (returnQid() == qid) {
                                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                                }
                            }

                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                hint1.setVisibility(View.INVISIBLE);
                            }
                            dialog.cancel();
                        }
                    });

                    dialog.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);
                }
                //@@ 7
                else if (qid == 1119 || qid == 179 || qid == 359 || qid == 599 || qid == 779 || qid == 899) {

                    final Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/shablagooital.ttf");
                    Toast toast = Toast.makeText(this, "\tcorrect \t", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(getResources().getColor(R.color.transparent2));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(getResources().getColor(R.color.lightgreen2));
                    v.setTypeface(typeface);
                    v.setTextSize(20);
                    toast.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);
                    demoHelperClass.InsertQid(qid);

                    //updating leaderboard score
                    if (mGoogleApiClient.isConnected()) {
                        DemoHelperClass demoHelperClass = new DemoHelperClass(Personality.this);
                        List xyz = demoHelperClass.GetQid();
                        int noOfSolvedQuestion = xyz.size();
                        //multiplying the no of solved Questions by 5
                        int leaderboardScore = noOfSolvedQuestion * 5;
                        Games.Leaderboards.submitScore(mGoogleApiClient, LEADERBOARD_ID, leaderboardScore);
                    }

                    //updating the achievement
                    if (mGoogleApiClient.isConnected()) {
                        checkAchievementOne();
                        checkAchievementTwo();
                    }
                    currentQ = quesList.get(qid);
                    view2();
                    correctlayout();
                    hint1.setVisibility(View.INVISIBLE);
                    //setting the text for number of correct question solved
                    List list2 = demoHelperClass.GetQid();
                    solvedText.setText(Integer.toString(list2.size()));
                    clicked = false;

                } else {
                    incorrectAnimation();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);
                }
            }
        }
    }//end of check*/

    //Animation of incorrect if wrong answer
    public void incorrectAnimation() {
        incorrect.setVisibility(View.VISIBLE);
        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 60);
        myAnim.setInterpolator(interpolator);
        incorrect.startAnimation(myAnim);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                incorrect.setVisibility(View.INVISIBLE);  //for interval...
            }
        };
        handler.postDelayed(runnable, 100); //for initial delay..*/

        if (checkSound()) {
            ring = MediaPlayer.create(Personality.this, R.raw.incorrect);
            ring.start();
            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    ring.release();
                }
            });

        }
    }


    public void view2() {

        List xyz = demoHelperClass.GetQid();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                int x = (Integer) xyz.get(i);

                if (x == qid) {
                    int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
                    int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());

                    try {
                        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                            height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                            weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                        }

                        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                            height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                            weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                        }
                    } catch (Exception e) {
                        // Toast.makeText(Personality.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
                    }

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(1, 1, 1, 1);

                    for (int z = 0; z < 10; z++) {
                        if (currentQ.getANSWER().length() >= z + 1) {
                            textfirst[z].setText(currentQ.getANSWER().substring(z, z + 1).toUpperCase());
                            textfirst[z].setLayoutParams(params);
                        }
                    }
                    for (int k = 0; k < 10; k++) {
                        if (currentQ.getANSWER2().length() >= k + 1) {

                            textsecound[k].setText(currentQ.getANSWER2().substring(k, k + 1).toUpperCase());
                            textsecound[k].setLayoutParams(params);
                        }
                    }

                    break;

                }
                /*if (x != qid) {*/
                comman3();
               /* }*/

            }
        }
        if (xyz != null) {
            if (xyz.size() == 0) {
                comman3();
            }
        }

        //1st and 2nd
        for (int i = 0; i < 10; i++) {
            if (currentQ.getANSWER().length() >= i + 1) {
                textfirst[i].setVisibility(View.VISIBLE);
            } else {
                textfirst[i].setVisibility(View.INVISIBLE);
                textfirst[i].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }
        for (int j = 0; j < 10; j++) {
            if (currentQ.getANSWER2().length() >= j + 1) {
                textsecound[j].setVisibility(View.VISIBLE);
            } else {
                textsecound[j].setVisibility(View.INVISIBLE);
                textsecound[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int checkWidth = size.x;
        int checkHeight = size.y;

        //Toast.makeText(Personality.this, "width=" + Integer.toString(width1), Toast.LENGTH_LONG).show();
        // Toast.makeText(Personality.this, "height=" + Integer.toString(height1), Toast.LENGTH_LONG).show();

        //setting the text of the below boxes 18 boxes.
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
        int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);
        params.setMargins(1, 1, 1, 1);
        tvQ.setTextSize(12);

        //NORMAL
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                if (checkWidth < 700 && checkHeight < 1000) {
                    height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
                    weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(1, 1, 1, 1);
                    tvQ.setTextSize(13);
                    //  Toast.makeText(Personality.this, "Normal -less", Toast.LENGTH_LONG).show();
                } else {
                    height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(3, 3, 3, 3);
                    tvQ.setTextSize(14);
                    //   Toast.makeText(Personality.this, "NORMAL", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            //   Toast.makeText(Personality.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        //LARGE
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                params = new LinearLayout.LayoutParams(
                        weidth, height);
                params.setMargins(4, 4, 4, 4);
                tvQ.setTextSize(23);
                //    Toast.makeText(Personality.this, "large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(27);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(Personality.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        //X-LARGE
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, getResources().getDisplayMetrics());
                params = new LinearLayout.LayoutParams(
                        weidth, height);
                params.setMargins(7, 7, 7, 7);
                tvQ.setTextSize(25);
                //  Toast.makeText(Personality.this, "x-large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(30);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(Personality.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        /*if (width1 < 700 && height1 < 1000) {
            if ((getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                //setting the text of the below boxes 18 boxes.
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 33, getResources().getDisplayMetrics());
            }
        }


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);

        if (width1 < 700 && height1 < 1000) {
            if ((getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                // on a large screen device ...
                params.setMargins(1, 1, 1, 1);
                tvQ.setTextSize(13);
               Toast.makeText(Personality.this, "width=" + Integer.toString(width1), Toast.LENGTH_LONG).show();
            }
            if ((getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK) !=
                    Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                params.setMargins(3, 3, 3, 3);
                tvQ.setTextSize(17);
               Toast.makeText(Personality.this, "called", Toast.LENGTH_LONG).show();
            }
        }else{
            params.setMargins(3, 3, 3, 3);
            tvQ.setTextSize(15);
            Toast.makeText(Personality.this, "called2", Toast.LENGTH_LONG).show();
        }*/

        for (int j = 0; j < 9; j++) {
            if (currentQ.getRANDOMANS1().length() >= j + 1) {

                textViewBelowFirst[j].setVisibility(View.VISIBLE);
                textViewBelowFirst[j].setText(currentQ.getRANDOMANS1().substring(j, j + 1));
                textViewBelowFirst[j].setLayoutParams(params);

            } else {
                textViewBelowFirst[j].setVisibility(View.INVISIBLE);
                textViewBelowFirst[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

        for (int j = 0; j < 9; j++) {
            if (currentQ.getRANDOMANS2().length() >= j + 1) {
                textViewBelowsecond[j].setVisibility(View.VISIBLE);
                textViewBelowsecond[j].setText(currentQ.getRANDOMANS2().substring(j, j + 1));
                textViewBelowsecond[j].setLayoutParams(params);

            } else {
                textViewBelowsecond[j].setVisibility(View.INVISIBLE);
                textViewBelowsecond[j].setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

    }//end of view2


    private void comman3() {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                //   Toast.makeText(Personality.this,"called yo yo",Toast.LENGTH_LONG).show();
            }

            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                //   Toast.makeText(Personality.this,"called yo yo",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            //  Toast.makeText(Personality.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);
        params.setMargins(1, 1, 1, 1);

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].setText("");
            textViewArrayAbove[i].setLayoutParams(params);
        }
    }

    public void Comman() {
        //onclick listener for aboveboxes if clicked below boxes visible

        for (int i = 0; i < 18; i++) {
            if (textView.getText() != "") {
                if (textView.getText() == textViewArrayBelow[i].getText()) {
                    textViewArrayBelow[i].setVisibility(View.VISIBLE);
                    textView.setText("");
                    break;
                }
            }
        }

    }

    public void Comman2() {
        //onclick listener for belowboxes if clicked above boxes visible

        for (int i = 0; i < 20; i++) {
            if (textViewArrayAbove[i].length() == 0 && textViewArrayAbove[i].getVisibility() == View.VISIBLE) {
                textViewArrayAbove[i].setText(textView2.getText());
                textView2.setVisibility(View.INVISIBLE);
                check();
                break;
            }
        }
    }
    //onclick listener for all above and below boxes

    public void text11(View view) {
        textView = tv11;
        Comman();
    }

    public void text12(View view) {
        textView = tv12;
        Comman();
    }

    public void text13(View view) {
        textView = tv13;
        Comman();
    }

    public void text14(View view) {
        textView = tv14;
        Comman();
    }

    public void text15(View view) {
        textView = tv15;
        Comman();
    }

    public void text16(View view) {
        textView = tv16;
        Comman();
    }

    public void text17(View view) {
        textView = tv17;
        Comman();
    }

    public void text18(View view) {
        textView = tv18;
        Comman();
    }

    public void text19(View view) {
        textView = tv19;
        Comman();
    }

    public void text20(View view) {
        textView = tv20;
        Comman();
    }

    public void text11b(View view) {
        textView = tv11b;
        Comman();
    }

    public void text12b(View view) {
        textView = tv12b;
        Comman();
    }

    public void text13b(View view) {
        textView = tv13b;
        Comman();
    }

    public void text14b(View view) {
        textView = tv14b;
        Comman();
    }

    public void text15b(View view) {
        textView = tv15b;
        Comman();
    }

    public void text16b(View view) {
        textView = tv16b;
        Comman();
    }

    public void text17b(View view) {
        textView = tv17b;
        Comman();
    }

    public void text18b(View view) {
        textView = tv18b;
        Comman();
    }

    public void text19b(View view) {
        textView = tv19b;
        Comman();
    }

    public void text20b(View view) {
        textView = tv20b;
        Comman();
    }

    public void text21(View view) {
        textView2 = tv21;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text22(View view) {
        textView2 = tv22;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text23(View view) {
        textView2 = tv23;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text24(View view) {
        textView2 = tv24;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text25(View view) {
        textView2 = tv25;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text26(View view) {
        textView2 = tv26;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text27(View view) {
        textView2 = tv27;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text28(View view) {
        textView2 = tv28;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text29(View view) {
        textView2 = tv29;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text21b(View view) {
        textView2 = tv21b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text22b(View view) {
        textView2 = tv22b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text23b(View view) {
        textView2 = tv23b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text24b(View view) {
        textView2 = tv24b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text25b(View view) {
        textView2 = tv25b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text26b(View view) {
        textView2 = tv26b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text27b(View view) {
        textView2 = tv27b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void text28b(View view) {
        textView2 = tv28b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });
    }

    public void text29b(View view) {
        textView2 = tv29b;
        Comman2();
        ring = MediaPlayer.create(getApplicationContext(), R.raw.woosh);
        ring.start();
        ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                ring.release();
            }
        });

    }

    public void left(View view) {
        // myNum = Integer.parseInt(myString.getText().toString());
        if (qid >= 0) {
            master.setVisibility(View.INVISIBLE);
            qid--;
            currentQ = quesList.get(qid);
            hint1.setVisibility(View.VISIBLE);
            hint2.setVisibility(View.VISIBLE);
            bomb.setVisibility(View.VISIBLE);
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.VISIBLE);
            correctImage.setVisibility(View.INVISIBLE);
            view1();
            view2();
            //correct layout
            //if question is solved then hint1,hint2,l1,l2 are invisible
            if (returnQid() == qid) {
                hint2.setVisibility(View.INVISIBLE);
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.INVISIBLE);
                hint1.setVisibility(View.INVISIBLE);
                bomb.setVisibility(View.INVISIBLE);
                correctImage.setVisibility(View.VISIBLE);
            }

            fillingBoxes();
            allAnimation();
            visiblityOfrightleft();
            diffque();
            List list2 = demoHelperClass.GetQid();
            solvedText.setText(String.valueOf(list2.size()));
            List list3 = demoHelperClass.getGems();
            int gemstext = (Integer) list3.get(list3.size() - 1);
            diamondtext.setText(String.valueOf(gemstext));
            list2.clear();
            list3.clear();


            // if hint is used then hint 1 invisible
            if (returnHint1Used() == qid) {
                hint1.setVisibility(View.INVISIBLE);
            }

            //check if boom is used after click right
            //if used then call boomMethod and boam is invisible
            //and if the qid is solved dont call boomMethod
            if (returnQid() != qid) {
                if (returnBoomIdUsed() == qid) {
                    bomb.setVisibility(View.INVISIBLE);
                    boomMethod();
                }
            }

            //after question has solved setting the answer text
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                }
            }
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                }
            }

            // if boxes less than or eual to 3 then hint1 invisble
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                // hint1.setVisibility(View.INVISIBLE);
                hint1.setImageResource(R.drawable.noidea1cartoon);
            } else {
                hint1.setImageResource(R.drawable.idea1cartoon);
            }

            //this is for left and right images visibility and invisibility
            if (qid == 0) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            //@@ 12
            if (qid <= 1118) {
                rightImage.setVisibility(View.VISIBLE);
            }
        }


        if (checkSound()) {
            ring = MediaPlayer.create(Personality.this, R.raw.wooden_stick);
            ring.start();
            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    ring.release();
                }
            });
        }


    }

    public void right(View view) {
        if (qid >= 0) {
            master.setVisibility(View.INVISIBLE);
            qid++;
            currentQ = quesList.get(qid);
            hint1.setVisibility(View.VISIBLE);
            hint2.setVisibility(View.VISIBLE);
            bomb.setVisibility(View.VISIBLE);
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.VISIBLE);
            correctImage.setVisibility(View.INVISIBLE);
            view1();
            view2();
            //correct layout
            //if question is solved then hint1,hint2,l1,l2 are invisible
            if (returnQid() == qid) {
                hint2.setVisibility(View.INVISIBLE);
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.INVISIBLE);
                hint1.setVisibility(View.INVISIBLE);
                bomb.setVisibility(View.INVISIBLE);
                correctImage.setVisibility(View.VISIBLE);
            }
            fillingBoxes();
            allAnimation();
            visiblityOfrightleft();
            diffque();
            List list2 = demoHelperClass.GetQid();
            solvedText.setText(String.valueOf(list2.size()));
            List list3 = demoHelperClass.getGems();
            int gemstext = (Integer) list3.get(list3.size() - 1);
            diamondtext.setText(String.valueOf(gemstext));
            list3.clear();
            list2.clear();

            // if hint is used then hint 1 invisible
            if (returnHint1Used() == qid) {
                hint1.setVisibility(View.INVISIBLE);
            }

            //check if boom is used after click right
            //if used then call boomMethod and boam is invisible
            //and if the qid is solved dont call boomMethod
            if (returnQid() != qid) {
                if (returnBoomIdUsed() == qid) {
                    bomb.setVisibility(View.INVISIBLE);
                    boomMethod();
                }
            }

            //after question has solved setting the answer text
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                    textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                }
            }
            if (returnQid() == qid) {
                for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                    textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                }
            }

            //if boxes less than or equal to 3 then hint1 invisible
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                //  hint1.setVisibility(View.INVISIBLE);
                hint1.setImageResource(R.drawable.noidea1cartoon);
            } else {
                hint1.setImageResource(R.drawable.idea1cartoon);
            }

            //this is for left and right images visibility and invisibility
            if (qid >= 1) {
                leftImage.setVisibility(View.VISIBLE);
            }

            //@@ 8
            if (qid == 1119) {
                rightImage.setVisibility(View.INVISIBLE);
            }

        }


        if (checkSound()) {
            ring = MediaPlayer.create(Personality.this, R.raw.wooden_stick);
            ring.start();
            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    ring.release();
                }
            });
        }
    }

    public void correctlayout() {
        if (returnQid() == qid) {
            hint2.setVisibility(View.INVISIBLE);
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            hint1.setVisibility(View.INVISIBLE);
            bomb.setVisibility(View.INVISIBLE);
        }
    }

    public void checkIfHintIsUsed() {
        //this method checks if the hint1 is used if yes then it will set the text of some of the boxes
        //if boxes=4 hint=1, boxes=5 hint=2, boxes=6-8 hint=3, boxes=9-12 hint=4, boxes=12-18 hint=5
        String storebothanswer = currentQ.getANSWER() + currentQ.getANSWER2();
        Integer hintLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();
        List xyz = demoHelperClass.getHint();
        List xyz11 = demoHelperClass.getA1();
        List xyz22 = demoHelperClass.getA2();
        List xyz33 = demoHelperClass.getA3();
        List xyz44 = demoHelperClass.getA4();
        List xyz55 = demoHelperClass.getA5();
        if (xyz != null) {
            int x11 = 100001, x22 = 100001, x33 = 100001, x44 = 100001, x55 = 100001;
            for (int i = 0; i < xyz.size(); i++) {
                int x = (Integer) xyz.get(i);

                if (x == qid) {

                    if (hintLength > 3) {
                        x11 = (Integer) xyz11.get(i);
                    }
                    if (hintLength > 4) {
                        x22 = (Integer) xyz22.get(i);
                    }
                    if (hintLength > 5) {
                        x33 = (Integer) xyz33.get(i);
                    }
                    if (hintLength > 8) {
                        x44 = (Integer) xyz44.get(i);
                    }
                    if (hintLength > 12) {
                        x55 = (Integer) xyz55.get(i);
                    }

                    StringBuilder stringBuffer = new StringBuilder();
                    if (hintLength > 3) {
                        stringBuffer.append(storebothanswer.charAt(x11));
                    }
                    if (hintLength > 4) {
                        stringBuffer.append(storebothanswer.charAt(x22));
                    }
                    if (hintLength > 5) {
                        stringBuffer.append(storebothanswer.charAt(x33));
                    }
                    if (hintLength > 8) {
                        stringBuffer.append(storebothanswer.charAt(x44));
                    }
                    if (hintLength > 12) {
                        stringBuffer.append(storebothanswer.charAt(x55));
                    }


                    //this list store the postion of visisble boxes of above
                    int length = currentQ.getANSWER().length();
                    int length2 = currentQ.getANSWER2().length();
                    ArrayList<Integer> arrayList = new ArrayList<>();


                    for (int k = 0; k < length; k++) {
                        arrayList.add(k);
                    }
                    for (int j = 0; j < length2; j++) {
                        arrayList.add(j + 10);
                    }

                    //before setting text of above boxes clear all above and below boxes that is refresh
                    refreshBoxesboth();

                    //setting the text for the above boxes
                    if (hintLength > 3) {
                        textViewArrayAbove[arrayList.get(x11)].setText(stringBuffer.substring(0, 1).toUpperCase());
                    }
                    if (hintLength > 4) {
                        textViewArrayAbove[arrayList.get(x22)].setText(stringBuffer.substring(1, 2).toUpperCase());
                    }
                    if (hintLength > 5) {
                        textViewArrayAbove[arrayList.get(x33)].setText(stringBuffer.substring(2, 3).toUpperCase());
                    }
                    if (hintLength > 8) {
                        textViewArrayAbove[arrayList.get(x44)].setText(stringBuffer.substring(3, 4).toUpperCase());
                    }
                    if (hintLength > 12) {
                        textViewArrayAbove[arrayList.get(x55)].setText(stringBuffer.substring(4, 5).toUpperCase());
                    }
                    arrayList.clear();


                    //now removing the three option boxes which has same alphabets that are random generate
                    //1st
                    if (hintLength > 3) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(0, 1))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }
                    //2nd
                    if (hintLength > 4) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(1, 2))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }
                    //3rd
                    if (hintLength > 5) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(2, 3))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }

                    //4th
                    if (hintLength > 8) {
                        for (TextView j : textViewArrayBelow) {
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(3, 4))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                        }
                    }


                    //5th
                    if (hintLength > 12) {
                        for (TextView j : textViewArrayBelow)
                            if (j.getVisibility() == View.VISIBLE) {
                                if (j.getText().toString().equalsIgnoreCase(stringBuffer.substring(4, 5))) {
                                    j.setText("");
                                    j.setVisibility(View.INVISIBLE);
                                    break;
                                }
                            }
                    }
                    break;
                }
                stringBuffer.setLength(0);

            }
        }

        xyz.clear();
        xyz11.clear();
        xyz22.clear();
        xyz33.clear();
        xyz44.clear();
        xyz55.clear();
    }


    public void fillingBoxes() {
        checkIfHintIsUsed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getIntent();
                /* Obtain String from Intent  */
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            for (int i = 0; i < 180; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, SecoundSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 180; i < 360; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, SportsSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 360; i < 600; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, GeoSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 600; i < 780; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, ScienceSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 780; i < 900; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, ArtsSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 900; i < 1120; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(Personality.this, EntertainmentSlidingMain.class);
                    startActivity(intent2);
                    finish();
                }
            }
        }
    }

    public void revealhole(View view) {
        final Dialog dialog = new Dialog(Personality.this);
        //dialog.requestWindowFeature(Window.);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.reveal);
        dialog.setCancelable(true);

        //  final Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/shablagooital.ttf");
        // final Typeface typeface2 = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Semibold.ttf");

        TextView revealtext2 = (TextView) dialog.findViewById(R.id.revealtext2);
        TextView or = (TextView) dialog.findViewById(R.id.or);
        TextView costReveal = (TextView) dialog.findViewById(R.id.costReavel);
        costReveal.setTypeface(shablagooital);
        /*final FButton*/
        watchVideo = (FButton) dialog.findViewById(R.id.watchvideo);

        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluehintclicked = true;
                // Toast.makeText(Personality.this,"Video watched",Toast.LENGTH_LONG).show();
                //check if the question is solved if solved then msg=Question alredy solved
                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(Personality.this, "Question already solved.\nTry for other questions.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                    dialog.dismiss();
                } else if (mAd.isLoaded()) {
                    mAd.show();
                    loadAdRewardedVideo();
                    dialog.dismiss();
                } else {
                    String loading = "Loading..";
                    watchVideo.setText("Watch Video" + "\n" + loading);
                    loadAdRewardedVideo();
                }

                if (checkSound()) {
                    ring = MediaPlayer.create(Personality.this, R.raw.gameaudio2);
                    ring.start();
                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            ring.release();
                        }
                    });
                }
            }
        });
        final List listgems = demoHelperClass.getGems();
        int gemstext = (Integer) listgems.get(listgems.size() - 1);
        Button usegems = (Button) dialog.findViewById(R.id.usegems);
        FButton buyGems = (FButton) dialog.findViewById(R.id.buyGems);

        buyGems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Personality.this, InAppPurchase.class);
                intent.putExtra("key", currentQ.getID() - 1);
                startActivity(intent);
                finish();

                if (checkSound()) {
                    ring = MediaPlayer.create(Personality.this, R.raw.gameaudio2);
                    ring.start();
                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            ring.release();
                        }
                    });
                }
            }
        });

        usegems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the question is solved if solved then no reveal
                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(Personality.this, "Question already solved", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                } else {
                    //for solvedtext
                    List list2 = demoHelperClass.GetQid();
                    solvedText.setText(String.valueOf(list2.size()));
                    //for diamounds/gems
                    int z = 2;
                    List listgems = demoHelperClass.getGems();
                    int gemstext = (Integer) listgems.get(listgems.size() - 1);
                    if (gemstext == 0 || gemstext == 1) {
                        Toast toast = Toast.makeText(Personality.this, "\t\t\tYou ran out of Gems.\n Please Buy them in shop or watch video.", Toast.LENGTH_LONG);
                        toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                        v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                        v.setTypeface(openSansSemiBold);
                        v.setTextSize(10);
                        toast.show();
                    }
                    listgems.clear();
                    list2.clear();

                    if (gemstext > 1) {
                        for (int i = 0; i < currentQ.getANSWER().length(); i++) {
                            if (textfirst[i].getVisibility() == View.VISIBLE) {
                                textfirst[i].setText(currentQ.getANSWER().substring(i, i + 1).toUpperCase());
                            }
                        }
                        for (int i = 0; i < currentQ.getANSWER2().length(); i++) {
                            if (textsecound[i].getVisibility() == View.VISIBLE) {
                                textsecound[i].setText(currentQ.getANSWER2().substring(i, i + 1).toUpperCase());
                            }
                        }
                        check();
                        //checking if button was clicked or not
                        clicked = true;

                        for (TextView i : textViewArrayBelow) {
                            i.setVisibility(View.INVISIBLE);
                        }

                        if (mGoogleApiClient.isConnected()) {
                            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_reveal));
                        }
                    }
                    if (gemstext > 1) {
                        gemstext = gemstext - z;
                        demoHelperClass.InsertGems(gemstext);
                    }
                    diamondtext.setText(String.valueOf(gemstext));
                }
                dialog.dismiss();

                if (checkSound()) {
                    ring = MediaPlayer.create(Personality.this, R.raw.gameaudio2);
                    ring.start();

                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            ring.release();
                        }
                    });
                }

            }
        });
        TextView watchvideo = (TextView) dialog.findViewById(R.id.watchvideo);
        usegems.setTypeface(shablagooital);
        TextView buyDiamond = (TextView) dialog.findViewById(R.id.buyGems);
        buyDiamond.setTypeface(shablagooital);
        TextView shop = (TextView) dialog.findViewById(R.id.shop);
        shop.setTypeface(shablagooital);
        usegems.setText(getResources().getString(R.string.useDiamond) + "\n\n" + getResources().getString(R.string.Cost_2_Diamond) + Integer.toString(gemstext) + " " + getResources().getString(R.string.diamond_left_in_your_bucket));
        buyDiamond.setText(getResources().getString(R.string.buyDiamond) + "\n\n" + getResources().getString(R.string.Shop_diamonds_at_cheap_price));
        watchvideo.setTypeface(shablagooital);
        watchvideo.setText(getResources().getString(R.string.watchvideo));
        or.setTypeface(shablagooital);
        revealtext2.setTypeface(shablagooital);
        Button cancel = (Button) dialog.findViewById(R.id.cance11);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void xmlColor() {
        final FButton textViewArrayBelow2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};
        Intent intent = getIntent();
        /* Obtain String from Intent  */
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            for (int i = 0; i < 180; i++)
                if (clicked.equals(Integer.toString(i))) {
                    tvt.setText(getResources().getString(R.string.personality));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                    break;
                }
            for (int i = 180; i < 360; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.sports));
                    tvt.setText(getResources().getString(R.string.sports));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.sportsdark));
                    for (int j = 0; j < 18; j++) {
                        textViewArrayBelow2[j].setButtonColor(ContextCompat.getColor(getApplicationContext(), R.color.sports));
                        textViewArrayBelow2[j].setShadowColor(ContextCompat.getColor(getApplicationContext(), R.color.sportsdark));
                    }
                    break;
                }
            }
            for (int i = 360; i < 600; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.geography));
                    tvt.setText(getResources().getString(R.string.geography));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.geographydark));
                    for (int j = 0; j < 18; j++) {
                        textViewArrayBelow2[j].setButtonColor(ContextCompat.getColor(getApplicationContext(), R.color.geography));
                        textViewArrayBelow2[j].setShadowColor(ContextCompat.getColor(getApplicationContext(), R.color.geographydark));
                    }
                    break;
                }
            }
            for (int i = 600; i < 780; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.science));
                    tvt.setText(getResources().getString(R.string.science));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.sciencedark));
                    for (int j = 0; j < 18; j++) {
                        textViewArrayBelow2[j].setButtonColor(ContextCompat.getColor(getApplicationContext(), R.color.science));
                        textViewArrayBelow2[j].setShadowColor(ContextCompat.getColor(getApplicationContext(), R.color.sciencedark));
                    }
                    break;
                }
            }
            for (int i = 780; i < 900; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.arts));
                    tvt.setText(getResources().getString(R.string.arts_gk));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.artsdark));
                    for (int j = 0; j < 18; j++) {
                        textViewArrayBelow2[j].setButtonColor(ContextCompat.getColor(getApplicationContext(), R.color.arts));
                        textViewArrayBelow2[j].setShadowColor(ContextCompat.getColor(getApplicationContext(), R.color.artsdark));
                    }
                    break;
                }

            }
            for (int i = 900; i < 1120; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenment));
                    tvt.setText(getResources().getString(R.string.entertainment));
                    queNum.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenmentdark));
                    for (int j = 0; j < 18; j++) {
                        textViewArrayBelow2[j].setButtonColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenment));
                        textViewArrayBelow2[j].setShadowColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenmentdark));
                    }
                    break;
                }
            }
            //Fbutton colors
        }

    }

    public void visiblityOfrightleft() {
        for (int i = 0; i < qid; i++) {
            //for rightImage
            if (qid == 179) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 359) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 599) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 779) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 899) {
                rightImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 1119) {
                rightImage.setVisibility(View.INVISIBLE);
            }

            //for leftImage
            if (qid == 180) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 360) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 600) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 780) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 900) {
                leftImage.setVisibility(View.INVISIBLE);
            }
            if (qid == 1120) {
                leftImage.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void diffque() {
        //personality
        if (qid < 60) {
            queNum.setText(String.valueOf(qid + 1));
            diffLevel.setText(getResources().getString(R.string.easy));

        }
        if (qid >= 60 && qid < 120) {
            queNum.setText(String.valueOf(qid - 59));
            diffLevel.setText(getResources().getString(R.string.medium));
        }
        if (qid >= 120 && qid < 180) {
            queNum.setText(String.valueOf(qid - 119));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //sports
        if (qid >= 180 && qid < 240) {
            queNum.setText(String.valueOf(qid - 179));
            diffLevel.setText(getResources().getString(R.string.easy));

        }
        if (qid >= 240 && qid < 300) {
            queNum.setText(String.valueOf(qid - 239));
            diffLevel.setText(getResources().getString(R.string.medium));

        }
        if (qid >= 300 && qid < 360) {
            queNum.setText(String.valueOf(qid - 299));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //geography
        if (qid >= 360 && qid < 440) {
            queNum.setText(String.valueOf(qid - 359));
            diffLevel.setText(getResources().getString(R.string.easy));
        }
        if (qid >= 440 && qid < 520) {
            queNum.setText(String.valueOf(qid - 439));
            diffLevel.setText(getResources().getString(R.string.medium));
        }
        if (qid >= 520 && qid < 600) {
            queNum.setText(String.valueOf(qid - 519));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //science
        if (qid >= 600 && qid < 660) {
            queNum.setText(String.valueOf(qid - 599));
            diffLevel.setText(getResources().getString(R.string.easy));
        }
        if (qid >= 660 && qid < 720) {
            queNum.setText(String.valueOf(qid - 659));
            diffLevel.setText(getResources().getString(R.string.medium));
        }
        if (qid >= 720 && qid < 780) {
            queNum.setText(String.valueOf(qid - 719));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //arts & gk
        if (qid >= 780 && qid < 820) {
            queNum.setText(String.valueOf(qid - 779));
            diffLevel.setText(getResources().getString(R.string.easy));
        }
        if (qid >= 820 && qid < 860) {
            queNum.setText(String.valueOf(qid - 819));
            diffLevel.setText(getResources().getString(R.string.medium));
        }
        if (qid >= 860 && qid < 900) {
            queNum.setText(String.valueOf(qid - 859));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //entertainment
        if (qid >= 900 && qid < 980) {
            queNum.setText(String.valueOf(qid - 899));
            diffLevel.setText(getResources().getString(R.string.easy));
        }
        if (qid >= 980 && qid < 1060) {
            queNum.setText(String.valueOf(qid - 979));
            diffLevel.setText(getResources().getString(R.string.medium));
        }
        if (qid >= 1060 && qid < 1120) {
            queNum.setText(String.valueOf(qid - 1059));
            diffLevel.setText(getResources().getString(R.string.hard));
        }
        //personality
        /*by deafult darkgreen*/

        //sports
        if (qid >= 180 && qid < 360) {
            for (int i = 0; i < 10; i++) {
                textfirst[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.sports));
                textsecound[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.sports));
            }
            rightImage.setImageResource(R.drawable.sportrightcartoon);
            leftImage.setImageResource(R.drawable.sportleftcartoon);
            bootstrapProgressBar.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
        }
        //geography
        if (qid >= 360 && qid < 600) {
            for (int i = 0; i < 10; i++) {
                textfirst[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.geography));
                textsecound[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.geography));
            }
            rightImage.setImageResource(R.drawable.geographyrightcartoon);
            leftImage.setImageResource(R.drawable.geographyleftcartoon);
            bootstrapProgressBar.setBootstrapBrand(DefaultBootstrapBrand.PRIMARY);
        }
        //science
        if (qid >= 600 && qid < 780) {
            for (int i = 0; i < 10; i++) {
                textfirst[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.science));
                textsecound[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.science));
            }
            rightImage.setImageResource(R.drawable.sciencerightcartoon);
            leftImage.setImageResource(R.drawable.scienceleftcartoon);
            bootstrapProgressBar.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
        }
        //arts & gk
        if (qid >= 780 && qid < 900) {
            for (int i = 0; i < 10; i++) {
                textfirst[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.arts));
                textsecound[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.arts));
            }
            rightImage.setImageResource(R.drawable.artrightcartoon);
            leftImage.setImageResource(R.drawable.artleftcartoon);
            bootstrapProgressBar.setBootstrapBrand(DefaultBootstrapBrand.WARNING);
        }
        //entertainment
        if (qid >= 900 && qid < 1120) {
            for (int i = 0; i < 10; i++) {
                textfirst[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenment));
                textsecound[i].setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenment));
            }
            rightImage.setImageResource(R.drawable.entertainmentrightcartoon);
            leftImage.setImageResource(R.drawable.entertainmentleftcartoon);
            bootstrapProgressBar.setBootstrapBrand(DefaultBootstrapBrand.DANGER);
        }

    }

    public void loadAdRewardedVideo() {
        if (!mAd.isLoaded()) {
            // test RewardedVideo=ads ca-app-pub-3940256099942544/5224354917
           /* Bundle bundle = new ChartboostAdapter.ChartboostExtrasBundleBuilder()
                    .build();*/
            /*mAd.loadAd(getString(R.string.Test_admob_unit_id_rewardedVideo),new AdRequest.Builder()
                    .addNetworkExtrasBundle(ChartboostAdapter.class, bundle).addNetworkExtrasBundle(AdColonyAdapter.class,AdColonyBundleBuilder.build())
                   .build());*/
            Bundle extras = new Bundle();
            extras.putBoolean("_noRefresh", true);
            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                    .addNetworkExtrasBundle(ChartboostAdapter.class, extras)
                    .addNetworkExtrasBundle(UnityAdapter.class, extras)
                    .build();
            mAd.loadAd(getString(R.string.Test_admob_unit_id_rewardedVideo), adRequest);
            // Toast.makeText(Personality.this,"called",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        // an add finished loading
        String videoLoaded = "Video loaded successfully\ntap to show.";
        if (bluehintclicked) {
            watchVideo.setText("Watch Video" + "\n\n" + videoLoaded);
        }
        if (boomClicked) {
            watchVideoBoom.setText("Watch Video" + "\n\n" + videoLoaded);
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {
        //fired when an add opens
    }

    @Override
    public void onRewardedVideoStarted() {
        //fired when add video actually start
    }

    @Override
    public void onRewardedVideoAdClosed() {
        //fired when add closed

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        //you get a reward
        final List listgems = demoHelperClass.getGems();
        int plusOneGem = 1;
        int gemstext = (Integer) listgems.get(listgems.size() - 1);
        gemstext = gemstext + plusOneGem;
        demoHelperClass.InsertGems(gemstext);
        diamondtext.setText(String.valueOf(gemstext));
        //   final Typeface typeface2 = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Semibold.ttf");
        Toast toast = Toast.makeText(Personality.this, "+1 gem added in your bucket.", Toast.LENGTH_LONG);
        toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        v.setTypeface(openSansSemiBold);
        v.setTextSize(10);
        toast.show();

        // GoogleApiClient client = AppController.getInstance().getClient();
        if (mGoogleApiClient.isConnected()) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_viewer));
        }

        listgems.clear();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        String failedToLoad = "Video failed to load \ntap to try again.";
        if (bluehintclicked) {
            watchVideo.setText("Watch Video" + "\n\n" + failedToLoad);
            //   watchVideoBoom.setText("Watch Video" + "\n\n" + failedToLoad);
        }
        if (boomClicked) {
            watchVideoBoom.setText("Watch Video" + "\n\n" + failedToLoad);
        }
    }

    //chartboost
    @Override
    public void onStart() {
        super.onStart();
        Chartboost.onStart(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Chartboost.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Chartboost.onPause(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        Chartboost.onStop(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Chartboost.onDestroy(this);
        quesList.clear();
        if (ring != null) {
            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    ring.release();
                }
            });
        }

//        imageView, imageView2, leftImage, rightImage, hint1,/* whatsapp, fbmessganger,*/
//                master, hint2, gems, bomb, correctImage;
//
//        cracker1, cracker2, cracker3, cracker4

//       imageView.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        leftImage.setImageDrawable(null);
        rightImage.setImageDrawable(null);
        hint1.setImageDrawable(null);
        master.setImageDrawable(null);
        hint2.setImageDrawable(null);
        gems.setImageDrawable(null);
        bomb.setImageDrawable(null);
        correctImage.setImageDrawable(null);
        cracker1.setImageDrawable(null);
        cracker2.setImageDrawable(null);
        cracker3.setImageDrawable(null);
        cracker4.setImageDrawable(null);

        finish();
    }

    public void bomb(View view) {
        final Dialog dialog = new Dialog(Personality.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.bomb);
        dialog.setCancelable(true);
        // final Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        // final Typeface typeface2 = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Semibold.ttf");
        final TextView boom = (TextView) dialog.findViewById(R.id.boom);
        TextView removeEtra = (TextView) dialog.findViewById(R.id.removeExtra);
        TextView removeEtraCost = (TextView) dialog.findViewById(R.id.removeExtraCost);
        TextView reward = (TextView) dialog.findViewById(R.id.reward);
        FButton boomFbutton = (FButton) dialog.findViewById(R.id.boomfbutton);
        FButton cancelBoom = (FButton) dialog.findViewById(R.id.cancelbomb);
        boom.setTypeface(shablagooital);
        removeEtra.setTypeface(shablagooital);
        removeEtraCost.setTypeface(shablagooital);
        boomFbutton.setTypeface(shablagooital);
        reward.setTypeface(shablagooital);
        // watchVideoBoom.setTypeface(typeface);
        cancelBoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        boomFbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List listgems = demoHelperClass.getGems();

                int gemstext = (Integer) listgems.get(listgems.size() - 1);
                if (gemstext <= 0) {
                    Toast toast = Toast.makeText(Personality.this, "\t\t\tYou ran out of Gems.\n Please Buy them in shop or watch video.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                }


                if (returnQid() != qid) {
                    if (gemstext > 0) {
                        if (returnBoomIdUsed() != qid) {
                            int z = 1;
                            boomMethod();
                            bomb.setVisibility(View.INVISIBLE);
                            demoHelperClass.insertBoom(qid);
                            gemstext = gemstext - z;
                            demoHelperClass.InsertGems(gemstext);
                            diamondtext.setText(String.valueOf(gemstext));
                            crackerAnimation();


                            if (checkSound()) {
                                ring = MediaPlayer.create(getApplicationContext(), R.raw.bombexplosion);
                                ring.start();
                                ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {

                                        ring.release();
                                    }
                                });


                            }

                        }
                    }
                }
                dialog.dismiss();
                listgems.clear();
            }
        });
     /*final   FButton*/
        watchVideoBoom = (FButton) dialog.findViewById(R.id.watchvideoBoom);
        watchVideoBoom.setTypeface(shablagooital);
        watchVideoBoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boomClicked = true;
                //check if the question is solved if solved then msg=Question alredy solved

                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(Personality.this, "Question already solved.\nTry for other questions.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                    dialog.dismiss();
                } else if (mAd.isLoaded()) {
                    mAd.show();
                    loadAdRewardedVideo();
                    dialog.dismiss();
                } else {
                    String loading = "Loading..";
                    watchVideoBoom.setText("Watch Video" + "\n" + loading);
                    loadAdRewardedVideo();
                }

                if (checkSound()) {
                    ring = MediaPlayer.create(Personality.this, R.raw.gameaudio2);
                    ring.start();

                    ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            ring.release();
                        }
                    });


                }
            }
        });
        dialog.show();
    }

    private void boomMethod() {
        if (mGoogleApiClient.isConnected()) {
            checkAchievementOne();
            checkAchievementTwo();
        }
        //bomb without hint1
        if (returnHint1Used() != qid) {
            refreshBoxesboth();
            removeKachra();

        }
        //bomb with hint1
        if (returnHint1Used() == qid) {
            refreshBoxesboth();
            checkIfHintIsUsed();
            removeKachra();
        }

    }//end of boomMethod

    private void removeKachra() {
        // Now we have to remove kachra so we have to check which all textview are visible
        //and check for there text if it matches with the getUselessstring then setText="" and also invisible
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 0) {
                String first = currentQ.getUSELESSSTRING().substring(0, 1).toUpperCase();

                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 1) {
                String first = currentQ.getUSELESSSTRING().substring(1, 2).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 2) {
                String first = currentQ.getUSELESSSTRING().substring(2, 3).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 3) {
                String first = currentQ.getUSELESSSTRING().substring(3, 4).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 4) {
                String first = currentQ.getUSELESSSTRING().substring(4, 5).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 5) {
                String first = currentQ.getUSELESSSTRING().substring(5, 6).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 6) {
                String first = currentQ.getUSELESSSTRING().substring(6, 7).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 7) {
                String first = currentQ.getUSELESSSTRING().substring(7, 8).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 8) {
                String first = currentQ.getUSELESSSTRING().substring(8, 9).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 9) {
                String first = currentQ.getUSELESSSTRING().substring(9, 10).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 10) {
                String first = currentQ.getUSELESSSTRING().substring(10, 11).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 11) {
                String first = currentQ.getUSELESSSTRING().substring(11, 12).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 12) {
                String first = currentQ.getUSELESSSTRING().substring(12, 13).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 13) {
                String first = currentQ.getUSELESSSTRING().substring(13, 14).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 14) {
                String first = currentQ.getUSELESSSTRING().substring(14, 15).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 15) {
                String first = currentQ.getUSELESSSTRING().substring(15, 16).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }

        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 16) {
                String first = currentQ.getUSELESSSTRING().substring(16, 17).toUpperCase();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
        for (TextView i : textViewArrayBelow) {
            if (currentQ.getUSELESSSTRING().length() > 17) {
                String first = currentQ.getUSELESSSTRING().substring(17, 18).toUpperCase();
                Toast.makeText(Personality.this, "", Toast.LENGTH_LONG).show();
                if (i.getVisibility() == View.VISIBLE) {
                    if (i.getText().toString().equalsIgnoreCase(first)) {
                        i.setText("");
                        i.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        }
    }//end of removeKachra

    public void refreshBoxesboth() {
        // If user types some char in boxes then refresh boxes both above and below

        for (TextView i : textViewArrayAbove) {
            i.setText("");
        }
        for (int i = 0; i < currentQ.getRANDOMANS1().length(); i++) {
            textViewBelowFirst[i].setVisibility(View.VISIBLE);
            textViewBelowFirst[i].setText(currentQ.getRANDOMANS1().substring(i, i + 1).toUpperCase());
        }

        for (int i = 0; i < currentQ.getRANDOMANS2().length(); i++) {
            textViewBelowsecond[i].setVisibility(View.VISIBLE);
            textViewBelowsecond[i].setText(currentQ.getRANDOMANS2().substring(i, i + 1).toUpperCase());
        }
    }//end of refreshBoxesBoth

    public int returnQid() {
        int a = 100001;
        List abc = demoHelperClass.GetQid();
        if (abc != null) {
            for (int i = 0; i < abc.size(); i++) {
                a = (Integer) abc.get(i);
                if (a == qid) {
                    abc.clear();
                    break;
                }
            }
        }
        return a;
    }// This method returns qid of solved questions

    public int returnHint1Used() {
        int x = 100001;
        List xyz = demoHelperClass.getHint();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                x = (Integer) xyz.get(i);
                if (x == qid) {
                    xyz.clear();
                    break;
                }
            }
        }
        return x;
    } //This method returns qid of questions where hint1 is used


    public int returnBoomIdUsed() {
        int y = 1111110;
        List pqr = demoHelperClass.getBoomId();
        if (pqr != null) {
            for (int i = 0; i < pqr.size(); i++) {
                y = (Integer) pqr.get(i);
                if (y == qid) {
                    //break here
                    pqr.clear();
                    break;
                }
            }
        }
        return y;
    }//This method returns qid of questions where boom is used

    public void checkAchievementOne() {
        //1-24 total=24 (You got it till viewer)
        List xyz = demoHelperClass.GetQid();//solved questions ids
        List abc = demoHelperClass.getBoomId(); //question ids for which bomb is used
        List pqr = demoHelperClass.getHint();//question ids for which hint1 is used
        // List lmn = demoHelperClass.getGems();//no of gems in bucket at that moment


        //You got it solve any 3Q
        if (xyz.size() >= 3) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_you_got_it_));
        }

        //The beginner solve any 5Q
        if (xyz.size() >= 5) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_beginner));
        }
        //The Novice solve any 10Q
        if (xyz.size() >= 10) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_novice));
        }
        //The NewBie solve any 25Q
        if (xyz.size() >= 25) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_newbie));
        }
        //The blaster  use time-bomb-5 times
        if (abc.size() >= 5) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_blaster));
        }
        //Absolutely free use free hints for 10 times
        if (pqr.size() >= 10) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_absolutely_free));
        }
        //Reveal
       /*in side revealhole*/

        //undergraduate solve any 50 questions
        if (xyz.size() >= 50) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_undergraduate));
        }
        //Proficient solve any 60 questions
        if (xyz.size() >= 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_proficient));
        }
        //Scholar solve any 90 Q
        if (xyz.size() >= 90) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_scholar));
        }
        //101 not out solve any 101 Q
        if (xyz.size() >= 101) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_101_not_out));
        }
        //Nerd solve any 120 questions
        if (xyz.size() >= 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_nerd));
        }
        //Genius solve any 240 questions
        if (xyz.size() >= 240) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_genius));
        }
        //Intelligent solve any 360 Q
        if (xyz.size() >= 360) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_intelligent));
        }
        //wow solve any 404 Q
        if (xyz.size() >= 404) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_wow));
        }
        //The Expert solve any 500Q
        if (xyz.size() >= 500) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_expert));
        }
        //Mind blowing solve any 600Q
        if (xyz.size() >= 600) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_mind_blowing));
        }
        //First class solve any 700 Q
        if (xyz.size() >= 700) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_first_class));
        }
        //Impressive solve any 808Q
        if (xyz.size() >= 808) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_impressive));
        }
        //Talented solve any 900Q
        if (xyz.size() >= 900) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_talented));
        }
        //master mind solve any 1000Q
        if (xyz.size() >= 1000) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_master_mind));
        }
        //the topper solve any 1100Q
        if (xyz.size() >= 1100) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_topper));
        }
        //The winner 1120Q
        if (xyz.size() >= 1120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_winner));
        }

        //viewer
        /*inside onRewarded*/
        xyz.clear();
        abc.clear();
        pqr.clear();
    }

    public void checkAchievementTwo() {
        // 27-40  achievement total=14 (free-free-free till the hero)
        List<Integer> xyz = demoHelperClass.GetQid();//solved questions ids
        List abc = demoHelperClass.getBoomId(); //question ids for which bomb is used
        List pqr = demoHelperClass.getHint();//question ids for which hint1 is used

        //Free free free use at least 60 free hints
        if (pqr.size() >= 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_free_free_free));
        }
        //Boom boom use time-bomb 25 times
        if (abc.size() >= 25) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_boom_boom));
        }


        //personality
        ArrayList<Integer> perList = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 0 && xyz.get(i) < 180) {
                    perList.add(i);
                }
            }
        }
        //Ez pz lemon squeezy
        if (perList.size() == 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_ez_pz_lemon_squeezy));
        }
        //Alumni
        if (perList.size() == 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_alumni));
        }
        perList.clear();

        //sports
        ArrayList<Integer> sportlist = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 180 && xyz.get(i) < 360) {
                    sportlist.add(i);
                }
            }
        }

        //sports lover
        if (sportlist.size() == 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_sports_lover));
        }
        //Athlete
        if (sportlist.size() == 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_athlete));
        }
        sportlist.clear();


        //Geography
        ArrayList<Integer> geolist = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 360 && xyz.get(i) < 600) {
                    geolist.add(i);
                }
            }
        }
        //The explorer
        if (geolist.size() == 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_explorer));
        }
        //geologist
        if (geolist.size() == 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_geologist));
        }
        geolist.clear();


        //Science
        ArrayList<Integer> sciencelist = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 600 && xyz.get(i) < 780) {
                    sciencelist.add(i);
                }
            }
        }
        //Junior scientist
        if (sciencelist.size() >= 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_junior_scientist));
        }
        //senior scientist
        if (sciencelist.size() >= 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_senior_scientist));
        }
        sciencelist.clear();


        //arts
        ArrayList<Integer> artsList = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 780 && xyz.get(i) < 900) {
                    artsList.add(i);
                }
            }
        }
        //Art attack
        if (artsList.size() == 30) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_art_attack_));
        }
        //Artist
        if (artsList.size() == 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_artist));
        }
        artsList.clear();


        //entertainment
        ArrayList<Integer> entertainmentList = new ArrayList<>();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                if (xyz.get(i) >= 900 && xyz.get(i) < 1120) {
                    entertainmentList.add(i);
                }
            }
        }
        //e for entertainment
        if (entertainmentList.size() == 60) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_e_for_entertainment));
        }
        //The hero
        if (entertainmentList.size() == 120) {
            Games.Achievements.unlock(mGoogleApiClient, getResources().getString(R.string.achievement_the_hero));
        }
        entertainmentList.clear();

        abc.clear();
        pqr.clear();
        if (xyz != null) {
            xyz.clear();
        }

    }

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

}
