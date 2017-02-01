package sarveshchavan777.inrerface2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

/**
 * Created by LENOVO on 1/31/2017.
 */

class MyPagerAdapter extends FragmentPagerAdapter  {
    Context context;
  public String yourStringArray[]=new String[3];
    public int icon[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    public MyPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment myFragment=MyFragment.getInstance(position);
        return myFragment;
    }


        @Override
        public CharSequence getPageTitle ( int position){
            Drawable drawable= ContextCompat.getDrawable(context,icon[position]);
           drawable.setBounds(0,0,50,50);
            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return spannableString;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
