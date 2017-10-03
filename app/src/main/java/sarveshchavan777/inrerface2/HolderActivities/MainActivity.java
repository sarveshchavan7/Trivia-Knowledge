package sarveshchavan777.inrerface2.HolderActivities;



import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.ViewPager.MyPagerAdapterHome;


public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab;
    int numboftabs = 3;
    public int icon[] = {R.drawable.homecartoon, R.drawable.settingscartoon, R.drawable.achievementcartoon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_activity_main);
        ViewPager mPager;
        SlidingTabLayout mTabs;


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapterHome(getSupportFragmentManager(), icon, numboftabs, getApplicationContext()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        mTabs.setCustomTabView(R.layout.ha_customtablayout, R.id.textTab);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.darkpink));
        mTabs.setSelectedIndicatorColors(ContextCompat.getColor(getApplicationContext(), R.color.white));
        mTabs.setViewPager(mPager);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "google sign not available if imported from github", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }


}



