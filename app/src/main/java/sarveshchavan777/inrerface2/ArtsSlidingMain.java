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


public  class ArtsSlidingMain extends AppCompatActivity {
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    int numboftabs =3;
  // public int icon[] = {R.drawable.heart1, R.drawable.heart2, R.drawable.heart3};
    public int[] text= {R.string.easy,R.string.medium,R.string.hard};
    public int icon[] = {R.drawable.heart1, R.drawable.heart2, R.drawable.heart3};
    ImageView leftdifficultyarts;
    TextView textViewDifficultyarts,easyarts,mediumarts,hardarts;
    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artsslidingmain);
        leftdifficultyarts=(ImageView)findViewById(R.id.leftdifficultyarts);
        textViewDifficultyarts=(TextView)findViewById(R.id.textviewdifficultyarts);
        easyarts=(TextView)findViewById(R.id.easyarts);
        mediumarts=(TextView)findViewById(R.id.mediumarts);
        hardarts=(TextView)findViewById(R.id.hardarts);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultyarts.setTypeface(typeface);
        easyarts.setTypeface(typeface);
        mediumarts.setTypeface(typeface);
        hardarts.setTypeface(typeface);
        leftdifficultyarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ArtsSlidingMain.this,Category.class);
                startActivity(intent);
                finish();
            }
        });

        mPager=(ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new MyPageerAdapterArts(getSupportFragmentManager(),icon,numboftabs,getApplicationContext()));

        mTabs=(SlidingTabLayout)findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.customtablayoutarts,R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.arts));
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