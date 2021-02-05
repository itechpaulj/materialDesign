package com.javinezpaul.materialdesign;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class background extends AsyncTask <String, Void, String> {
    // start executed
    AlertDialog dialog;
    Context context;

    public background (Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog  = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        dialog.setMessage(s);
        dialog.show();
    }

    //end executed
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String user = voids[0]; // input type {EditText}
        String pass = voids[1]; // input type {EditText}
        String conn = "http://localhost:8080/gportal/index.php"; // url address  terminal need {php -S localhost:8000}

        try {
            URL url = new URL(conn); // connection url
            HttpURLConnection http = (HttpURLConnection) url.openConnection(); // url Connection
            http.setRequestMethod("POST"); // post method in PHP $_POST['variable']
            http.setDoInput(true); // input
            http.setDoOutput(true); // output
            //getOutput data
            OutputStream ops = http.getOutputStream();
            //BufferedWriter
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+ URLEncoder.encode(user,"UTF-8")
                    +"&&"+URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            // close connection
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();
            //-----------------------
            //get Input data
            InputStream ips = http.getInputStream();
            //Buffered Reader
            BufferedReader reader= new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));

            //---------------------
            String line = "";
            while((line = reader.readLine()) != null )
            {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();


        }catch (MalformedURLException e){
            result = e.getMessage();
        }catch (IOException e){
            result = e.getMessage();
        }

        //return null;
        return  result;
    }
}
