package com.eliseche.drinkingtime.ui.tool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.eliseche.drinkingtime.DrinkingTimeConstant;
import com.eliseche.drinkingtime.R;
import com.eliseche.drinkingtime.api.model.Tool;
import com.eliseche.drinkingtime.api.provider.ToolProvider;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;

@EActivity(R.layout.activity_tool)
public class ToolActivity extends AppCompatActivity {
    private Tool tool;

    @Extra
    String toolId;

    @Bean
    ToolProvider toolProvider;

    @ViewById(R.id.activity_tool_name)
    TextView tooName;

    @ViewById(R.id.activity_tool_image)
    ImageView toolIamge;

    @ViewById(R.id.activity_tool_description)
    TextView toolDescription;

    @AfterViews
    void afterViews() {
        // Toolbar
        getSupportActionBar().setTitle(R.string.tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadTool();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Background
    void loadTool() {
        try {
            tool = toolProvider.getTool(toolId);
            updateUi();
        } catch (IOException e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }
    }

    @UiThread
    void updateUi() {
        // Tool Name, Image and Description
        tooName.setText(tool.getName());
        ImageLoader.getInstance().displayImage(DrinkingTimeConstant.assets + "/tools/" + tool.getId() + ".png", toolIamge);
        toolDescription.setText(tool.getDescription());
    }
}
