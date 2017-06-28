package sarveshchavan777.inrerface2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;


public  class MyFragment extends Fragment {
 private    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
          View layout= inflater.inflate(R.layout.fragment_my,container,false);
        textView=(TextView)layout.findViewById(R.id.postion);
        Bundle bundle=getArguments();
        if(bundle!=null){
            textView.setText("The page selected is"+bundle.getInt("position"));
        }
        return layout;

    }

    public static MyFragment getInstance(int position){
        MyFragment myFragment=new MyFragment();
        Bundle args=new Bundle();
        args.putInt("position",position);
        myFragment.setArguments(args);
        return myFragment;
    }
}
