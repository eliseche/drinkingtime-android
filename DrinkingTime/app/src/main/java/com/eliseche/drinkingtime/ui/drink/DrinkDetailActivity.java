package com.eliseche.drinkingtime.ui.drink;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eliseche.drinkingtime.DrinkingTimeConstant;
import com.eliseche.drinkingtime.R;
import com.eliseche.drinkingtime.api.model.Drink;
import com.eliseche.drinkingtime.api.model.DrinkIngredient;
import com.eliseche.drinkingtime.api.model.EntityReference;
import com.eliseche.drinkingtime.api.model.VideoReference;
import com.eliseche.drinkingtime.helpers.Display;
import com.eliseche.drinkingtime.helpers.Enums;
import com.eliseche.drinkingtime.ui.tool.ToolActivity_;
import com.eliseche.drinkingtime.ui.video.VideoActivity_;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_drink_detail)
public class DrinkDetailActivity extends AppCompatActivity {
    @Extra
    Drink drink;

    @ViewById(R.id.activity_drink_detail_name)
    TextView drinkName;

    @ViewById(R.id.activity_drink_detail_image)
    ImageView drinkImage;

    @ViewById(R.id.activity_drink_detail_description)
    TextView drinkDescription;

    @ViewById(R.id.activity_drink_detail_ingredients)
    LinearLayout containerIngredients;

    @ViewById(R.id.activity_drink_detail_tools_container)
    LinearLayout containerTools;

    @ViewById(R.id.activity_drink_detail_tools)
    LinearLayout tools;

    @ViewById(R.id.activity_drink_detail_videos)
    LinearLayout containerVideos;

    @AfterViews
    void afterViews() {
        // Toolbar
        getSupportActionBar().setTitle(R.string.drink_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateUi();
    }

    @UiThread
    void updateUi() {
        // Drink Name, Image and Description
        drinkName.setText(drink.getName());
        ImageLoader.getInstance().displayImage(DrinkingTimeConstant.assets + "/drinks/" + drink.getId() + ".png", drinkImage);
        drinkDescription.setText(drink.getDescriptionPlain());

        // Ingredients
        if (drink.getIngredients() != null)
            loadContainerIngredients();

        // Tools
        if (drink.getTools() != null && drink.getTools().size() > 0)
            loadContainerTools();
        else
            containerTools.setVisibility(View.GONE);

        // Videos
        if (drink.getVideos() != null && drink.getVideos().size() > 0)
            loadContainerVideos();
        else
            containerVideos.setVisibility(View.GONE);
    }

    // region Ingredients
    private void loadContainerIngredients() {
        for (DrinkIngredient ingredientType : drink.getIngredients()) {
            TextView ingredient = new TextView(this);
            ingredient.setText(ingredientType.getTextPlain());
            ingredient.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            containerIngredients.addView(ingredient);
        }
    }
    // endregion

    // region Tools
    private void loadContainerTools() {
        LinearLayout linearLayoutHorizontal = null;
        int step = 0;
        for (final EntityReference entityReference : drink.getTools()) {
            TextView tool = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5f);
            params.setMargins(Display.convertPixelToDp(5), Display.convertPixelToDp(5), Display.convertPixelToDp(5), Display.convertPixelToDp(5));
            tool.setLayoutParams(params);
            tool.setPadding(Display.convertPixelToDp(6), Display.convertPixelToDp(6), Display.convertPixelToDp(6), Display.convertPixelToDp(6));
            tool.setGravity(Gravity.CENTER);
            tool.setText(entityReference.getText());
            tool.setBackgroundResource(R.drawable.shape_button);
            tool.setTextColor(Color.WHITE);
            tool.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToolActivity_.intent(DrinkDetailActivity.this).flags(Intent.FLAG_ACTIVITY_NEW_TASK).toolId(entityReference.getId()).start();
                }

            });

            if (step % 2 == 0) {
                linearLayoutHorizontal = new LinearLayout(this);
                linearLayoutHorizontal.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayoutHorizontal.setWeightSum(1);
                tools.addView(linearLayoutHorizontal);
            }

            linearLayoutHorizontal.addView(tool);
            step++;
        }

        // If horizontalLayout has onlyt 1 child, add empty one to fill space and get width of 50%
        if (linearLayoutHorizontal.getChildCount() < 2)
            linearLayoutHorizontal.addView(new View(this));
    }
    // endregion

    // region Videos
    private void loadContainerVideos() {
        try {
            if (drink.getVideos() != null && drink.getVideos().size() > 0) {
                List<VideoReference> videoAssets = new ArrayList<>();
                List<VideoReference> videoYoutube = new ArrayList<>();

                for (VideoReference videoReference : drink.getVideos()) {
                    String videoType = videoReference.getType().toUpperCase();

                    if (Enums.VideoType.ASSETS == Enums.VideoType.valueOf(videoType))
                        videoAssets.add(videoReference);
                    else if (Enums.VideoType.YOUTUBE == Enums.VideoType.valueOf(videoType))
                        videoYoutube.add(videoReference);
                }

                if (videoAssets != null && videoAssets.size() > 0) {
                    for (VideoReference videoReference : videoAssets)
                        addVideo(videoReference);
                } else if (videoYoutube != null && videoYoutube.size() > 0) {
                    for (VideoReference videoReference : videoYoutube)
                        addVideo(videoReference);
                }
            }
        } catch (Exception e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }
    }

    private void addVideo(final VideoReference videoReference) {
        try {
            TextView video = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.5f);
            params.setMargins(Display.convertPixelToDp(5), 0, Display.convertPixelToDp(5), 0);
            video.setLayoutParams(params);
            video.setPadding(Display.convertPixelToDp(6), Display.convertPixelToDp(6), Display.convertPixelToDp(6), Display.convertPixelToDp(6));
            video.setGravity(Gravity.CENTER);
            video.setText(getResources().getString(R.string.watch_video));
            video.setBackgroundResource(R.drawable.shape_button);
            video.setTextColor(Color.WHITE);

            final String videoType = videoReference.getType().toUpperCase();
            final String videoUrl = getVideoUrl(videoReference);

            video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Enums.VideoType.ASSETS == Enums.VideoType.valueOf(videoType))
                        VideoActivity_.intent(DrinkDetailActivity.this).flags(Intent.FLAG_ACTIVITY_NEW_TASK).videoUrl(videoUrl).start();
                    else if (Enums.VideoType.YOUTUBE == Enums.VideoType.valueOf(videoType))
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)));
                }
            });

            containerVideos.addView(video);
        } catch (Exception e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }
    }

    private String getVideoUrl(VideoReference videoReference) {
        try {
            String videoType = videoReference.getType().toUpperCase();
            String videoUrl = null;

            if (Enums.VideoType.ASSETS == Enums.VideoType.valueOf(videoType))
                videoUrl = DrinkingTimeConstant.videosAssets;
            else if (Enums.VideoType.YOUTUBE == Enums.VideoType.valueOf(videoType))
                videoUrl = DrinkingTimeConstant.videosYoutube;

            if (videoUrl != null) {
                videoUrl = videoUrl.replace("{video}", videoReference.getVideo());
                return videoUrl;
            }
        } catch (Exception e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }

        return null;
    }
    // endregion
}
