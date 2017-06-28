package sarveshchavan777.inrerface2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import info.hoang8f.widget.FButton;


public class ImageCredit extends Activity {
    TextView tv, tv2,tv3;
    FButton icons8;
    ImageView im;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_credit);
        tv2 = (TextView) findViewById(R.id.imagecredit2);
        tv3 = (TextView) findViewById(R.id.imagecredit3);
        tv = (TextView) findViewById(R.id.textviewimagecredit);
        icons8=(FButton)findViewById(R.id.icons8);
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
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("https://icons8.com/"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
