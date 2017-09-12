package sarveshchavan777.inrerface2.Adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sarveshchavan777.inrerface2.R;


public class HomeSettingAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final Integer[] img;
    private final String[] s;
    TextView tv;

    public HomeSettingAdapter(Activity context, Integer[] img, String[] s) {
        super(context, R.layout.lv_homesetting_list_view, s);
        this.context = context;
        this.img = img;
        this.s = s;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.lv_homesetting_list_view, null, true);
        tv = (TextView) view.findViewById(R.id.tv11);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/shablagooital.ttf");
        tv.setTypeface(typeface);

        ImageView iv = (ImageView) view.findViewById(R.id.iv11);
        tv.setText(s[position]);
        tv.setTextSize(25);
        iv.setImageResource(img[position]);
        return view;
    }


}
