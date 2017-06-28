package sarveshchavan777.inrerface2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public  class SportsSlidingMain extends AppCompatActivity {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs =3;
    public int icon[] = {R.drawable.ball1,R.drawable.ball2,R.drawable.ball3};
    public String[] text= {"easy", "medium","hard"};
    ImageView leftdifficultysports;
    TextView textViewDifficultysports,easysports,mediumsports,hardsports;
    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sportsslidingmain);
        leftdifficultysports=(ImageView)findViewById(R.id.leftdifficultysports);
        textViewDifficultysports=(TextView)findViewById(R.id.textviewdifficultysports);
        easysports=(TextView)findViewById(R.id.easysports);
        mediumsports=(TextView)findViewById(R.id.mediumsports);
        hardsports=(TextView)findViewById(R.id.hardsports);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultysports.setTypeface(typeface);
        easysports.setTypeface(typeface);
        mediumsports.setTypeface(typeface);
        hardsports.setTypeface(typeface);
        leftdifficultysports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SportsSlidingMain.this,Category.class);
                startActivity(intent);
                finish();
            }
        });

        mPager=(ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new MyPageerAdapterSports(getSupportFragmentManager(),icon,numboftabs,getApplicationContext()));

        mTabs=(SlidingTabLayout)findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.customtablayoutsports,R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.sports));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        mTabs.setViewPager(mPager);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,Category.class);
        startActivity(intent);
        finish();
    }

}