package sarveshchavan777.inrerface2.ViewPager;


import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.WindowManager;

import sarveshchavan777.inrerface2.Tab.HomeScreen.HomePlayTab;
import sarveshchavan777.inrerface2.Tab.HomeScreen.HomeSettingTab;
import sarveshchavan777.inrerface2.Tab.HomeScreen.HomeAchievementTab;


public class MyPagerAdapterHome extends FragmentStatePagerAdapter {
    Context context;
  //  public String yourStringArray[] = new String[3];
    public int icon[];

   private int numbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


   public MyPagerAdapterHome(FragmentManager fm, int micon[], int mNumOfTabs, Context context) {
        super(fm);
        this.context = context;
        this.icon = micon;
        this.numbOfTabs = mNumOfTabs;

    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) // if the position is 0 we are returning the First f_per_easy.xmll
        {

            return new HomePlayTab();

        } else if (position == 1) // As we are having 3 tabs if the position is now 0 it must be 1 so we are returning second p_easyy.xml
        {
            return new HomeSettingTab();

        } else {
            return new HomeAchievementTab();

        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable = ContextCompat.getDrawable(context, icon[position]);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int checkWidth = size.x;
        int checkHeight = size.y;


        //NORMAL
        try {
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                if (checkWidth < 480 && checkHeight < 800) {
                    drawable.setBounds(0, 0, 24, 24);
                    // Toast.makeText(context, "Normal -less", Toast.LENGTH_LONG).show();
                } else if (checkWidth > 1080 && checkHeight > 1920) {
                    drawable.setBounds(0, 0, 90, 90);
                    // Toast.makeText(context, "NORMAL-large", Toast.LENGTH_LONG).show();
                } else {
                    drawable.setBounds(0, 0, 50, 50);
                    //    Toast.makeText(context, "NORMAL-default", Toast.LENGTH_LONG).show();
                }

            }
        } catch (Exception e) {
            drawable.setBounds(0, 0, 50, 50);
            // Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //LARGE
        try {
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                drawable.setBounds(0, 0, 60, 60);
                //    Toast.makeText(context, "large", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            drawable.setBounds(0, 0, 50, 50);
            // Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //XLARGE
        try {
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                drawable.setBounds(0, 0, 80, 80);
                //  Toast.makeText(context, "x-large", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            drawable.setBounds(0, 0, 50, 50);
            //   Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //SMALL
        try {
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
                drawable.setBounds(0, 0, 20, 20);
                //   Toast.makeText(context, "small", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            drawable.setBounds(0, 0, 50, 50);
            //Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}

