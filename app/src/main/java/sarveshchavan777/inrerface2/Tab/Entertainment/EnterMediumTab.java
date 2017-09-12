package sarveshchavan777.inrerface2.Tab.Entertainment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


import com.beardedhen.androidbootstrap.BootstrapProgressBar;

import java.util.ArrayList;
import java.util.List;

import sarveshchavan777.inrerface2.db.DemoHelperClass;
import sarveshchavan777.inrerface2.Adapter.EntertainmentAdapter;
import sarveshchavan777.inrerface2.Activity.MainGameActivity;
import sarveshchavan777.inrerface2.R;


public class EnterMediumTab extends Fragment {
    GridView gridview;
    DemoHelperClass demoHelperClass;
    BootstrapProgressBar Progress;
    TextView progressText;

    public EnterMediumTab() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_enter_medium, container, false);
        gridview = (GridView) v.findViewById(R.id.gridview);
        Progress= (BootstrapProgressBar) v.findViewById(R.id.Progress);
        progressText = (TextView) v.findViewById(R.id.progressText);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        demoHelperClass = new DemoHelperClass(getActivity().getApplicationContext());


        Integer imageView[] = new Integer[80];
        String s[] = new String[80];

       /* String per[] = {"Music","Movie/Film","Superhero","Cartoon/Manga","Entertainment"};

        String s1[] = { per[0], per[2], per[0], per[1], per[0], per[0], per[0], per[0], per[3], per[0],
                        per[0], per[0], per[3], per[0], per[0], per[0], per[0], per[4], per[2], per[4],
                        per[0], per[0], per[0], per[0], per[0], per[0], per[3], per[0], per[4], per[3],
                        per[1], per[0], per[4], per[0], per[0], per[0], per[1], per[1], per[0], per[3],
                        per[0], per[0], per[0], per[2], per[1], per[4], per[4], per[0], per[0], per[0],
                        per[0], per[0], per[1], per[1], per[1], per[0], per[0], per[1], per[1], per[1],
                        per[0], per[1], per[1], per[3], per[1], per[1], per[1], per[3], per[1], per[2],
                        per[0], per[0], per[1], per[0], per[2], per[3], per[0], per[2], per[1], per[0]};*/


        //Adding the images to Int array
        for (int i = 0; i < imageView.length; i++) {
            imageView[i] = R.drawable.transparent;
        }

        //Adding the text to String array
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(i + 1);
        }


        //setting the image correct for correct answer and adding value  into list
        List<Integer> list = new ArrayList<>();
        List xyz = demoHelperClass.GetQid();
        if (xyz != null) {
            for (int i = 0; i < xyz.size(); i++) {
                int x = (Integer) xyz.get(i);
                if (x >= 980 && x< 1060) {
                    imageView[x-980] = R.drawable.correctcartoon;
                    list.add(1);
                }
            }
        }


        //setting the progress bar as per the size of list
        Progress.setProgress(list.size());
        progressText.setText(list.size() + "/" + 80);
        list.clear();

        //setting adapter
        EntertainmentAdapter adapter = new EntertainmentAdapter(getActivity(), imageView, s/*, s1*/);
        gridview.setAdapter(adapter);

        //OnClick Listner
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent intent = new Intent(getActivity().getApplicationContext(), MainGameActivity.class);
                intent.putExtra("Key", Integer.toString(position+980));
                startActivity(intent);
                getActivity().finish();

                /*Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Progress = null;
        demoHelperClass=null;
        gridview.setOnItemClickListener(null);
    }
}

