package com.eliseche.drinkingtime.ui.drink;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eliseche.drinkingtime.R;
import com.eliseche.drinkingtime.api.model.Drink;
import com.eliseche.drinkingtime.api.model.DrinkResult;
import com.eliseche.drinkingtime.api.provider.DrinkProvider;
import com.eliseche.drinkingtime.helpers.StringUtil;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.ArrayList;

@EFragment(R.layout.fragment_drink)
public class DrinkFragment extends Fragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, SearchView.OnQueryTextListener {
    private DrinkResult drinkResult = null;
    private DrinkAdapter adapterDrink;
    private ProgressDialog progressDialog;
    private boolean isLoading = false;

    @ViewById(R.id.fragment_drink_listview)
    ListView listViewDrinks;

    @Bean
    DrinkProvider drinkProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @AfterViews
    void afterViews() {
        // Set ListView
        adapterDrink = new DrinkAdapter(getActivity());
        listViewDrinks.setAdapter(adapterDrink);

        // Set Progress
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getResources().getString(R.string.load_drinks));
        progressDialog.setCancelable(false);

        // Set Listeners (Click and Scroll)
        listViewDrinks.setOnItemClickListener(this);
        listViewDrinks.setOnScrollListener(this);

        getData(null);
    }

    @Background
    void getData(String textToSearch) {
        try {
            loadProgress();

            if (StringUtil.isNullOrEmpty(textToSearch))
                drinkResult = drinkProvider.getDrinks(0, 25);
            else
                drinkResult = drinkProvider.quickSearchDrinks(textToSearch, 0, 25);

            updateUi();
        } catch (IOException e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }

        dismissProgress();
    }

    @Background
    void getMoreData() {
        try {
            if (drinkResult != null && drinkResult.getNext() != null) {
                loadProgress();
                drinkResult = drinkProvider.getNext(drinkResult, drinkResult.getNext());

                updateUi();
            }
        } catch (IOException e) {
            Log.e(getClass().getName(), e.getMessage(), e);
        }

        dismissProgress();
    }

    @UiThread
    void updateUi() {
        adapterDrink.updateData(drinkResult.getResult());
        adapterDrink.notifyDataSetChanged();
        dismissProgress();
    }

    @UiThread
    void loadProgress() {
        isLoading = true;

        progressDialog.show();
    }

    @UiThread
    void dismissProgress() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();

        isLoading = false;
    }

    // region OnItemClickListener
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Drink drink = (Drink) adapterDrink.getItem(i);
        DrinkDetailActivity_.intent(this).drink(drink).start();
    }
    // endregion

    // region OnQueryTextListener
    @Override
    public boolean onQueryTextSubmit(String query) {
        getData(query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (StringUtil.isNullOrEmpty(newText)) {
            // Remove data
            drinkResult = new DrinkResult();
            drinkResult.setResult(new ArrayList<Drink>());
            adapterDrink.updateData(drinkResult.getResult());

            updateUi();

            return true;
        }

        return false;
    }
    // endregion

    // region OnScrollListener
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0)
            if (!isLoading)
                getMoreData();
    }
    // endregion
}
