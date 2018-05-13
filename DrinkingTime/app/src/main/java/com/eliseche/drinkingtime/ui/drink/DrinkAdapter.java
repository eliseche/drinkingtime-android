package com.eliseche.drinkingtime.ui.drink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eliseche.drinkingtime.DrinkingTimeConstant;
import com.eliseche.drinkingtime.R;
import com.eliseche.drinkingtime.api.model.Drink;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends BaseAdapter {
    List<Drink> drinks = new ArrayList<>();
    LayoutInflater layoutInflater;

    public DrinkAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void updateData(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public int getCount() {
        return drinks.size();
    }

    @Override
    public Object getItem(int i) {
        return drinks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_drink_summary, viewGroup, false);
            holder = new ViewHolder();
            holder.drinkImage = (ImageView) view.findViewById(R.id.layout_drink_summary_drink_image);
            holder.drinkName = (TextView) view.findViewById(R.id.layout_drink_summary_drink_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Drink drink = (Drink) getItem(i);
        if (drink != null) {
            ImageLoader.getInstance().displayImage(DrinkingTimeConstant.assets + "/drinks/" + drink.getId() + ".png", holder.drinkImage);
            holder.drinkName.setText(drink.getName());
        }

        return view;
    }

    static class ViewHolder {
        ImageView drinkImage;
        TextView drinkName;
    }
}
