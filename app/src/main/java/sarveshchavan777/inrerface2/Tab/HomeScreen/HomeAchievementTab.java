package sarveshchavan777.inrerface2.Tab.HomeScreen;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.games.Games;

import com.google.example.games.basegameutils.BaseGameUtils;

import java.util.List;

import info.hoang8f.widget.FButton;
import sarveshchavan777.inrerface2.HolderActivities.MainActivity;
import sarveshchavan777.inrerface2.R;
import sarveshchavan777.inrerface2.db.DemoHelperClass;


public class HomeAchievementTab extends Fragment {
    FButton achievement;
    DemoHelperClass demoHelperClass;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.h_homeachievement, container, false);
        achievement = (FButton) v.findViewById(R.id.achievementButton);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        demoHelperClass = new DemoHelperClass(getActivity().getApplicationContext());

        final Typeface typeface = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/shablagooital.ttf");
        achievement.setTypeface(typeface);

        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkSound()) {
                    mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.gameaudio2);
                    if (mediaPlayer != null) {
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
                Toast.makeText(getContext(),"Achievements not available for now",Toast.LENGTH_SHORT).show();
            }
        });
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
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        achievement.setOnClickListener(null);
    }
}
