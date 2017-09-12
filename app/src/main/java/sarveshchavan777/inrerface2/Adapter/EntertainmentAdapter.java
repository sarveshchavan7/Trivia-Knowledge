package sarveshchavan777.inrerface2.Adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sarveshchavan777.inrerface2.R;


public class EntertainmentAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final Integer[] img;
    private final String[] s;
    //private final String[] strings;


    public EntertainmentAdapter(Activity context, Integer[] img, String[] s/*, String[] strings*/) {
        super(context, R.layout.gv_enter_grid_view, s);
        this.context = context;
        this.img = img;
        this.s = s;
        //this.strings = strings;
    }

    private class MyViewHolder {
        ImageView imageView;
        TextView mQueNo;
        //TextView mtext;

        MyViewHolder(View v) {
            imageView = (ImageView) v.findViewById(R.id.tick);
            mQueNo = (TextView) v.findViewById(R.id.pfirst);
            //mtext = (TextView) v.findViewById(R.id.text1);
        }
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.gv_enter_grid_view,null, true);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }


        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/grobold.ttf");
        holder.mQueNo.setTypeface(typeface);
        //holder.mtext.setTypeface(typeface);

        holder.imageView.setImageResource(img[position]);
        holder.mQueNo.setText(s[position]);
        //holder.mtext.setText(strings[position]);

        return row;
    }
}
