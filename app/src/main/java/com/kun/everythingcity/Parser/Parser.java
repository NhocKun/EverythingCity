package com.kun.everythingcity.Parser;

import android.util.Log;

import com.kun.everythingcity.Model.PlaceDetailInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kun on 23,April,2016
 * Viegrid JSC, Hanoi.
 */
public class Parser {

    public static List<PlaceDetailInfo> DetailPlaceParser(JSONObject jsonObject) {
        try {
            List<PlaceDetailInfo> lst = new ArrayList<>();
            JSONArray resultArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                final JSONObject resultObject = resultArray.getJSONObject(i);
                PlaceDetailInfo info = new PlaceDetailInfo();
                try {
                    info.setName(resultObject.getString("name"));
                } catch (Exception e) {
                    Log.e("Err", e.getMessage());
                }
                try {
                    info.setFormatted_address(resultObject.getString("vicinity"));
                } catch (Exception e) {
                    Log.e("Err", e.getMessage());
                }

                try {
                    info.setId(resultObject.getString("place_id"));
                } catch (Exception e) {
                    Log.e("Err", e.getMessage());
                }
                try {
                    info.setRating(resultObject.getString("rating"));
                } catch (Exception e) {
                    Log.e("Err", e.getMessage());
                }
                lst.add(info);
            }
            return lst;
        } catch (JSONException e) {
            Log.e("Err", e.getMessage());
            return null;
        }
    }
}
