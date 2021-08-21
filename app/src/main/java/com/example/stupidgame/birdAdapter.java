package com.example.stupidgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class birdAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bird> arrayBird;

    public birdAdapter(Context context, int layout, ArrayList<Bird> arrayBird) {
        this.context = context;
        this.layout = layout;
        this.arrayBird = arrayBird;
    }

    @Override
    public int getCount() {
        return arrayBird.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgBird = view.findViewById(R.id.imageBird);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        Bird bird = arrayBird.get(i);
        holder.imgBird.setImageResource(bird.getImgRes());

        return view;
    }
    class ViewHolder {
        ImageView imgBird;
    }
}
