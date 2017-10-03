package sarveshchavan777.inrerface2.Activity;


import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
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
import sarveshchavan777.inrerface2.AnimationBounce.MyBounceInterpolator;
import sarveshchavan777.inrerface2.HolderActivities.ArtsSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.EntertainmentSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.GeoSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.MainActivity;
import sarveshchavan777.inrerface2.HolderActivities.ScienceSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.PersonalitySlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.SportsSlidingMain;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.db.DemoHelperClass;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;

public class MainGameActivity extends AppCompatActivity implements RewardedVideoAdListener {
    List<Questions> quesList;
    boolean clicked = false;
    ImageView  backButtonImage, leftImage, rightImage, FreeHint,
            master, hint2, gems, bomb, correctImage;
    ImageView cracker1, cracker2, cracker3, cracker4;
    DemoHelperClass demoHelperClass;
    Questions currentQ;
    int qid;
    TextView tvQ, tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20;
    TextView tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b;
    FButton tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29;
    FButton tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b;
    StringBuffer stringBuffer = new StringBuffer(10);
    StringBuffer stringBuffer2 = new StringBuffer(10);
    TextView textView, textView2, tvt, incorrect,
            queNum, diffLevel, solvedText, triviaKnowldegText;
    TextView gemsText;
    LinearLayout l1, l2;
    ArrayList list = new ArrayList();

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


    Typeface chunkfive, grobold, openSansBold, openSansSemiBold, shablagooital, titilliumWeb;
    Handler handler = new Handler();
    private static int ordinal = 1;
    final private UnityAdsListener unityAdsListener = new UnityAdsListener();
    AnimationDrawable frameAnimation;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Chartboost.startWithAppId(this, "593121b843150f14e9d9f526", "71b3e71b07e19f035092fdc411c461f217cb54df");
        Chartboost.onCreate(this);
        setContentView(sarveshchavan777.inrerface2.R.layout.a_maingame);
        //Type casting All
        incorrect = (TextView) findViewById(R.id.incorrect);
        incorrect.setVisibility(View.INVISIBLE);
        tvQ = (TextView) findViewById(R.id.textQuestion);
        tvt = (TextView) findViewById(R.id.textviewpersonality);
        backButtonImage = (ImageView) findViewById(R.id.leftpersonality);
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
        FreeHint = (ImageView) findViewById(R.id.hint);
        FreeHint.setVisibility(View.VISIBLE);
        gemsText = (TextView) findViewById(R.id.diamondtext);
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
        demoHelperClass = new DemoHelperClass(getApplicationContext());



        // Initialize the Google Mobile Ads SDK
        MobileAds.initialize(this, getString(R.string.Test_admob_app_id));


        //Your code to show add
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        //Mediation ads
        final MediationMetaData mediationMetaData = new MediationMetaData(getApplicationContext());
        mediationMetaData.setName("Example mediation network");
        mediationMetaData.setVersion("1.2.3");
        mediationMetaData.commit();

        UnityAds.initialize(this, getString(R.string.gameId), unityAdsListener);


        // RewardedVideoAd=Get reference to singleton RewardedVideoAd object
        mAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
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

        //array is created here so that it will pass the value of this array to the global varable array so it can be used in other methods

        TextView textViewArrayAbove2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        TextView textfirst2[] = {tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20};
        TextView textsecound2[] = {tv11b, tv12b, tv13b, tv14b, tv15b, tv16b, tv17b, tv18b, tv19b, tv20b};
        FButton textViewArrayBelow2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};
        FButton textViewBelowFirst2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29};
        FButton textViewBelowsecond2[] = {tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};


        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i] = textViewArrayAbove2[i];
        }

        for (int i = 0; i < 10; i++) {
            textfirst[i] = textfirst2[i];
            textsecound[i] = textsecound2[i];
        }

        for (int i = 0; i < 18; i++) {
            textViewArrayBelow[i] = textViewArrayBelow2[i];
        }
        for (int i = 0; i < 9; i++) {
            textViewBelowFirst[i] = textViewBelowFirst2[i];
            textViewBelowsecond[i] = textViewBelowsecond2[i];
        }

        textViewArrayAbove2 = null;
        textViewArrayBelow2 = null;
        textfirst2 = null;
        textsecound2 = null;
        textViewBelowFirst2 = null;
        textViewBelowsecond2 = null;

        demoHelperClass.getWritableDatabase();

        //Add the questions in the table if not added
        List checkQuestionAdded = demoHelperClass.getCheckQadded();
        if(checkQuestionAdded.size() == 0){
            Toast.makeText(getApplicationContext(),"called",Toast.LENGTH_LONG);
            demoHelperClass.addquestions();
            demoHelperClass.insertCheckQadded(1);
        }


        //It will give the question no as per users click from previous activity
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


        //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
        //and also hide above and below boxes
        questionSolved();

        //This will set The Text of question and also setText for below boxes as per que no
        //and also manage spacing between boxes as per the size of the device
        viewData();

        //If id is 0 then left image is invisible
        if (qid == 0) {
            leftImage.setVisibility(View.INVISIBLE);
        }

        //If question is not solved and FreeHint(Hint1) is used then set the
        // random letters in ans boxes and remove from below
        if (returnQid() != qid) {
            if (returnFreeHintUsed() == qid) {

                //If FreeHint(Hint1) is used then make it invisible
                FreeHint.setVisibility(View.INVISIBLE);

                //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
                //fillingBoxes has method checkIfHintIsUsed
                fillingBoxes();
            }
        }

        //If question is not solved check if boom is used if used then boom is invisible and boomMethod is called
        //check if qid is solved if yes then don't call boomMethod
        if (returnQid() != qid) {
                if (returnBoomIdUsed() == qid) {
                    bomb.setVisibility(View.INVISIBLE);
                    boomMethod();
                }
        }


        //If question has solved setting the answer text
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

        //It will set The color of toolbar,queNoText and
        //also the set text on toolbar of the category (i.e sports,a_maingame etc)
        xmlColor();

        //It gives animation for each question
        allAnimation();

        //It will set The text of number of gems available
        setNoOfGemsText();

        //It will make left right visible or unvisible as per required
        visiblityOfrightleft();

        //It will set The text that the que is easy or hard or medium.
        //It will also set The color of the below boxes,bootstrap bar and left and right arrow
        diffLevel();

        //It will set The text of number of que solved
        setNoOfSolvedQueText();

        //If boxes less than or equal to 3 then FreeHint invisible
        if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
            //  hint1.setVisibility(View.INVISIBLE);
            FreeHint.setImageResource(R.drawable.noidea1cartoon);
        } else {
            FreeHint.setImageResource(R.drawable.idea1cartoon);
        }





        //type faces--
        // final Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Semibold.ttf");
        shablagooital = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        titilliumWeb = Typeface.createFromAsset(getAssets(), "fonts/TitilliumWeb-Bold.ttf");
        chunkfive = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
        grobold = Typeface.createFromAsset(getAssets(), "fonts/grobold.ttf");
        openSansSemiBold = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Semibold.ttf");
        openSansBold = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");

        //Question text
        tvQ.setTypeface(openSansBold);

        //Text on toolbar (i.e category text name)
        tvt.setTypeface(shablagooital);

        //No of gems text
        gemsText.setTypeface(titilliumWeb);

        //incorrect text (animated when ans is incorrect)
        incorrect.setTypeface(shablagooital);

        //Above boxes
        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].setTypeface(titilliumWeb);
        }

        //Below boxes
        for (int i = 0; i < 18; i++) {
            textViewArrayBelow[i].setTypeface(chunkfive);
        }

        //Question no text
        queNum.setTypeface(grobold);

        //difficulty level - easy,medium,hard text
        diffLevel.setTypeface(shablagooital);

        //No of solved question text
        solvedText.setTypeface(titilliumWeb);

        //Tk text at bottom on bootstrap progressbar
        triviaKnowldegText.setTypeface(shablagooital);


        //onClick listener for backbutton
        backButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                /* Obtain String from Intent  */
                if (intent != null) {
                    String clicked = intent.getStringExtra("Key");

                    for (int i = 0; i < 180; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), PersonalitySlidingMain.class);
                            if (i < 60) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 60 && i < 120) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 120 && i < 180) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 180; i < 360; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), SportsSlidingMain.class);
                            if (i < 240) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 240 && i < 300) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 300 && i < 360) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 360; i < 600; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), GeoSlidingMain.class);

                            if (i < 440) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 440 && i < 520) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 520 && i < 600) {
                                intent2.putExtra("TabNo", 2);
                            }

                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 600; i < 780; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), ScienceSlidingMain.class);
                            if (i < 660) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 660 && i < 720) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 720 && i < 780) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 780; i < 900; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), ArtsSlidingMain.class);

                            if (i < 820) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 820 && i < 860) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 860 && i < 900) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                    for (int i = 900; i < 1120; i++) {
                        if (clicked.equals(Integer.toString(i))) {
                            Intent intent2 = new Intent(getApplicationContext(), EntertainmentSlidingMain.class);
                            if (i < 980) {
                                intent2.putExtra("TabNo", 0);
                            }
                            if (i >= 980 && i < 1060) {
                                intent2.putExtra("TabNo", 1);
                            }
                            if (i >= 1060 && i < 1120) {
                                intent2.putExtra("TabNo", 2);
                            }
                            startActivity(intent2);
                            finish();
                        }
                    }
                }

            }

        });


        //Free hint
        FreeHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainGameActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                if (dialog.getWindow() != null) {
                    ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                    dialog.getWindow().setBackgroundDrawable(colorDrawable);
                }
                dialog.setContentView(R.layout.dialog_freehint);
                dialog.setCancelable(true);

                TextView freehintdialog = (TextView) dialog.findViewById(R.id.freehinttext);
                TextView reavel1 = (TextView) dialog.findViewById(R.id.reavel1);
                TextView reavel11 = (TextView) dialog.findViewById(R.id.reavel11);
                //Setting typefaces
                freehintdialog.setTypeface(shablagooital);
                reavel1.setTypeface(shablagooital);
                reavel11.setTypeface(shablagooital);

                dialog.show();

                //dialog cancel button
                Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
                cancelButton.setTypeface(shablagooital);
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                //Dialog okButton
                Button okButton = (Button) dialog.findViewById(R.id.ok);
                okButton.setTypeface(shablagooital);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String ansOneAnsTwo = currentQ.getANSWER() + currentQ.getANSWER2();
                        Integer ansLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();

                        //If dialog_bomb has been used for the qid then don't do reqular hint1
                        //If current question is not solved and answer boxes is greater than 3 then only hint1 is visible and can use.

                        //FreeHint without boom
                        if (returnBoomIdUsed() != qid) {
                            if (returnQid() != qid && returnFreeHintUsed() != qid && currentQ.getANSWER().length() + currentQ.getANSWER2().length() > 3) {

                                //id of the question for which hint is used is stored in table
                                demoHelperClass.insertHint(qid);

                                //numberList is a ArrayList which will store random generated numbers
                                ArrayList<Integer> numbersList = new ArrayList<>();
                                Random randomGenerator = new Random();

                                //If answer length is greater than 5 then 5 random number will be stored in arraylist-numbersList
                                if (ansLength > 5) {
                                    while (numbersList.size() < 5) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater than 4 but less then 5 ie. 5 then 2 random number will be stored in arraylist-numbersList
                                else if (ansLength > 4) {
                                    while (numbersList.size() < 2) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater than 3 but less then 4 ie 3 then 1 random number will be stored in arraylist-numbersList
                                else if (ansLength > 3) {
                                    while (numbersList.size() < 1) {
                                        int random = randomGenerator.nextInt(ansLength - 1) + 1;
                                        if (!numbersList.contains(random)) {
                                            numbersList.add(random);
                                        }
                                    }
                                }

                                //If answer length is greater then five then we gonna store 5 random no. generated in table
                                if (ansLength > 5) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), numbersList.get(1), numbersList.get(2), numbersList.get(3), numbersList.get(4));
                                }
                                //If answer length exactly 5 then we gonna store 2 random no. generated in table and rest of them will be zero
                                else if (ansLength > 4) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), numbersList.get(1), 0, 0, 0);
                                }
                                //If answer length exactly 4 then we gonna store 1 random no. generated in table and rest of them will be zero
                                else if (ansLength > 3) {
                                    demoHelperClass.insertRandomNumbers(qid, numbersList.get(0), 0, 0, 0, 0);
                                }


                                //the alphabet of the random number are store int the string
                                String randomCharOne = "", randomeCharTwo = "", randomeCharThree = "", randomeCharFour = "", randomeCharFive = "";

                                //Now we gonna store the characters at that random no in the string
                                if (ansLength > 3) {
                                    randomCharOne = Character.toString(ansOneAnsTwo.charAt(numbersList.get(0))).toUpperCase();
                                }
                                if (ansLength > 4) {
                                    randomeCharTwo = Character.toString(ansOneAnsTwo.charAt(numbersList.get(1))).toUpperCase();
                                }
                                if (ansLength > 5) {
                                    randomeCharThree = Character.toString(ansOneAnsTwo.charAt(numbersList.get(2))).toUpperCase();
                                }
                                if (ansLength > 8) {
                                    randomeCharFour = Character.toString(ansOneAnsTwo.charAt(numbersList.get(3))).toUpperCase();
                                }
                                if (ansLength > 12) {
                                    randomeCharFive = Character.toString(ansOneAnsTwo.charAt(numbersList.get(4))).toUpperCase();
                                }


                                //This list store the postion of visisble boxes of above
                                int ansOneLnegth = currentQ.getANSWER().length();
                                int ansTwoLength = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();


                                for (int i = 0; i < ansOneLnegth; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < ansTwoLength; j++) {
                                    arrayList.add(j + 10);
                                }

                                //before setting the above boxes text remove text if user has enter the text i.e refresh
                                refreshBoxesboth();


                                //setting the random char for the above boxes
                                if (ansLength > 3) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(0))].setText(randomCharOne);
                                }
                                if (ansLength > 4) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(1))].setText(randomeCharTwo);
                                }
                                if (ansLength > 5) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(2))].setText(randomeCharThree);
                                }
                                if (ansLength > 6) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(3))].setText(randomeCharFour);
                                }
                                if (ansLength > 7) {
                                    textViewArrayAbove[arrayList.get(numbersList.get(4))].setText(randomeCharFive);
                                }
                                arrayList.clear();
                                numbersList.clear();


                                //now removing below boxes which has same character(alphabets) that are random generated
                                //1st
                                if (ansLength > 3) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomCharOne)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //2nd
                                if (ansLength > 4) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharTwo)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }
                                //3rd
                                if (ansLength > 5) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharThree)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }

                                //4th
                                if (ansLength > 8) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharFour)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }


                                //5th
                                if (ansLength > 12) {
                                    for (TextView i : textViewArrayBelow) {
                                        if (i.getVisibility() == View.VISIBLE) {
                                            if (i.getText().toString().equalsIgnoreCase(randomeCharFive)) {
                                                i.setText("");
                                                i.setVisibility(View.INVISIBLE);
                                                break;
                                            }
                                        }
                                    }
                                }

                                if (ansLength > 3) {
                                    FreeHint.setVisibility(View.INVISIBLE);
                                }
                                if (ansLength <= 3) {
                                    //  Toast.makeText(MainGameActivity.this, "Free hint not available for less than 4 ", Toast.LENGTH_LONG).show();
                                    Toast toast = Toast.makeText(getApplicationContext(), "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                                    v.setTypeface(shablagooital);
                                    v.setTextSize(12);
                                    toast.show();
                                }
                            }

                        }

                        //FreeHint with boom (i.e boom is already used before freehint)
                        if (returnQid() != qid && returnFreeHintUsed() != qid) {
                            if (returnBoomIdUsed() == qid) {

                                //if users types in some thin this will clear it off
                                refreshBoxesboth();

                                //store the qid for which freehint is used
                                demoHelperClass.insertHint(qid);

                                //Now in this case there will be no random no but instead manual number
                                //If ans length is greater then five we will store first five numbers in table
                                if (ansLength > 5) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 1, 2, 3, 4);
                                }
                                //If ans length is exactly five we will store first two numbers in table and rest of them as zero
                                else if (ansLength > 4) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 1, 0, 0, 0);
                                }
                                //If ans length is exactly four we will store first one numbers in table and rest of them as zero
                                // in this case 0 is the first manual no and rest of them zero so total five zero
                                else if (ansLength > 3) {
                                    demoHelperClass.insertRandomNumbers(qid, 0, 0, 0, 0, 0);
                                }


                                //this list store the position of visible boxes of above
                                int ansOneLength = currentQ.getANSWER().length();
                                int ansTwoLength = currentQ.getANSWER2().length();
                                ArrayList<Integer> arrayList = new ArrayList<>();

                                for (int i = 0; i < ansOneLength; i++) {
                                    arrayList.add(i);
                                }
                                for (int j = 0; j < ansTwoLength; j++) {
                                    arrayList.add(j + 10);
                                }


                                //setting the text of above boxes
                                if (ansLength > 3) {

                                    textViewArrayAbove[arrayList.get(0)].setText(ansOneAnsTwo.substring(0, 1).toUpperCase());
                                }
                                if (ansLength > 4) {

                                    textViewArrayAbove[arrayList.get(1)].setText(ansOneAnsTwo.substring(1, 2).toUpperCase());
                                }
                                if (ansLength > 5) {

                                    textViewArrayAbove[arrayList.get(2)].setText(ansOneAnsTwo.substring(2, 3).toUpperCase());
                                }
                                if (ansLength > 8) {

                                    textViewArrayAbove[arrayList.get(3)].setText(ansOneAnsTwo.substring(3, 4).toUpperCase());
                                }
                                if (ansLength > 12) {

                                    textViewArrayAbove[arrayList.get(4)].setText(ansOneAnsTwo.substring(4, 5).toUpperCase());

                                }
                                arrayList.clear();


                                //now removing the below boxes
                                if (ansLength >= 4) {
                                    String char1 = ansOneAnsTwo.substring(0, 1);
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
                                if (ansLength >= 5) {
                                    String char1 = ansOneAnsTwo.substring(1, 2);
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
                                if (ansLength >= 6) {
                                    String char1 = ansOneAnsTwo.substring(2, 3);
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
                                if (ansLength >= 9) {
                                    String char1 = ansOneAnsTwo.substring(3, 4);
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
                                if (ansLength >= 13) {
                                    String char1 = ansOneAnsTwo.substring(4, 5);
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

                            if (ansLength > 3) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }
                            if (ansLength <= 3) {
                                // Toast.makeText(MainGameActivity.this, "Free hint not available for less than 4 boxes", Toast.LENGTH_LONG).show();

                                Toast toast = Toast.makeText(getApplicationContext(), "\tFree hint not available for less than 4 boxes" + " ", Toast.LENGTH_LONG);
                                toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                                v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                                v.setTypeface(shablagooital);
                                v.setTextSize(12);
                                toast.show();
                            }
                        }


                        //If dialog_sound is on then play it first and then dismiss dialog else directly dismiss it
                        //to avoid memory loss
                        if (checkSound()) {
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                            if (mediaPlayer != null) {
                                mediaPlayer.start();
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayer.reset();
                                        mediaPlayer.release();
                                        dialog.dismiss();
                                    }
                                });
                            }

                        } else {
                            dialog.dismiss();
                        }
                    }
                });

            }

        });//Hint1 getover here

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
    }

    //Animation of cracking(Blasting) i.e when boomHint is pressed
    public void crackerAnimation() {

        cracker1.setVisibility(View.VISIBLE);
        cracker2.setVisibility(View.VISIBLE);
        cracker3.setVisibility(View.VISIBLE);
        cracker4.setVisibility(View.VISIBLE);

        cracker1.setBackgroundResource(R.drawable.blastanimation);
        cracker2.setBackgroundResource(R.drawable.blastanimation2);
        cracker3.setBackgroundResource(R.drawable.blastanimation);
        cracker4.setBackgroundResource(R.drawable.blastanimation2);

        frameAnimation = (AnimationDrawable) cracker1.getBackground();
        frameAnimation.start();

        frameAnimation = (AnimationDrawable) cracker2.getBackground();
        frameAnimation.start();

        frameAnimation = (AnimationDrawable) cracker3.getBackground();
        frameAnimation.start();

        frameAnimation = (AnimationDrawable) cracker4.getBackground();
        frameAnimation.start();

        Handler handler1 = new Handler();
        Runnable runnable = new Runnable() {

            public void run() {
                /*cracker1.setVisibility(View.VISIBLE);
                //for interval...*/
                cracker1.setVisibility(View.INVISIBLE);
                cracker3.setVisibility(View.INVISIBLE);

            }
        };
        handler1.postDelayed(runnable, 500);

        Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {

            public void run() {
                cracker2.setVisibility(View.INVISIBLE);
                cracker4.setVisibility(View.INVISIBLE);


            }
        };
        handler2.postDelayed(runnable2, 650);
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


    //This will check the answer is correct or not after filling all the boxes
    //If yes then it will bring a dialog of correct and after pressing next button it will move to next que
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

                    //setting the text for number of correct question solved
                    setNoOfSolvedQueText();


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

                    //set up dialog
                    final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_correctans);
                    dialog.setCancelable(false);


                    //there are a lot of settings, for dialog, check them all out!
                    //set up text
                    TextView correct = (TextView) dialog.findViewById(R.id.correct);
                    correct.setTypeface(shablagooital);

                    //Native ads
                    NativeExpressAdView adViewNativeads = (NativeExpressAdView) dialog.findViewById(R.id.adViewNativeads);
                    AdRequest request = new AdRequest.Builder().build();
                    adViewNativeads.loadAd(request);


                    //Animation
                    String stringanswer = currentQ.getANSWER() + " " + currentQ.getANSWER2();
                    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                    //Use bounce interpolator with amplitude 0.2 and frequency 20
                    MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 70);
                    myAnim.setInterpolator(interpolator);
                    correct.startAnimation(myAnim);
                    TextView answerorrect = (TextView) dialog.findViewById(R.id.answercorrect);
                    answerorrect.setTypeface(chunkfive);
                    answerorrect.setText(stringanswer.toUpperCase());

                    //Incrementing the question no
                    qid = qid + 1;
                    currentQ = quesList.get(qid);

                    //set up button (Next Button)
                    Button nextbutton = (Button) dialog.findViewById(R.id.Button01);
                    nextbutton.setTypeface(chunkfive);
                    nextbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            master.setVisibility(View.INVISIBLE);

                            allAnimation();

                            //This will set The Text of question and also setText for below boxes as per que no
                            //and also manage spacing between boxes as per the size of the device
                            viewData();

                            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
                            //and also hide above and below boxes
                            questionSolved();

                            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
                            //fillingBoxes has method checkIfHintIsUsed
                            fillingBoxes();

                            queNum.setText(String.valueOf(qid + 1));

                            //If we reach the end of the questions of particular category then it will
                            //handle the left & right visibility of arrow
                            visiblityOfrightleft();

                            //It will set The text that the que is easy or hard or medium.
                            //It will also set The color of the below boxes,bootstrap bar and left and right arrow
                            diffLevel();


                            //if the answer boxes are greater than three then also hint1 invisible
                            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }

                            clicked = false;

                            //if question hint is already used then hint invisible
                            if (returnFreeHintUsed() == qid) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }
                            //else is very imp
                            else {
                                FreeHint.setVisibility(View.VISIBLE);
                            }

                            //if question is solved then hint1 invisible
                            if (returnQid() == qid) {
                                FreeHint.setVisibility(View.INVISIBLE);
                            }


                            //check if boom is used if used then boom is invisible
                            //and call dialog_bomb method
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
                                FreeHint.setImageResource(R.drawable.noidea1cartoon);
                            } else {
                                FreeHint.setImageResource(R.drawable.idea1cartoon);
                            }

                            dialog.cancel();

                        }
                    });

                    dialog.show();
                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);


                    //If dialog_sound is on then play it
                    if (checkSound()) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.victory);
                        if (mediaPlayer != null) {
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

                //@@ 7 - This are all edge cases where the que no is last in it's category
                else if (qid == 1119 || qid == 179 || qid == 359 || qid == 599 || qid == 779 || qid == 899) {

                    //Toast msg that ans is correct
                    Toast toast = Toast.makeText(getApplicationContext(), "\tcorrect \t", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.transparent2));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgreen2));
                    v.setTypeface(shablagooital);
                    v.setTextSize(20);
                    toast.show();

                    stringBuffer.setLength(0);
                    stringBuffer2.setLength(0);

                    //Inserting the id of solved que in table
                    demoHelperClass.InsertQid(qid);


                    //No increment of que since it is last question in it's category
                    currentQ = quesList.get(qid);

                    //This will set The Text of question and also setText for below boxes as per que no
                    //and also manage spacing between boxes as per the size of the device
                    viewData();

                    //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
                    //and also hide above and below boxes or else visa versa
                    questionSolved();

                    FreeHint.setVisibility(View.INVISIBLE);

                    //setting text of number of correct question solved
                    setNoOfSolvedQueText();

                    clicked = false;
                }
            } else {
                //Animation of incorrect if wrong answer
                incorrectAnimation();
                stringBuffer.setLength(0);
                stringBuffer2.setLength(0);
            }
        }
    }//end of check


    //Animation of incorrect if wrong answer
    public void incorrectAnimation() {
        incorrect.setVisibility(View.VISIBLE);
        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //Use bounce interpolator with amplitude 0.2 and frequency 20
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
    }

    //This will set The Text of question and also setText for below boxes as per que no
    //and also manage spacing between boxes as per the size of the device
    public void viewData() {

        //Set the question
        tvQ.setText(currentQ.getQUESTION());
        //tvQ.setTypeface(openSansBold);

        List idOfSlovedQuestions = demoHelperClass.GetQid();
        if (idOfSlovedQuestions != null) {
            for (int i = 0; i < idOfSlovedQuestions.size(); i++) {
                int id = (Integer) idOfSlovedQuestions.get(i);

                //This will check that question  is solved or not
                if (id == qid) {
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
                        // Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
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

                comman3();

            }
        }
        if (idOfSlovedQuestions != null) {
            if (idOfSlovedQuestions.size() == 0) {
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

        //Toast.makeText(MainGameActivity.this, "width=" + Integer.toString(width1), Toast.LENGTH_LONG).show();
        // Toast.makeText(MainGameActivity.this, "height=" + Integer.toString(height1), Toast.LENGTH_LONG).show();

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
                    //  Toast.makeText(MainGameActivity.this, "Normal -less", Toast.LENGTH_LONG).show();
                } else {
                    height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics());
                    params = new LinearLayout.LayoutParams(
                            weidth, height);
                    params.setMargins(3, 3, 3, 3);
                    tvQ.setTextSize(14);
                    //   Toast.makeText(MainGameActivity.this, "NORMAL", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            //   Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
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
                //    Toast.makeText(MainGameActivity.this, "large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(27);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
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
                //  Toast.makeText(MainGameActivity.this, "x-large", Toast.LENGTH_LONG).show();
                for (TextView i : textViewArrayAbove) {
                    i.setTextSize(27);
                }
                for (TextView i : textViewArrayBelow) {
                    i.setTextSize(30);
                }
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

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

    }//end of viewData


    private void comman3() {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        int weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        try {
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, getResources().getDisplayMetrics());
                //   Toast.makeText(MainGameActivity.this,"called yo yo",Toast.LENGTH_LONG).show();
            }

            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                weidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 37, getResources().getDisplayMetrics());
                //   Toast.makeText(MainGameActivity.this,"called yo yo",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            //  Toast.makeText(MainGameActivity.this,"Failed to get size of device",Toast.LENGTH_LONG).show();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                weidth, height);
        params.setMargins(1, 1, 1, 1);

        for (int i = 0; i < 20; i++) {
            textViewArrayAbove[i].setText("");
            textViewArrayAbove[i].setLayoutParams(params);
        }
    }

    //onclick listener for aboveboxes if clicked below boxes visible
    public void onClickForAboveBoxes() {

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

    //onclick listener for belowboxes if clicked above boxes visible
    public void onClickForBelowBoxes() {

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
    //onclick listener for above boxes text11-text20
    public void text11(View view) {
        textView = tv11;
        onClickForAboveBoxes();
    }

    public void text12(View view) {
        textView = tv12;
        onClickForAboveBoxes();
    }

    public void text13(View view) {
        textView = tv13;
        onClickForAboveBoxes();
    }

    public void text14(View view) {
        textView = tv14;
        onClickForAboveBoxes();
    }

    public void text15(View view) {
        textView = tv15;
        onClickForAboveBoxes();
    }

    public void text16(View view) {
        textView = tv16;
        onClickForAboveBoxes();
    }

    public void text17(View view) {
        textView = tv17;
        onClickForAboveBoxes();
    }

    public void text18(View view) {
        textView = tv18;
        onClickForAboveBoxes();
    }

    public void text19(View view) {
        textView = tv19;
        onClickForAboveBoxes();
    }

    public void text20(View view) {
        textView = tv20;
        onClickForAboveBoxes();
    }

    //This are onclick listener for below boxes 11b - 29b
    public void text11b(View view) {
        textView = tv11b;
        onClickForAboveBoxes();

    }

    public void text12b(View view) {
        textView = tv12b;
        onClickForAboveBoxes();

    }

    public void text13b(View view) {
        textView = tv13b;
        onClickForAboveBoxes();

    }

    public void text14b(View view) {
        textView = tv14b;
        onClickForAboveBoxes();

    }

    public void text15b(View view) {
        textView = tv15b;
        onClickForAboveBoxes();

    }

    public void text16b(View view) {
        textView = tv16b;
        onClickForAboveBoxes();

    }

    public void text17b(View view) {
        textView = tv17b;
        onClickForAboveBoxes();

    }

    public void text18b(View view) {
        textView = tv18b;
        onClickForAboveBoxes();

    }

    public void text19b(View view) {
        textView = tv19b;
        onClickForAboveBoxes();

    }

    public void text20b(View view) {
        textView = tv20b;
        onClickForAboveBoxes();

    }

    public void text21(View view) {
        textView2 = tv21;
        onClickForBelowBoxes();
        sound();
    }

    public void text22(View view) {
        textView2 = tv22;
        onClickForBelowBoxes();
        sound();
    }

    public void text23(View view) {
        textView2 = tv23;
        onClickForBelowBoxes();
        sound();
    }

    public void text24(View view) {
        textView2 = tv24;
        onClickForBelowBoxes();
        sound();
    }

    public void text25(View view) {
        textView2 = tv25;
        onClickForBelowBoxes();
        sound();
    }

    public void text26(View view) {
        textView2 = tv26;
        onClickForBelowBoxes();
        sound();
    }

    public void text27(View view) {
        textView2 = tv27;
        onClickForBelowBoxes();
        sound();
    }

    public void text28(View view) {
        textView2 = tv28;
        onClickForBelowBoxes();
        sound();
    }

    public void text29(View view) {
        textView2 = tv29;
        onClickForBelowBoxes();
        sound();
    }

    public void text21b(View view) {
        textView2 = tv21b;
        onClickForBelowBoxes();
        sound();

    }

    public void text22b(View view) {
        textView2 = tv22b;
        onClickForBelowBoxes();
        sound();
    }

    public void text23b(View view) {
        textView2 = tv23b;
        onClickForBelowBoxes();
        sound();

    }

    public void text24b(View view) {
        textView2 = tv24b;
        onClickForBelowBoxes();
        sound();
    }

    public void text25b(View view) {
        textView2 = tv25b;
        onClickForBelowBoxes();
        sound();
    }

    public void text26b(View view) {
        textView2 = tv26b;
        onClickForBelowBoxes();
        sound();
    }

    public void text27b(View view) {
        textView2 = tv27b;
        onClickForBelowBoxes();
        sound();
    }

    public void text28b(View view) {
        textView2 = tv28b;
        onClickForBelowBoxes();
        sound();

    }

    public void text29b(View view) {
        textView2 = tv29b;
        onClickForBelowBoxes();
        sound();
    }



    //Previous question left arrow click
    public void left(View view) {
        // myNum = Integer.parseInt(myString.getText().toString());
        if (qid >= 1 && qid != 180 && qid != 360 && qid != 600 && qid != 780 && qid != 900) {
            master.setVisibility(View.INVISIBLE);
            qid--;


            //@@ 12
            if (qid < 1119) {
                rightImage.setVisibility(View.VISIBLE);
            }

            //IF question is not solved then it will show hints(FreeHint,boom,dialog_reveal)
            //and also show above and below boxes
            questionNotSolved();

            //This will set The Text of question and also setText for below boxes as per que no
            //and also manage spacing between boxes as per the size of the device
            viewData();

            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
            //and also hide above and below boxes or else visa versa
            questionSolved();

            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
            //fillingBoxes has method checkIfHintIsUsed
            fillingBoxes();

            //It gives animation for each que
            allAnimation();

            //If we reach the end of the questions of particular category then it will
            //handle the left & right visibility of arrow
            visiblityOfrightleft();

            diffLevel();

            //It will set The text of number of que solved
            setNoOfSolvedQueText();

            //It will set The text of number of gems available
            setNoOfGemsText();

            //If FreeHint is used then FreeHint invisible
            if (returnFreeHintUsed() == qid) {
                FreeHint.setVisibility(View.INVISIBLE);
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

            // if boxes less than or eual to 3 then FreeHint invisible
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                FreeHint.setImageResource(R.drawable.noidea1cartoon);
            } else {
                FreeHint.setImageResource(R.drawable.idea1cartoon);
            }

        }

    }


    //Next question right arrow clicked
    public void right(View view) {
        if (qid >= 0 && qid != 179 && qid != 359 && qid != 599 && qid != 779 && qid != 899 && qid != 1119) {
            master.setVisibility(View.INVISIBLE);
            qid++;

            //this is for left and right images visibility and invisibility
            if (qid > 0) {
                leftImage.setVisibility(View.VISIBLE);
            }

            //IF question is not solved then it will show hints(FreeHint,boom,dialog_reveal)
            //and also show above and below boxes
            questionNotSolved();

            //This will set The Text of question and also setText for below boxes as per que no
            //and also manage spacing between boxes as per the size of the device
            viewData();

            //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
            //and also hide above and below boxes
            questionSolved();

            //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
            //fillingBoxes has method checkIfHintIsUsed
            fillingBoxes();

            //It gives animation for each que
            allAnimation();

            //If we reach the end of the questions of particular category then it will
            //handle the left & right visibility of arrow
            visiblityOfrightleft();

            //it will set the the text easy,medium or hard as per req
            diffLevel();

            //It will set The text of number of que solved
            setNoOfSolvedQueText();

            //It will set The text of number of gems available
            setNoOfGemsText();

            //If FreeHint is used then FreeHint invisible
            if (returnFreeHintUsed() == qid) {
                FreeHint.setVisibility(View.INVISIBLE);
            }

            //check if boom is used after click right
            //if used then call boomMethod and boam is invisible
            //and if the qid is solved don't call boomMethod
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

            //if boxes less than or equal to 3 then FreeHint invisible
            if (currentQ.getANSWER().length() + currentQ.getANSWER2().length() <= 3) {
                FreeHint.setImageResource(R.drawable.noidea1cartoon);
            } else {
                FreeHint.setImageResource(R.drawable.idea1cartoon);
            }

        }
    }

    //It will check if question is solved then it won't show hints(FreeHint,boom,dialog_reveal)
    //and also hide above and below boxes or else visa versa
    public void questionSolved() {
        if (returnQid() == qid) {
            hint2.setVisibility(View.INVISIBLE);
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            FreeHint.setVisibility(View.INVISIBLE);
            bomb.setVisibility(View.INVISIBLE);
            correctImage.setVisibility(View.VISIBLE);
        }
    }

    public void questionNotSolved(){
        currentQ = quesList.get(qid);
        FreeHint.setVisibility(View.VISIBLE);
        hint2.setVisibility(View.VISIBLE);
        bomb.setVisibility(View.VISIBLE);
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
        correctImage.setVisibility(View.INVISIBLE);
    }




    //This method checks if the FreeHint is used if yes then it will set the text of some of the boxes
    //if boxes=4 hint=1, boxes=5 hint=2, boxes=6-8 hint=3, boxes=9-12 hint=4, boxes=12-18 hint=5
    public void checkIfFreeHintIsUsed() {

        String storebothanswer = currentQ.getANSWER() + currentQ.getANSWER2();
        Integer hintLength = currentQ.getANSWER().length() + currentQ.getANSWER2().length();

        List<sarveshchavan777.inrerface2.Activity.FreeHint> freeHintsRandomNo = demoHelperClass.getRandomNumbers();

        if (freeHintsRandomNo != null) {
            for (int i = 0; i < freeHintsRandomNo.size(); i++) {

                if (freeHintsRandomNo.get(i).getFreeHintUsedId() == qid) {

                    FreeHint freeHint = freeHintsRandomNo.get(i);

                    StringBuilder stringBuffer = new StringBuilder();
                    if (hintLength > 3) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoOne()));
                    }
                    if (hintLength > 4) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoTwo()));
                    }
                    if (hintLength > 5) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoThree()));
                    }
                    if (hintLength > 8) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoFour()));
                    }
                    if (hintLength > 12) {
                        stringBuffer.append(storebothanswer.charAt(freeHint.getRandomNoFive()));
                    }


                    //this list store the postion of visisble boxes of above
                    int ansOneLength = currentQ.getANSWER().length();
                    int ansTwoLength = currentQ.getANSWER2().length();
                    ArrayList<Integer> arrayList = new ArrayList<>();


                    for (int k = 0; k < ansOneLength; k++) {
                        arrayList.add(k);
                    }
                    for (int j = 0; j < ansTwoLength; j++) {
                        arrayList.add(j + 10);
                    }

                    //before setting text of above boxes clear all above and below boxes that is refresh
                    refreshBoxesboth();

                    //setting the text for the above boxes
                    if (hintLength > 3) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoOne())].setText(stringBuffer.substring(0, 1).toUpperCase());
                    }
                    if (hintLength > 4) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoTwo())].setText(stringBuffer.substring(1, 2).toUpperCase());
                    }
                    if (hintLength > 5) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoThree())].setText(stringBuffer.substring(2, 3).toUpperCase());
                    }
                    if (hintLength > 8) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoFour())].setText(stringBuffer.substring(3, 4).toUpperCase());
                    }
                    if (hintLength > 12) {
                        textViewArrayAbove[arrayList.get(freeHint.getRandomNoFive())].setText(stringBuffer.substring(4, 5).toUpperCase());
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
        //freeHintsRandomNo.clear();
    }

    //this method checks if the FreeHint(hint1) is used if yes then it will set the text of some of the boxes
    //fillingBoxes has method checkIfHintIsUsed
    public void fillingBoxes() {
        checkIfFreeHintIsUsed();
    }

    //It will handle the backPress and will return to the tab from where the question was clicked
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = getIntent();
        /* Obtain String from Intent  */
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            for (int i = 0; i < 180; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), PersonalitySlidingMain.class);
                    if (i < 60) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 60 && i < 120) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 120 && i < 180) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 180; i < 360; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), SportsSlidingMain.class);
                    if (i < 240) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 240 && i < 300) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 300 && i < 360) {
                        intent2.putExtra("TabNo", 2);
                    }

                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 360; i < 600; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), GeoSlidingMain.class);
                    if (i < 440) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 440 && i < 520) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 520 && i < 600) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 600; i < 780; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), ScienceSlidingMain.class);
                    if (i < 660) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 660 && i < 720) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 720 && i < 780) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 780; i < 900; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), ArtsSlidingMain.class);
                    if (i < 820) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 820 && i < 860) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 860 && i < 900) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
            for (int i = 900; i < 1120; i++) {
                if (clicked.equals(Integer.toString(i))) {
                    Intent intent2 = new Intent(getApplicationContext(), EntertainmentSlidingMain.class);
                    if (i < 980) {
                        intent2.putExtra("TabNo", 0);
                    }
                    if (i >= 980 && i < 1060) {
                        intent2.putExtra("TabNo", 1);
                    }
                    if (i >= 1060 && i < 1120) {
                        intent2.putExtra("TabNo", 2);
                    }
                    startActivity(intent2);
                    finish();
                }
            }
        }
    }

    //Reveal Answer method
    public void revealHole(View view) {
        final Dialog dialog = new Dialog(MainGameActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.setContentView(R.layout.dialog_reveal);
        dialog.setCancelable(true);


        TextView costReveal = (TextView) dialog.findViewById(R.id.costReavel);
        costReveal.setTypeface(shablagooital);

        //Watch Rewarded Video Button
        watchVideo = (FButton) dialog.findViewById(R.id.watchvideo);
        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluehintclicked = true;

                //check if the question is solved if solved then give toast "Question already solved"
                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Question already solved.\nTry for other questions.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                    dialog.dismiss();
                }
                //Show the google rewarded video ads if it is ready(i.e loaded)
                else if (mAd.isLoaded()) {
                    mAd.show();
                    loadAdRewardedVideo();
                    dialog.dismiss();
                }
                //Show the unity ad (throw mediation) if it ready(i.e loaded)
                else if (UnityAds.isReady()) {
                    MediationMetaData mediationMetaData = new MediationMetaData(getApplicationContext());
                    mediationMetaData.setOrdinal(ordinal++);
                    mediationMetaData.commit();
                    UnityAds.show(MainGameActivity.this);
                    dialog.dismiss();

                    final List listgems = demoHelperClass.getGems();
                    int plusOneGem = 1;
                    int gemstext = (Integer) listgems.get(listgems.size() - 1);
                    gemstext = gemstext + plusOneGem;
                    demoHelperClass.InsertGems(gemstext);
                    gemsText.setText(String.valueOf(gemstext));
                    listgems.clear();

                }
                //If video is not loaded then show this and call loadAdRewardedVideo method
                else {
                    String loading = "Loading..";
                    watchVideo.setText("Watch Video" + "\n" + loading);
                    loadAdRewardedVideo();
                }

            }
        });


        Button usegems = (Button) dialog.findViewById(R.id.usegems);
        usegems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if the question is solved if solved then no dialog_reveal
                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Question already solved", Toast.LENGTH_LONG);
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
                        Toast toast = Toast.makeText(getApplicationContext(), "\t\t\tYou ran out of Gems.\n Please Buy them in shop or watch video.", Toast.LENGTH_LONG);
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


                    }
                    if (gemstext > 1) {
                        gemstext = gemstext - z;
                        demoHelperClass.InsertGems(gemstext);
                    }
                    gemsText.setText(String.valueOf(gemstext));
                }
                dialog.dismiss();

            }
        });


        final List listgems = demoHelperClass.getGems();
        int gemstext = (Integer) listgems.get(listgems.size() - 1);

        TextView watchvideo = (TextView) dialog.findViewById(R.id.watchvideo);
        watchvideo.setTypeface(shablagooital);
        watchvideo.setText(getResources().getString(R.string.watchvideo));

        usegems.setTypeface(shablagooital);
        usegems.setText(getResources().getString(R.string.useDiamond) + "\n\n" + getResources().getString(R.string.Cost_2_Diamond) + Integer.toString(gemstext) + " " + getResources().getString(R.string.diamond_left_in_your_bucket));

        TextView or = (TextView) dialog.findViewById(R.id.or);
        or.setTypeface(shablagooital);

        TextView revealtext2 = (TextView) dialog.findViewById(R.id.revealtext2);
        revealtext2.setTypeface(shablagooital);

        //Cancel Button
        Button cancel = (Button) dialog.findViewById(R.id.cance11);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        //Show dialog
        dialog.show();
    }

    //It will set The color of toolbar,queNo and also the text on toolbar of the category (i.e sports,a_maingame etc)
    public void xmlColor() {
        final FButton textViewArrayBelow2[] = {tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv21b, tv22b, tv23b, tv24b, tv25b, tv26b, tv27b, tv28b, tv29b};
        Intent intent = getIntent();
        /* Obtain String from Intent  */
        if (intent != null) {
            String clicked = intent.getStringExtra("Key");
            for (int i = 0; i < 180; i++)
                if (clicked.equals(Integer.toString(i))) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
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

    //If we reach the end of the questions of particular category then it will
    //handle the left & right visibility of arrow
    public void visiblityOfrightleft() {
        for (int i = 0; i <= qid; i++) {
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
            if (qid == 0) {
                leftImage.setVisibility(View.INVISIBLE);
            }
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

    //It will set The text that the que is easy or hard or medium.
    //It will also set The color of the below boxes,bootstrap bar and left and right arrow
    public void diffLevel() {
        //a_maingame
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
        //a_maingame
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

    //Gooogle rewarded Video ads
    public void loadAdRewardedVideo() {
        if (!mAd.isLoaded()) {

            Bundle extras = new Bundle();
            extras.putBoolean("_noRefresh", true);
            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                    //.addNetworkExtrasBundle(ChartboostAdapter.class, extras)
                    .addNetworkExtrasBundle(UnityAdapter.class, extras)
                    .build();
            mAd.loadAd(getString(R.string.Test_admob_unit_id_rewardedVideo), adRequest);
            // Toast.makeText(MainGameActivity.this,"called",Toast.LENGTH_LONG).show();
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

        DemoHelperClass demoHelperClass = new DemoHelperClass(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = demoHelperClass.getWritableDatabase();

        final List listgems = demoHelperClass.getGems();
        int gemstext = (Integer) listgems.get(listgems.size() - 1);

        int plusOneGem = 1;
        gemstext = gemstext + plusOneGem;
        demoHelperClass.InsertGems(gemstext);
        gemsText.setText(String.valueOf(gemstext));

        //Show text that +1 gem added in bucket
        Toast toast = Toast.makeText(getApplicationContext(), "+1 gem added in your bucket.", Toast.LENGTH_LONG);
        toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        v.setTypeface(openSansSemiBold);
        v.setTextSize(10);
        toast.show();


        sqLiteDatabase.close();
        listgems.clear();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    //If Video Failed to load then print the msg on the dialog button
    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        String failedToLoad = "Video failed to load \ntap to try again.";
        if (bluehintclicked) {
            watchVideo.setText("Watch Video" + "\n\n" + failedToLoad);

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

    //Method is called when the activity is finished
    @Override
    public void onDestroy() {
        super.onDestroy();
        Chartboost.onDestroy(this);
        quesList.clear();


        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        incorrect = null;
        tvQ = null;
        tvt = null;
        gemsText = null;
        queNum = null;
        bootstrapProgressBar = null;
        triviaKnowldegText = null;
        backButtonImage.setImageDrawable(null);
        leftImage.setImageDrawable(null);
        rightImage.setImageDrawable(null);
        FreeHint.setImageDrawable(null);
        master.setImageDrawable(null);
        hint2.setImageDrawable(null);
        gems.setImageDrawable(null);
        bomb.setImageDrawable(null);
        correctImage.setImageDrawable(null);
        cracker1.setImageDrawable(null);
        cracker2.setImageDrawable(null);
        cracker3.setImageDrawable(null);
        cracker4.setImageDrawable(null);
        solvedText = null;
        toolbar = null;
        l1.removeAllViews();
        l2.removeAllViews();

        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        backButtonImage.setOnClickListener(null);
        FreeHint.setOnClickListener(null);

        for (int i = 0; i < textViewArrayAbove.length; i++) {
            textViewArrayAbove[i] = null;
        }
        for (int i = 0; i < textViewArrayBelow.length; i++) {
            textViewArrayBelow[i] = null;
        }

        textViewArrayAbove = null;
        textfirst = null;
        textsecound = null;
        textViewArrayBelow = null;
        textViewBelowFirst = null;
        textViewBelowsecond = null;
        demoHelperClass = null;
        finish();
    }

    public void bomb(View view) {
        final Dialog dialog = new Dialog(MainGameActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.setContentView(R.layout.dialog_bomb);
        dialog.setCancelable(true);


        final TextView boom = (TextView) dialog.findViewById(R.id.boom);
        TextView removeEtra = (TextView) dialog.findViewById(R.id.removeExtra);
        TextView removeEtraCost = (TextView) dialog.findViewById(R.id.removeExtraCost);
        TextView reward = (TextView) dialog.findViewById(R.id.reward);
        FButton boomFbutton = (FButton) dialog.findViewById(R.id.boomfbutton);
        FButton cancelBoom = (FButton) dialog.findViewById(R.id.cancelbomb);

        //Setting the typeface for all above variables
        boom.setTypeface(shablagooital);
        removeEtra.setTypeface(shablagooital);
        removeEtraCost.setTypeface(shablagooital);
        boomFbutton.setTypeface(shablagooital);
        reward.setTypeface(shablagooital);

        //CancelButton for boom
        cancelBoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        //BoomButton of boom Method
        boomFbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //If games are less then equal to zero No boom can be done
                List listgems = demoHelperClass.getGems();
                int gemstext = (Integer) listgems.get(listgems.size() - 1);
                if (gemstext <= 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "\t\t\tYou ran out of Gems.\n Please Buy them in shop or watch video.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();
                }

                //If gems are greater than zero and question is not solved and boom is not used
                // then boom(i.e remove extra char which not par of ans from below)
                    if (gemstext > 0) {
                        if (returnQid() != qid) {
                        if (returnBoomIdUsed() != qid) {
                            int z = 1;
                            boomMethod();
                            bomb.setVisibility(View.INVISIBLE);
                            demoHelperClass.insertBoom(qid);
                            gemstext = gemstext - z;
                            demoHelperClass.InsertGems(gemstext);
                            gemsText.setText(String.valueOf(gemstext));
                            crackerAnimation();

                            //IF dialog_sound is on play it
                            if (checkSound()) {
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bombexplosion);
                                if (mediaPlayer != null) {
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
                    }
                }

                dialog.dismiss();
                listgems.clear();
            }
        });

        //Whatch Video button of boom dialog box
        watchVideoBoom = (FButton) dialog.findViewById(R.id.watchvideoBoom);
        watchVideoBoom.setTypeface(shablagooital);
        watchVideoBoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boomClicked = true;

                //check if the question is solved if solved then give toast "Question already solved"
                if (returnQid() == qid) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Question already solved.\nTry for other questions.", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    v.setTypeface(openSansSemiBold);
                    v.setTextSize(10);
                    toast.show();

                    dialog.dismiss();
                }
                //if google rewarded video is ready show it (i.e is loaded)
                else if (mAd.isLoaded()) {
                    mAd.show();
                    loadAdRewardedVideo();
                    dialog.dismiss();
                }
                //if unity rewarded video is ready show it (i.e is loaded)
                else if (UnityAds.isReady()) {
                    MediationMetaData mediationMetaData = new MediationMetaData(getApplicationContext());
                    mediationMetaData.setOrdinal(ordinal++);
                    mediationMetaData.commit();
                    UnityAds.show(MainGameActivity.this);
                    dialog.dismiss();

                    final List listgems = demoHelperClass.getGems();
                    int plusOneGem = 1;
                    int gemstext = (Integer) listgems.get(listgems.size() - 1);
                    gemstext = gemstext + plusOneGem;
                    demoHelperClass.InsertGems(gemstext);
                    gemsText.setText(String.valueOf(gemstext));
                    listgems.clear();
                }
                //If no video is loaed then print msg on button and call method loadAdRewardedVideo
                else {
                    String loading = "Loading..";
                    watchVideoBoom.setText("Watch Video" + "\n" + loading);
                    loadAdRewardedVideo();
                }

            }
        });
        dialog.show();
    }

    private void boomMethod() {

        //dialog_bomb without FreeHint(hint1) i.e FreeHint is not used
        if (returnFreeHintUsed() != qid) {

            //It will reset the boxes both above and below if user has typed filled some above boxes
            refreshBoxesboth();

            //It will remove the letters from below boxes which are not the part of the answer
            //i.e extra letters
            removeKachra();

        }
        //dialog_bomb with FreeHint(hint1) i.e FreeHint is already used before dialog_bomb
        if (returnFreeHintUsed() == qid) {
            //It will reset the boxes both above and below if user has filled some above boxes
            refreshBoxesboth();

            //If FreeHint(Hint1) is used already then it will set random letters for above boxes
            //and will remove same letters from below boxes
            checkIfFreeHintIsUsed();

            //It will remove the letters from below boxes which are not the part of the answer
            //i.e extra letters
            removeKachra();
        }

    }

    //It will remove the letters from below boxes which are not the part of the answer
    //i.e extra letters
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
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
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

    //If users types the char in above boxes then both above boxes and below boxes will be reset
    public void refreshBoxesboth() {

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

    // This method returns qid of solved questions
    public int returnQid() {
        int a = 100001;
        List<Integer> solvedQueID = demoHelperClass.GetQid();
        if (solvedQueID != null) {
            for (int i = 0; i < solvedQueID.size(); i++) {
                a = solvedQueID.get(i);
                if (a == qid) {
                    solvedQueID.clear();
                    break;
                }
            }
        }
        return a;
    }

    //This method returns qid of questions where Freehint(hint1) is used
    public int returnFreeHintUsed() {
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
    }


    //It will return id of the question for which boom is used
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
    }


    //return true if dialog_sound is on or else false
    public Boolean checkSound() {
        List list = demoHelperClass.getSound();
        if (list != null) {
            if (list.size() % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    //Unity ads
    private class UnityAdsListener implements IUnityAdsListener {
        @Override
        public void onUnityAdsReady(String s) {
            //Called when Unity Ads has a video available to show
        }

        @Override
        public void onUnityAdsStart(String s) {
            //Called when a video begins playing
        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
            //Called when a video vinishes playing
            //you get a reward

            //   final Typeface typeface2 = Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Semibold.ttf");
            Toast toast = Toast.makeText(getApplication(), "+1 gem added in your bucket.", Toast.LENGTH_LONG);
            toast.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
            v.setTypeface(openSansSemiBold);
            v.setTextSize(10);
            toast.show();

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {
            //Called when the Unity Ads detects an error
        }
    }

    //Function for dialog_sound
    public void sound() {
        if (checkSound()) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
            if (mediaPlayer != null) {
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

    //It will set The text of number of gems available
    public void setNoOfGemsText(){
        List noOfGems = demoHelperClass.getGems();
        int noOfGemsText = (Integer) noOfGems.get(noOfGems.size() - 1);
        gemsText.setText(String.valueOf(noOfGemsText));
        noOfGems.clear();
    }

    //It will set The text of number of que solved
    public void setNoOfSolvedQueText(){
        List noOfSolvedQueList = demoHelperClass.GetQid();
        solvedText.setText(String.valueOf(noOfSolvedQueList.size()));
        noOfSolvedQueList.clear();
    }
}
