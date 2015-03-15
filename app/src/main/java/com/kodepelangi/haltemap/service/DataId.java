package com.kodepelangi.haltemap.service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.kodepelangi.haltemap.entity.Halte;
import com.kodepelangi.haltemap.entity.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Service to fetch data from data.go.id
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class DataId extends AsyncTask<URL, Integer, Response>{

    /**
     * @var response com.kodepelangi.haltemap.entity.Response
     */
    protected Response response;

    /**
     * @var client org.apache.http.client.HttpClient
     */
    protected HttpClient client;

    /**
     * @var httpResponse org.apache.http.HttpResponse
     */
    protected HttpResponse httpResponse;

    /**
     * @var gson com.google.gson.Gson
     */
    protected Gson gson;

    public DataId(){
        this.client = new DefaultHttpClient();
        this.response = new Response();
        this.gson = new Gson();
    }

    @Override
    protected Response doInBackground(URL... urls) {
        HttpGet request = new HttpGet(urls[0].toString());
        StringBuilder builder = new StringBuilder();
        try {
            this.httpResponse = this.client.execute(request);
            HttpEntity httpEntity = this.httpResponse.getEntity();
            InputStream content = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;

            while((line = reader.readLine()) != null){
                builder.append(line);
            }

            this.response = this.gson.fromJson(builder.toString(), Response.class);
            for(Halte halte: this.response.getResult()){
                Log.i("Halte", halte.getHalteName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.response;
    }
}
