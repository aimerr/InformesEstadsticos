package com.uninorte.informesestadsticos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by aimer on 24/01/2018.
 */

public class MainAdapterPhotos extends BaseAdapter{

    private Context context;
    ArrayList<Photos> data0;

    public MainAdapterPhotos(Context context, ArrayList<Photos> names)
    {   super();
        this.context=context;
        this.data0=names;
    }

    @Override
    public int getCount() {
        return data0.size();
    }

    @Override
    public Object getItem(int i) {
        return data0.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_photos,null);
        }

        ImageView img = (ImageView) view.findViewById(R.id.imageView);

        img.setImageResource(data0.get(i).photos);



        return view;
    }

    public void setData(ArrayList<Photos> names) {

        this.data0=names;

    }

}
