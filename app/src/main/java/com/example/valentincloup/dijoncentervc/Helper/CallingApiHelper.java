package com.example.valentincloup.dijoncentervc.Helper;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.valentincloup.dijoncentervc.MainActivity;
import com.example.valentincloup.dijoncentervc.Model.PointOfInterest;
import com.example.valentincloup.dijoncentervc.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Valentin CLOUP on 08/09/2017.
 */

public class CallingApiHelper extends AsyncTask<Void, Void, String>
{
    private Exception exception;

    protected void onPreExecute() {
        //progressBar.setVisibility(View.VISIBLE);
        //responseView.setText("");
    }

    protected String doInBackground(Void... urls) {
        String jsonStr ="";
        try {
            URL url = new URL("https://my-json-server.typicode.com/lpotherat/pois/pois");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {

                connection.connect();
                InputStream inputStream = connection.getInputStream();


                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonStr.concat(line);
                }

                return jsonStr;
            }
            finally{
                connection.disconnect();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(String response)
    {
        try
        {
            ArrayList<PointOfInterest> lesPOI = new ArrayList<>();

            JSONObject jsonPOI = new JSONObject(response);

            int id = jsonPOI.getInt("id");
            String type = jsonPOI.getString("type");
            String name = jsonPOI.getString("name");

            PointOfInterest poi = new PointOfInterest();
            poi.setId(id);
            poi.setType(type);
            poi.setName(name);

            lesPOI.add(poi);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

