package com.kodepelangi.haltemap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.MapFragment;
import com.kodepelangi.haltemap.entity.Response;
import com.kodepelangi.haltemap.service.DataId;
import com.kodepelangi.haltemap.service.Map;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    /**
     *
     * @param savedInstanceState android.os.Bundle
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create map fragment
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new Map(this, this.dataId()));
    }

    /**
     *
     * @return Response com.kodepelangi.haltemap.entity.Response
     */
    protected Response dataId(){
        DataId dataId = new DataId();
        Response response = new Response();
        try {
            dataId.execute(new URL("http://itsjakarta.com/map/its/halte"));
            response = dataId.get();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return response;
    }

    /**
     *
     * @param menu android.view.Menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *
     * @param item android.view.MenuItem
     * @return boolean
     */
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
