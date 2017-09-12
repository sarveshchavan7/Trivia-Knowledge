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
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterEntertainment;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class EntertainmentSlidingMain extends AppCompatActivity {

    int numboftabs = 3;
    public int icon[] = {R.drawable.strawberry1, R.drawable.strawberry2, R.drawable.strawberry3};
    public String[] text = {"easy", "medium", "hard"};
    ImageView leftdifficultyent;
    TextView textViewDifficultyent, easyent, mediument, hardent;
    DemoHelperClass demoHelperClass;


    //mainactivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_entertainmentslidingmain);
        ViewPager mPager;
        SlidingTabLayout mTabs;
        demoHelperClass = new DemoHelperClass(this);
        leftdifficultyent = (ImageView) findViewById(R.id.leftdifficultyent);
        textViewDifficultyent = (TextView) findViewById(R.id.textviewdifficultyent);
        easyent = (TextView) findViewById(R.id.easyent);
        mediument = (TextView) findViewById(R.id.mediument);
        hardent = (TextView) findViewById(R.id.hardent);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        textViewDifficultyent.setTypeface(typeface);
        easyent.setTypeface(typeface);
        mediument.setTypeface(typeface);
        hardent.setTypeface(typeface);

        leftdifficultyent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Category.class);
                startActivity(intent);
                finish();
            }
        });

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterEntertainment(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));

        Intent intent = getIntent();
        if (intent != null) {
            int xyz = intent.getIntExtra("TabNo", 0);
            mPager.setCurrentItem(xyz);
        }

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setCustomTabView(R.layout.ha_customtablayoutentertainment, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.entartenment));
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
        leftdifficultyent=null;
    }
}