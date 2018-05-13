package com.eliseche.drinkingtime.api.provider;

import com.eliseche.drinkingtime.DrinkingTimeConstant;
import com.eliseche.drinkingtime.api.model.Drink;
import com.eliseche.drinkingtime.api.model.DrinkResult;
import com.google.gson.Gson;

import org.androidannotations.annotations.EBean;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@EBean
public class DrinkProvider {
    OkHttpClient httpClient = new OkHttpClient();

    public DrinkResult getDrinks(int start, int pageSize) throws IOException {
        String url = DrinkingTimeConstant.drinks;
        url = url.replace("{start}", String.valueOf(start));
        url = url.replace("{pageSize}", String.valueOf(pageSize));

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (response != null) {
            DrinkResult  drinkResult = new Gson().fromJson(response.body().string(), DrinkResult.class);
            orderList(drinkResult.getResult());
            return drinkResult;
        }

        return null;
    }

    public DrinkResult quickSearchDrinks(String textToSearch, int start, int pageSize) throws IOException {
        String quickSearch = DrinkingTimeConstant.quickSearch;
        quickSearch = quickSearch.replace("{textToSearch}", textToSearch);
        quickSearch = quickSearch.replace("{start}", String.valueOf(start));
        quickSearch = quickSearch.replace("{pageSize}", String.valueOf(pageSize));

        Request request = new Request.Builder()
                .url(quickSearch)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (response != null) {
            DrinkResult drinkResult = new Gson().fromJson(response.body().string(), DrinkResult.class);
            orderList(drinkResult.getResult());
            return drinkResult;
        }

        return null;
    }

    public DrinkResult getNext(DrinkResult drinkResult, String url) throws IOException {
        List<Drink> backupDrinks = drinkResult.getResult();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (response != null) {
            drinkResult = new Gson().fromJson(response.body().string(), DrinkResult.class);
            drinkResult.getResult().addAll(backupDrinks);
            orderList(drinkResult.getResult());
            return drinkResult;
        }

        return null;
    }

    private void orderList(List<Drink> drinks) {
        Collections.sort(drinks, new Comparator<Drink>() {
            @Override
            public int compare(final Drink drink1, final Drink drink2) {
                return drink1.getName().compareTo(drink2.getName());
            }
        });
    }
}
