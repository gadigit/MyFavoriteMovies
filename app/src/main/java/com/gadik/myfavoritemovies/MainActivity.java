package com.gadik.myfavoritemovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gadik.myfavoritemovies.NetworkUtils.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Replace the location for the Async call
        //new MovieDatabaseQueryTask().execute(url);
    }

    /** Creating the menu for the setting option **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.action_settings){
            //TODO: Replace toast with actual calling to the settings option
            Toast.makeText(this, "Here will be the settings options", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MovieDatabaseQueryTask extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String httpResponse = null;

            try {
                httpResponse = NetworkUtils.getResponseFromURL(url);
            } catch (IOException e){
                Log.e(TAG, "Failed to get response from url. URL: " + url);
                e.printStackTrace();
            }

            return httpResponse;
        }

        @Override
        protected void onPostExecute(String s) {
            if(s != null && !s.equals("")){
                //TODO: Implement
            }
        }
    }
}
