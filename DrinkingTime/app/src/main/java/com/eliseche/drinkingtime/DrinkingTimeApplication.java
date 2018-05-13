package com.eliseche.drinkingtime;

import android.app.Application;
import android.content.Context;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DrinkingTimeApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        DrinkingTimeApplication.context = getApplicationContext();
        initImageLoader(context);
    }

    private void initImageLoader(Context context) {
        // Image Loader cache configuration
        final DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .cacheOnDisk(true)
                //.showImageOnLoading(R.mipmap.ic_empty_image)
                .build();

        // Create config with options
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(config);
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        DrinkingTimeApplication.context = context;
    }
}
