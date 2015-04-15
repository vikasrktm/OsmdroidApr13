package com.riktamtech.osmdroidapr13;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem; 

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends Activity{
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            MapView mapView = new MapView(this, 256); //constructor
//            mapView.setClickable(true);
//
//            mapView.setBuiltInZoomControls(true);
//            setContentView(mapView); //displaying the MapView
//            mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
//            mapView.getController().setZoom(5); //set initial zoom-level, depends on your need
//            mapView.getController().setCenter(new GeoPoint(23,79));
//            mapView.setUseDataConnection(true);
//            mapView.setMultiTouchControls(true);
//        }


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView map = new MapView(this, 256);
        setContentView(map);

        map.setTileSource(new XYTileSource("MapQuest",
                ResourceProxy.string.mapquest_osm, 0, 18, 256, ".png", new String[] {
                "http://otile1.mqcdn.com/tiles/1.0.0/map/",
                "http://otile2.mqcdn.com/tiles/1.0.0/map/",
                "http://otile3.mqcdn.com/tiles/1.0.0/map/",
                "http://otile4.mqcdn.com/tiles/1.0.0/map/"}));
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        map.setUseDataConnection(false); //optional, but a good way to prevent loading from the network and test your zip loading.
        IMapController mapController = map.getController();
        mapController.setZoom(5);
        GeoPoint startPoint = new GeoPoint(17.4302,78.44493);
        mapController.setCenter(startPoint);
    }

}