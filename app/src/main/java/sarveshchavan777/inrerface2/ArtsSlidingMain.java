package sarveshchavan777.inrerface2;

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


public class ArtsSlidingMain extends AppCompatActivity {
    int numboftabs = 3;
    DemoHelperClass demoHelperClass;
    // public int icon[] = {R.drawable.heart1, R.drawable.heart2, R.drawable.heart3};
    public int[] text = {R.string.easy, R.string.medium, R.string.hard};
    public int icon[] = {R.drawable.heart1, R.drawable.heart2, R.drawable.heart3};
    ImageView leftdifficultyarts;
    TextView textViewDifficultyarts, easyarts, mediumarts, hardarts;
    Typeface typeface;
    MediaPlayer ring;

    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artsslidingmain);
        ViewPager mPager;
        SlidingTabLayout mTabs;

        demoHelperClass = new DemoHelperClass(getApplicationContext());
        leftdifficultyarts = (ImageView) findViewById(R.id.leftdifficultyarts);
        textViewDifficultyarts = (TextView) findViewById(R.id.textviewdifficultyarts);
        easyarts = (TextView) findViewById(R.id.easyarts);
        mediumarts = (TextView) findViewById(R.id.mediumarts);
        hardarts = (TextView) findViewById(R.id.hardarts);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultyarts.setTypeface(typeface);
        easyarts.setTypeface(typeface);
        mediumarts.setTypeface(typeface);
        hardarts.setTypeface(typeface);

        leftdifficultyarts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
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
        mPager.setAdapter(new MyPageerAdapterArts(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));

        Intent intent=getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.customtablayoutarts, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.arts));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        mTabs.setViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Category.class);
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
        icon=null;
    }
}