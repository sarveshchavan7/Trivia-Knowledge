package sarveshchavan777.inrerface2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.BaseGameUtils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;


import info.hoang8f.widget.FButton;
import sarveshchavan777.inrerface2.application.AppController;

public class Tab1 extends Fragment implements BaseSliderView.OnSliderClickListener {
     private static final java.lang.String LEADERBOARD_ID = "CgkItYPd68IBEAIQBw";
    private static final int REQUEST_LEADERBOARD = 100;
    private SliderLayout mDemoSlider;
    TextView tv;
    Button b1, b2, b3;
    FButton cancelSlider, undoSlider;
    Boolean clicked = false;
    int i = 2;
    // Billionaires json url
    private static final String getURL = "https://api.myjson.com/bins/8wgo1";
    HashMap<String, String> url_maps;
    DemoHelperClass demoHelperClass;
       /*GoogleApiClient mGoogleApiClient= AppController.getInstance().getClient();*/

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab01, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDemoSlider = (SliderLayout) getView().findViewById(R.id.slider);
        tv = (TextView) getView().findViewById(R.id.text11);
        // Creating volley request obj
        b1 = (Button) getView().findViewById(R.id.button1);
        b2 = (Button) getView().findViewById(R.id.button2);
        b3 = (Button) getView().findViewById(R.id.button3);
        demoHelperClass = new DemoHelperClass(getActivity());
        // textSignIn = (TextView) getView().findViewById(R.id.textSignIn);
        cancelSlider = (FButton) getView().findViewById(R.id.cancelSlider);
        // undoSlider=(FButton)getView().findViewById(R.id.undoSlider);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/shablagooital.ttf");
        b1.setTypeface(typeface);
        b2.setTypeface(typeface);
        b3.setTypeface(typeface);
        //Animation
        final Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.25, 20);
        myAnim.setInterpolator(interpolator);

        b1.startAnimation(myAnim);
        b2.startAnimation(myAnim);
        b3.startAnimation(myAnim);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Category.class);
                startActivity(intent);
               getActivity().finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GoogleApiClient client = AppController.getInstance().getClient();

                if (MainActivity.mGoogleApiClient.isConnected()) {
                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(MainActivity.mGoogleApiClient,
                            LEADERBOARD_ID), REQUEST_LEADERBOARD);
                } else {
                    BaseGameUtils.makeSimpleDialog(getActivity(), getString(R.string.leaderboards_not_available)).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        cancelSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoHelperClass.insertPauseValue(0);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(Tab1.this).attach(Tab1.this).commit();
            }

        });

        List list = demoHelperClass.getPauseButtonValue();
        if (list != null) {
            int sizeOfList = list.size();
            if (sizeOfList % 2 == 0) {
                sliderJson();
                // Toast.makeText(getActivity(),Integer.toString(sizeOfList),Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        //to prevent leak
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    public void sliderJson() {
        JsonArrayRequest billionaireReq = new JsonArrayRequest(
                getURL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        url_maps = new HashMap<String, String>();
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                url_maps.put(obj.getString("releaseYear") + " - " + obj.getString("title"), obj.getString("image"));
                               /* Toast.makeText(getActivity(),obj.getString("title"),Toast.LENGTH_LONG).show();*/
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        for (String name : url_maps.keySet()) {
                            TextSliderView textSliderView = new TextSliderView(getActivity());
                            // initialize a SliderLayout
                            textSliderView
                                    .description(name)
                                    .image(url_maps.get(name))
                                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                                    .setOnSliderClickListener(Tab1.this);

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle().putString("extra", name);

                            mDemoSlider.addSlider(textSliderView);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv.setText("network issue: Slow network / No network");
                    }
                });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(billionaireReq);

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.setPresetTransformer("Accordion");
    }
}