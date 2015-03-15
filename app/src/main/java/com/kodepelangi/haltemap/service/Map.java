package com.kodepelangi.haltemap.service;

import android.app.Activity;

import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
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
        this.mapListener();
    }

    protected void mapConfig(){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    /**
     * Build markers
     */
    protected void buildMarkers(){
        int index = 0;
        LatLngBounds.Builder b = new LatLngBounds.Builder();
        for(Halte halte: this.response.getResult()){
            if(halte.getLong() != 0 && halte.getLat() != 0){
                LatLng position = new LatLng(halte.getLat(), halte.getLong());
                this.map.addMarker(
                        new MarkerOptions()
                                .position(position)
                                .title(Integer.toString(index++))
                                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus))
                );

                b.include(position);
            }
        }

        LatLngBounds bounds = b.build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 20,20,5);
        this.map.animateCamera(cameraUpdate);
    }

    protected void mapListener(){
        this.map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                View view = activity.getLayoutInflater().inflate(R.layout.info_window, null);

                TextView tvHalteName = (TextView) view.findViewById(R.id.tv_halte_name);
                TextView tvKoridorNo = (TextView) view.findViewById(R.id.tv_koridor_no);
                TextView tvHalteType = (TextView) view.findViewById(R.id.tv_halte_type);

                Halte halte = response.getResult().get(Integer.parseInt(marker.getTitle()));
                tvHalteName.setText(String.format("Halte Name : %s", halte.getHalteName()));
                tvKoridorNo.setText(String.format("Koridor No. : %s", halte.getKoridorNo()));
                tvHalteType.setText(String.format("Halte Type : %s", Integer.toString(halte.getHalteType())));

                return view;
            }
        });
    }
}
