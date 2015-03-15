package com.kodepelangi.haltemap.service;

import android.app.Activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.kodepelangi.haltemap.entity.Halte;
import com.kodepelangi.haltemap.entity.Response;

/**
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class Map implements OnMapReadyCallback{

    /**
     * @var activity android.app.Activity
     */
    protected Activity activity;

    /**
     * @var response com.kodepelangi.haltemap.entity.Response
     */
    protected Response response;

    public Map(Activity activity, Response response){
        this.activity = activity;
        this.response = response;
    }
    /**
     *
     * @param map com.google.android.gms.maps.GoogleMap
     * @return void
     */
    @Override
    public void onMapReady(GoogleMap map) {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
