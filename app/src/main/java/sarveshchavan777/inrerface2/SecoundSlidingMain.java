package sarveshchavan777.inrerface2;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class SecoundSlidingMain extends AppCompatActivity implements ComponentCallbacks2 {
    int numboftabs = 3;
    public int icon[] = {R.drawable.piapple1, R.drawable.piapple2, R.drawable.piapple3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficulty;
    TextView textViewDifficulty, easyper, mediumper, hardper;
    DemoHelperClass demoHelperClass;
    MediaPlayer ring;

    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPager mPager;
        SlidingTabLayout mTabs;
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        setContentView(R.layout.secoundslidingmain);
        leftdifficulty = (ImageView) findViewById(R.id.leftdifficulty);
        textViewDifficulty = (TextView) findViewById(R.id.textviewdifficulty);
        easyper = (TextView) findViewById(R.id.easyper);
        mediumper = (TextView) findViewById(R.id.mediumper);
        hardper = (TextView) findViewById(R.id.hardper);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficulty.setTypeface(typeface);
        easyper.setTypeface(typeface);
        mediumper.setTypeface(typeface);
        hardper.setTypeface(typeface);

        leftdifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                finish();


                if (checkSound()) {
                    ring = MediaPlayer.create(getApplicationContext(), R.raw.knife);
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


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPageerAdapterPersonality(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.customtablayoutper, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        mTabs.setViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), Category.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        icon = null;
    }

}