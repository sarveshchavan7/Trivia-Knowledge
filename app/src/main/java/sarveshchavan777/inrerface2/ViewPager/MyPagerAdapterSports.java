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

import sarveshchavan777.inrerface2.Tab.Sports.SportEasyTab;
import sarveshchavan777.inrerface2.Tab.Sports.SportHardTab;
import sarveshchavan777.inrerface2.Tab.Sports.SportMediumTab;


public class MyPagerAdapterSports extends FragmentStatePagerAdapter {
    Context context;
    public int icon[] /*= {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher}*/;

   private int numbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created



    public MyPagerAdapterSports(FragmentManager fm, int micon[], int mNumOfTabs, Context context) {
        super(fm);
        this.context = context.getApplicationContext();
        this.icon=micon;
        this.numbOfTabs=mNumOfTabs;

    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First p_easy.xmll
        {
       return  new SportEasyTab();

        }
        else if (position==1)         // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second p_easyy.xml
        {
            return  new SportMediumTab();
        }
        else {
            return  new SportHardTab();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable = ContextCompat.getDrawable(context, icon[position]);

        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display =  wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int checkWidth = size.x;
        int checkHeight = size.y;


        //NORMAL
        try {
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL) {
                if (checkWidth < 480 && checkHeight < 800) {
                    drawable.setBounds(0,0,24,24);
                   // Toast.makeText(context, "Normal -less", Toast.LENGTH_LONG).show();
                }else if(checkWidth>1080 && checkHeight>1920){
                    drawable.setBounds(0,0,90,90);
                   // Toast.makeText(context, "NORMAL-large", Toast.LENGTH_LONG).show();
                }else {
                    drawable.setBounds(0,0,60,60);
                     //   Toast.makeText(context, "NORMAL-default", Toast.LENGTH_LONG).show();
                }

            }
        }catch (Exception e){
            drawable.setBounds(0, 0, 50, 50);
            // Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //LARGE
        try{
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
                drawable.setBounds(0, 0, 60, 60);
                //    Toast.makeText(context, "large", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            drawable.setBounds(0, 0, 50, 50);
            // Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //XLARGE
        try{
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                drawable.setBounds(0, 0, 80, 80);
                //  Toast.makeText(context, "x-large", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            drawable.setBounds(0, 0, 50, 50);
            //   Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
        }

        //SMALL
        try{
            if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL) {
                drawable.setBounds(0, 0, 20, 20);
                //   Toast.makeText(context, "small", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
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