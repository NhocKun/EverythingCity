package com.kun.everythingcity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kun.everythingcity.Adapter.PlaceDetailAdapter;
import com.kun.everythingcity.Common.Common;
import com.kun.everythingcity.Common.Constants;
import com.kun.everythingcity.Common.JSONParser;
import com.kun.everythingcity.Common.MarginDecoration;
import com.kun.everythingcity.Common.RecyclerItemClickListener;
import com.kun.everythingcity.Model.PlaceDetailInfo;
import com.kun.everythingcity.Parser.Parser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListPlaceByTypeActivity extends AppCompatActivity {

    private RecyclerView rc;
    private SwipeRefreshLayout swipeContainer;
    private Toolbar toolbar;
    private double latitude, longtitude;
    private String query;
    private List<PlaceDetailInfo> lstPlaceDetail = new ArrayList<>();
    private PlaceDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_place_by_type);
        initToolbar();
        initData();
        initSwipeLayout();
        initRecycleView();
        handleAction();
        new getNearbyPlace().execute();
    }

    void initData() {
        Bundle intent = getIntent().getExtras();
        latitude = intent.getDouble(Constants.LATITUDE);
        longtitude = intent.getDouble(Constants.LONGTITUDE);
        query = intent.getString(Constants.QUERY);
        String title = intent.getString(Constants.TYPE);
        setTitle(title);
    }

    void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    void initRecycleView() {
        rc = (RecyclerView) findViewById(R.id.rc);
        rc.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
        rc.addItemDecoration(new MarginDecoration());
        adapter = new PlaceDetailAdapter(ListPlaceByTypeActivity.this, lstPlaceDetail);
        rc.setAdapter(adapter);
    }

    void initSwipeLayout() {
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.sw);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                lstPlaceDetail.clear();
                new getNearbyPlace().execute();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    void handleAction() {
        rc.addOnItemTouchListener(new RecyclerItemClickListener(ListPlaceByTypeActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (!swipeContainer.isRefreshing()) {
                    PlaceDetailInfo info = lstPlaceDetail.get(position);
                    if (info == null || info.getId().equals(""))
                        Toast.makeText(ListPlaceByTypeActivity.this, getString(R.string.cannotrestrivingdata), Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(ListPlaceByTypeActivity.this, DetailPlaceActivity.class);
                        intent.putExtra(Constants.INFO, info);
                        startActivity(intent);
                    }
                }
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    class getNearbyPlace extends AsyncTask<Void, Void, JSONObject> {

        @Override
        protected void onPreExecute() {
            swipeContainer.setRefreshing(true);
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            String urlRequest = Common.GetNearbyUrl(Double.toString(latitude), Double.toString(longtitude), query);
            JSONParser parser = new JSONParser();
            return parser.makeHttpRequest(urlRequest, "POST", null);
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            swipeContainer.setRefreshing(false);
            if (jsonObject != null) {
                List<PlaceDetailInfo> l = Parser.DetailPlaceParser(jsonObject);
                if (l != null && l.size() > 0)
                    lstPlaceDetail.addAll(l);
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(ListPlaceByTypeActivity.this, "Have error!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
