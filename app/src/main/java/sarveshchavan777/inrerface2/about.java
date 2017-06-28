package sarveshchavan777.inrerface2;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class about extends Activity{
    ImageView leftabout;
    TextView imageCreditText,aboutTK,privacyPolicy,aboutText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        leftabout = (ImageView) findViewById(R.id.leftabout);
        aboutText = (TextView) findViewById(R.id.textviewabout);
        imageCreditText = (TextView) findViewById(R.id.imagecredittext);
        aboutTK = (TextView) findViewById(R.id.abouttk);
        aboutTK.setVisibility(View.INVISIBLE);
        privacyPolicy = (TextView) findViewById(R.id.privacypolicytext);
        privacyPolicy.setVisibility(View.INVISIBLE);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        imageCreditText.setTypeface(typeface);
        imageCreditText.setVisibility(View.INVISIBLE);
        privacyPolicy.setTypeface(typeface);
        aboutTK.setTypeface(typeface);
        aboutText.setTypeface(typeface);
        imageCreditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(about.this, ImageCredit.class);
                startActivity(intent);
            }
        });
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://charetakergames.wordpress.com/2017/02/27/privacytrivia/"));
                startActivity(intent);
            }
        });
        aboutTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://charetakergames.wordpress.com/2017/03/03/trivia-knowledge/"));
                startActivity(intent);
            }
        });
        leftabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                if(checkSound()){
                    MediaPlayer ring= MediaPlayer.create(about.this,R.raw.knife);
                    ring.start();
                }

            }
        });

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                imageCreditText.setVisibility(View.VISIBLE);
               imageCreditText.startAnimation(inFromRightAnimation());
                //for interval...
            }
        };
        handler.postDelayed(runnable, 10);

        final Handler handler2 = new Handler();
        Runnable runnable2 = new Runnable() {
            int i=0;
            public void run() {
                privacyPolicy.setVisibility(View.VISIBLE);
                privacyPolicy.startAnimation(inFromLeftAnimation());
                  //for interval...
            }
        };
        handler2.postDelayed(runnable2, 30);

        final Handler handler3 = new Handler();
        Runnable runnable3 = new Runnable() {
            int i=0;
            public void run() {
                aboutTK.setVisibility(View.VISIBLE);
                aboutTK.startAnimation(inFromRightAnimation());
                   //for interval...
            }
        };
        handler3.postDelayed(runnable3, 50);
    }



    //Animation method
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public Boolean checkSound(){
        DemoHelperClass demoHelperClass=new DemoHelperClass(this);
        List list=demoHelperClass.getSound();
        if(list!=null){
            if( list.size()%2==0 ){
                //  Toast.makeText(getActivity(),"true",Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }
}
