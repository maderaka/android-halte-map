package com.kodepelangi.haltemap.service;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kodepelangi.haltemap.R;
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
     * @var GoogleMap com.google.android.gms.maps.GoogleMap
     */
    protected GoogleMap map;

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
        this.map = map;
        this.mapConfig();
        this.buildMarkers();
    }

    protected void mapConfig(){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    protected void buildMarkers(){
        for(Halte halte: this.response.getResult()){
            if(halte.getLong() != 0 && halte.getLat() != 0){
                this.map.addMarker(
                        new MarkerOptions()
                        .position(new LatLng(halte.getLat(), halte.getLong()))
                        .title(halte.getHalteName())
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus))
                );
            }
        }
    }
}
