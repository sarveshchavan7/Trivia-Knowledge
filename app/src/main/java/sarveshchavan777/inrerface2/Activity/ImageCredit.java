package sarveshchavan777.inrerface2.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.hoang8f.widget.FButton;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class ImageCredit extends Activity {
    TextView tv, tv2, tv3;
    FButton icons8;
    ImageView im;
    Toolbar toolbar;
    DemoHelperClass demoHelperClass;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_image_credit);
        tv2 = (TextView) findViewById(R.id.imagecredit2);
        tv3 = (TextView) findViewById(R.id.imagecredit3);
        tv = (TextView) findViewById(R.id.textviewimagecredit);
        icons8 = (FButton) findViewById(R.id.icons8);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        im = (ImageView) findViewById(R.id.left);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        tv.setText(getResources().getString(R.string.imagecredit));
        tv2.setText(R.string.imagecredits2);
        tv3.setText(R.string.imagecredits3);
        tv.setTypeface(typeface);
        tv2.setTypeface(typeface);
        tv3.setTypeface(typeface);
        icons8.setTypeface(typeface);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        icons8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://icons8.com/"));
                startActivity(intent);
                if(checkSound()){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gameaudio2);
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                                mediaPlayer.release();
                            }
                        });
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public Boolean checkSound() {
        demoHelperClass = new DemoHelperClass(getApplicationContext());
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
        tv = null;
        tv2 = null;
        tv3 = null;
        im.setOnClickListener(null);
        icons8.setOnClickListener(null);
        demoHelperClass = null;
        if(mediaPlayer!=null){
            mediaPlayer.release();
        }
    }
}

