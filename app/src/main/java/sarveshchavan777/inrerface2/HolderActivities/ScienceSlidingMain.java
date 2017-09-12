package sarveshchavan777.inrerface2.HolderActivities;

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
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterScience;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class ScienceSlidingMain extends AppCompatActivity {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs = 3;
    public int icon[] = {R.drawable.star1, R.drawable.star2, R.drawable.star3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficultysci;
    TextView textViewDifficultysci, easysci, mediumsci, hardsci;
    DemoHelperClass demoHelperClass;

    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_scienceslidingmain);
        leftdifficultysci = (ImageView) findViewById(R.id.leftdifficultysci);
        textViewDifficultysci = (TextView) findViewById(R.id.textviewdifficultysci);
        easysci = (TextView) findViewById(R.id.easysci);
        mediumsci = (TextView) findViewById(R.id.mediumsci);
        hardsci = (TextView) findViewById(R.id.hardsci);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultysci.setTypeface(typeface);
        easysci.setTypeface(typeface);
        mediumsci.setTypeface(typeface);
        hardsci.setTypeface(typeface);

        leftdifficultysci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);
                finish();

            }
        });

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterScience(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.ha_customtablayoutsci, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.science));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        mTabs.setViewPager(mPager);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), Category.class);
        startActivity(intent);
        finish();
    }

    public Boolean checkSound() {
        demoHelperClass = new DemoHelperClass(this);
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
        leftdifficultysci=null;
    }
}