package sarveshchavan777.inrerface2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public  class SecoundSlidingMain extends AppCompatActivity {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs =3;
    public int icon[] = {R.drawable.piapple1, R.drawable.piapple2, R.drawable.piapple3};
    public String[] text= {"easy", "medium","hard"};
    ImageView leftdifficulty;
    TextView textViewDifficulty,easyper,mediumper,hardper;
    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secoundslidingmain);
        leftdifficulty=(ImageView)findViewById(R.id.leftdifficulty);
        textViewDifficulty=(TextView)findViewById(R.id.textviewdifficulty);
        easyper=(TextView)findViewById(R.id.easyper);
        mediumper=(TextView)findViewById(R.id.mediumper);
        hardper=(TextView)findViewById(R.id.hardper);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficulty.setTypeface(typeface);
        easyper.setTypeface(typeface);
        mediumper.setTypeface(typeface);
        hardper.setTypeface(typeface);

        leftdifficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecoundSlidingMain.this,Category.class);
                startActivity(intent);
                finish();
            }
        });
        mPager=(ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new MyPageerAdapter2(getSupportFragmentManager(),icon,numboftabs,getApplicationContext()));

        mTabs=(SlidingTabLayout)findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.customtablayoutper,R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
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