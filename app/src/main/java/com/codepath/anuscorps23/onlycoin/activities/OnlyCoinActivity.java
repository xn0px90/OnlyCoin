package com.codepath.anuscorps23.onlycoin.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.codepath.anuscorps23.onlycoin.R;
import com.codepath.anuscorps23.onlycoin.adapters.OnlyCoinAdapter;
import com.codepath.anuscorps23.onlycoin.models.OnlyCoinCreditCards;
import com.codepath.anuscorps23.onlycoin.network.NetworkConnectivity;
import com.codepath.anuscorps23.onlycoin.network.OnlyCoinHttpRequests;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;


public class OnlyCoinActivity extends ActionBarActivity {

    private ListView lvCreditCards;
    private OnlyCoinAdapter adapter;
    private ArrayList<OnlyCoinCreditCards> myCards;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_coin);


        // Internet connection check
        if(!NetworkConnectivity.isNetworkAvailable(getApplicationContext()))
        {
            Toast.makeText(OnlyCoinActivity.this, "Not connected to the Internet", Toast.LENGTH_SHORT).show();

        }

        // Initial set up
        setUpViewsAndOtherThings();
        myCards = new ArrayList<>();
        adapter = new OnlyCoinAdapter(this, myCards);
        lvCreditCards.setAdapter(adapter);

        // Get JSON response
        url = "https://s3.amazonaws.com/mobile.coin.vc/ios/assignment/data.json" ;
        getJSONResponse(url);

    }


    private void getJSONResponse(String url) {
        // Now we can execute the long-running task at any time.
        JSONArray jsonArray = null;

        try {
            jsonArray = new OnlyCoinHttpRequests().execute(url).get();

            if(jsonArray != null)
            {
                adapter.clear();
                myCards.clear();
                myCards.addAll(OnlyCoinCreditCards.fromJSON(jsonArray));

                // Sort elements based on "created date"
                Collections.sort(myCards);

                // Update adapter
                adapter.notifyDataSetChanged();
            }
            else
            {
                if(!NetworkConnectivity.isNetworkAvailable(getApplicationContext()))
                {
                    Toast.makeText(OnlyCoinActivity.this, "Not connected to the Internet", Toast.LENGTH_SHORT).show();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private void setUpViewsAndOtherThings()
    {
        lvCreditCards = (ListView) findViewById(R.id.lvCreditCards);
        setActionBarItems();
    }


    private void setActionBarItems()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_only_coin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
