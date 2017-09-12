package sarveshchavan777.inrerface2.HolderActivities;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sarveshchavan777.inrerface2.Activity.Category;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterPersonality;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class PersonalitySlidingMain extends AppCompatActivity implements ComponentCallbacks2 {
    int numboftabs = 3;
    public int icon[] = {R.drawable.piapple1, R.drawable.piapple2, R.drawable.piapple3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficulty;
    TextView textViewDifficulty, easyper, mediumper, hardper;
    DemoHelperClass demoHelperClass;

    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPager mPager;
        SlidingTabLayout mTabs;
        demoHelperClass = new DemoHelperClass(getApplicationContext());
        setContentView(R.layout.s_personalityslidingmain);
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
            }
        });

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterPersonality(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.ha_customtablayoutper, R.id.textTab);
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
        text=null;
        demoHelperClass=null;
        leftdifficulty.setOnClickListener(null);
    }

}