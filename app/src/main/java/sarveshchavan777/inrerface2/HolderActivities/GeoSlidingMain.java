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
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterGeo;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class GeoSlidingMain extends AppCompatActivity {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs = 3;
    public int icon[] = {R.drawable.boam1, R.drawable.boam2, R.drawable.boam3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficultygeo;
    TextView textViewDifficultygeo, easygeo, mediumgeo, hardgeo;
    DemoHelperClass demoHelperClass;

    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_geoslidingmain);
        leftdifficultygeo = (ImageView) findViewById(R.id.leftdifficultygeo);
        textViewDifficultygeo = (TextView) findViewById(R.id.textviewdifficultygeo);
        easygeo = (TextView) findViewById(R.id.easygeo);
        mediumgeo = (TextView) findViewById(R.id.mediumgeo);
        hardgeo = (TextView) findViewById(R.id.hardgeo);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultygeo.setTypeface(typeface);
        easygeo.setTypeface(typeface);
        mediumgeo.setTypeface(typeface);
        hardgeo.setTypeface(typeface);
        leftdifficultygeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);
                finish();
            }
        });

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterGeo(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.ha_customtablayoutgeo, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.geography));
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
        leftdifficultygeo=null;
    }
}