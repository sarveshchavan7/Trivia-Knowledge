package sarveshchavan777.inrerface2.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.ComponentCallbacks2;


import java.util.List;

import sarveshchavan777.inrerface2.HolderActivities.ArtsSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.EntertainmentSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.GeoSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.MainActivity;
import sarveshchavan777.inrerface2.HolderActivities.ScienceSlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.PersonalitySlidingMain;
import sarveshchavan777.inrerface2.HolderActivities.SportsSlidingMain;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class Category extends Activity implements ComponentCallbacks2 {
    ImageView imageView;
    TextView tv, tvPersonality, tvSports, tvGeography, tvScience, tvArts, tvEntertainment;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    DemoHelperClass demoHelperClass;
    Typeface typeface;
    Bitmap myBitmap1, myBitmap2, myBitmap3, myBitmap4, myBitmap5, myBitmap6, myBitmap;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_catagories);

        demoHelperClass = new DemoHelperClass(getApplicationContext());
        //initialize
        imageView = (ImageView) findViewById(R.id.leftcategory);
        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView3 = (ImageView) findViewById(R.id.image3);
        imageView4 = (ImageView) findViewById(R.id.image4);
        imageView5 = (ImageView) findViewById(R.id.image5);
        imageView6 = (ImageView) findViewById(R.id.image6);

        /*imageView1.setImageResource(R.drawable.personalityfinal);
        imageView2.setImageResource(R.drawable.sportsfinal);
        imageView3.setImageResource(R.drawable.geographyfinal);
        imageView4.setImageResource(R.drawable.sciencefinal);
        imageView5.setImageResource(R.drawable.artistfinal);
        imageView6.setImageResource(R.drawable.entertainmentfinal);*/


        myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.backcartoon);
        myBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.personalityfinal);
        myBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.sportsfinal);
        myBitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.geographyfinal);
        myBitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.sciencefinal);
        myBitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.artistfinal);
        myBitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.entertainmentfinal);
        imageView.setImageBitmap(myBitmap);
        imageView1.setImageBitmap(myBitmap1);
        imageView2.setImageBitmap(myBitmap2);
        imageView3.setImageBitmap(myBitmap3);
        imageView4.setImageBitmap(myBitmap4);
        imageView5.setImageBitmap(myBitmap5);
        imageView6.setImageBitmap(myBitmap6);


        tv = (TextView) findViewById(R.id.textviewcategory);
        tvPersonality = (TextView) findViewById(R.id.Personality);
        tvSports = (TextView) findViewById(R.id.Sports);
        tvGeography = (TextView) findViewById(R.id.Geography);
        tvScience = (TextView) findViewById(R.id.Science);
        tvArts = (TextView) findViewById(R.id.Arts);
        tvEntertainment = (TextView) findViewById(R.id.Entertainment);
        tv.setText(getString(R.string.selectCategory));
      /*  //admob
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        //typefaces
        typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        tv.setTypeface(typeface);
        tvPersonality.setTypeface(typeface);
        tvSports.setTypeface(typeface);
        tvGeography.setTypeface(typeface);
        tvScience.setTypeface(typeface);
        tvArts.setTypeface(typeface);
        tvEntertainment.setTypeface(typeface);

        //animations
        imageView1.startAnimation(inFromLeftAnimation());
        imageView2.startAnimation(inFromRightAnimation());
        imageView3.startAnimation(inFromLeftAnimation());
        imageView4.startAnimation(inFromRightAnimation());
        imageView5.startAnimation(inFromLeftAnimation());
        imageView6.startAnimation(inFromRightAnimation());


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonalitySlidingMain.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                sound();

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SportsSlidingMain.class);
                startActivity(intent);
                sound();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GeoSlidingMain.class);
                startActivity(intent);
                sound();

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScienceSlidingMain.class);
                startActivity(intent);
                sound();

            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArtsSlidingMain.class);
                startActivity(intent);
                sound();


            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EntertainmentSlidingMain.class);
                startActivity(intent);
                sound();

            }
        });

/*
        final   int []imageArray6={R.drawable.entarteinment2,R.drawable.entarteinment22};
        final Handler handler6 = new Handler();
        Runnable runnable6 = new Runnable() {
            int i=0;
            public void run() {
                imageView6.setImageResource(imageArray6[i]);

                i++;
                if(i>imageArray6.length-1)
                {
                    i=0;
                }
                handler6.postDelayed(this, 800);  //for interval...
            }
        };
        handler6.postDelayed(runnable6, 4000); //for initial delay..*/
    }

    private Animation inFromRightAnimation() {

        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(600);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(600);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    /*imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);*/
        myBitmap.recycle();
        myBitmap1.recycle(); // Don't need myBitmap1 anymore
        myBitmap2.recycle();
        myBitmap3.recycle();
        myBitmap4.recycle();
        myBitmap5.recycle();
        myBitmap6.recycle();
        myBitmap1 = null;
        myBitmap2 = null;
        myBitmap3 = null;
        myBitmap4 = null;
        myBitmap5 = null;
        myBitmap6 = null;
        imageView.setOnClickListener(null);
        imageView1.setOnClickListener(null);
        imageView2.setOnClickListener(null);
        imageView3.setOnClickListener(null);
        imageView4.setOnClickListener(null);
        imageView5.setOnClickListener(null);
        imageView6.setOnClickListener(null);
    }

    public void sound() {
        if (checkSound()) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
           if(mediaPlayer!=null){
               mediaPlayer.start();
               mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                   @Override
                   public void onCompletion(MediaPlayer mediaPlayer) {
                       mediaPlayer.reset();
                       mediaPlayer.release();
                       finish();
                   }
               });
           }
        } else {
            finish();
        }

    }
}
