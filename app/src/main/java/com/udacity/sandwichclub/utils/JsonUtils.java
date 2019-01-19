package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {
        Sandwich exSandwich = null;

        try {
            // Create a JSONObject from the json string
            JSONObject selectedSandwichJsonObject = new JSONObject(json);

            JSONObject name = selectedSandwichJsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");
            Log.i("mainName", mainName);
            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");

            List<String> alsoKnownAsArraylist = new ArrayList<String>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                String alsoKnownAs = alsoKnownAsArray.getString(i);
                alsoKnownAsArraylist.add(alsoKnownAs);
            }
            Log.i("alsoKnownAsArraylist", alsoKnownAsArraylist.toString());

            String placeOfOrigin = selectedSandwichJsonObject.getString("placeOfOrigin");
            Log.i("placeOfOrigin", placeOfOrigin);
            String description = selectedSandwichJsonObject.getString("description");
            String image = selectedSandwichJsonObject.getString("image");
            JSONArray ingredientsArray = selectedSandwichJsonObject.getJSONArray("ingredients");

            List<String> ingredientsArraylist = new ArrayList<String>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                String ingredients = ingredientsArray.getString(i);
                alsoKnownAsArraylist.add(ingredients);
            }
            Log.i("ingredientsArraylist", ingredientsArraylist.toString());
            exSandwich = new Sandwich(mainName, alsoKnownAsArraylist, placeOfOrigin, description, image, ingredientsArraylist);


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }


        return exSandwich;
    }

}