package com.kodepelangi.haltemap.service;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class Map implements OnMapReadyCallback{

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
