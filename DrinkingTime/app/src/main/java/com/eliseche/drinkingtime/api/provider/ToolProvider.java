package com.eliseche.drinkingtime.api.provider;

import com.eliseche.drinkingtime.DrinkingTimeConstant;
import com.eliseche.drinkingtime.api.model.Tool;
import com.google.gson.Gson;

import org.androidannotations.annotations.EBean;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@EBean
public class ToolProvider {
    OkHttpClient httpClient = new OkHttpClient();

    public Tool getTool(String toolId) throws IOException {
        String urlTool = DrinkingTimeConstant.tool;
        urlTool = urlTool.replace("{toolId}", toolId);

        Request request = new Request.Builder()
                .url(urlTool)
                .build();

        Response response = httpClient.newCall(request).execute();
        if (response != null) {
            Tool tool = new Gson().fromJson(response.body().string(), Tool.class);
            return tool;
        }

        return null;
    }
}
