package com.codepath.anuscorps23.onlycoin.models;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by anuscorps23 on 7/11/15.
 */
public class OnlyCoinCreditCards implements Comparable<OnlyCoinCreditCards>  {

    public String updated;
    public String card_number;
    public String background_image_url;
    public String last_name;
    public String expiration_date;
    public String created;
    public String guid;
    public String first_name;
    public Bitmap cardImage;


    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Bitmap getCardImage() {
        return cardImage;
    }

    public void setCardImage(Bitmap cardImage) {
        this.cardImage = cardImage;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBackground_image_url() {
        return background_image_url;
    }

    public void setBackground_image_url(String background_image_url) {
        this.background_image_url = background_image_url;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }


    public OnlyCoinCreditCards(JSONObject json)
    {

        try {
            this.updated = json.getString("updated");
            this.card_number = json.getString("card_number");
            this.background_image_url = json.getString("background_image_url");
            this.last_name = json.getString("last_name");
            this.expiration_date = json.getString("expiration_date");
            this.created = json.getString("created");
            this.guid = json.getString("guid");
            this.first_name = json.getString("first_name");

        } catch (JSONException e)
        {
            e.printStackTrace();
        }

    }


    public static ArrayList<OnlyCoinCreditCards> fromJSON(JSONArray array)
    {
        ArrayList<OnlyCoinCreditCards> results = new ArrayList<>();

        for(int i = 0; i < array.length(); i++)
        {
            try
            {
                results.add(new OnlyCoinCreditCards(array.getJSONObject(i)));

            }catch(JSONException e)
            {
                e.printStackTrace();
            }
        }

        return results;
    }


    // To sort credit cards based on date the user entered the cc details

    @Override
    public int compareTo(OnlyCoinCreditCards card) {
        return getCreated().compareTo(card.getCreated());
    }



}
