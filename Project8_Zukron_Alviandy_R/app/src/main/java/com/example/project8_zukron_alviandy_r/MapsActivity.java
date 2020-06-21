package com.example.project8_zukron_alviandy_r;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMarkerClickListener {
    private final int REQUEST_LOCATION_PERMISSION = 1;
    private MarkerOptions markerOptions = new MarkerOptions();
    private ArrayList<LatLng> latLngs = new ArrayList<>();
    private GoogleMap mMap;
    private JSONArray result;
    private static final float INITIAL_ZOOM = 10f;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private final static String URL = "http://zera-smansa.herokuapp.com/add_marker.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.maps_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng pnp = new LatLng(-0.9137739, 100.4640976);
        latLngs.add(new LatLng(-0.9021133, 100.3489041)); // Basko Grand Mall
        latLngs.add(new LatLng(-0.9502594, 100.353474)); // Ramayana
        latLngs.add(new LatLng(-0.7872877, 100.28059)); // BIM
        latLngs.add(new LatLng(-0.847585, 100.2866828)); // Pantai Tabing

        mMap.addMarker(new MarkerOptions().position(pnp).title("Politeknik Negeri Padang"));
        mMap.addMarker(new MarkerOptions().position(latLngs.get(0)).title("Basko Grand Mall"));
        mMap.addMarker(new MarkerOptions().position(latLngs.get(1)).title("Ramayana"));
        mMap.addMarker(new MarkerOptions().position(latLngs.get(2)).title("BIM"));
        mMap.addMarker(new MarkerOptions().position(latLngs.get(3)).title("Pantai Tabing"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pnp));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pnp, INITIAL_ZOOM));

        for (LatLng point : latLngs) {
            markerOptions.position(point);
            markerOptions.title("Point of View");
            markerOptions.snippet("Tempat menarik di Kota Padang");
            googleMap.addMarker(markerOptions);
        }

        enableMyLocation();
        enableDropPin(mMap);
        enableLongClick(mMap);
        enableMapStyles(mMap);
        enableDynamicMarker();
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
    }

    private void enableDropPin(final GoogleMap map) {
        map.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest pointOfInterest) {
                Marker marker = map.addMarker(new MarkerOptions().position(pointOfInterest.latLng).title(pointOfInterest.name));
                marker.showInfoWindow();
            }
        });
    }

    private void enableLongClick(final GoogleMap map) {
        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                String snippet = String.format(Locale.getDefault(), getString(R.string.lat_long_snippet), latLng.latitude, latLng.latitude);
                map.addMarker(new MarkerOptions().position(latLng).title(getString(R.string.dropped_pin)).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            }
        });
    }

    private void enableMapStyles(GoogleMap googleMap) {
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.map_style));
            if (!success) {
                Log.e(TAG, "Style parsing gagal.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Tidak dapat menemukan style. Error: ", e);
        }
    }

    private void enableDynamicMarker() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("JSONResult", response.toString());
                        JSONObject jObj = null;
                        try {
                            jObj = new JSONObject(response);
                            result = jObj.getJSONArray("LOCATION");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject jsonObject1 = result.getJSONObject(i);
                                String lat_i = jsonObject1.getString("latitude");
                                String long_i = jsonObject1.getString("longitude");
                                String locationName = jsonObject1.getString("location_name");
                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(Double.parseDouble(lat_i), Double.parseDouble(long_i)))
                                        .title(Double.valueOf(lat_i).toString() + "," + Double.valueOf(long_i).toString())
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                        .snippet(locationName)
                                );
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-0.9021187, 100.3489041), 11.0f));
                            }

                        } catch (NullPointerException | JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MapsActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        int socketTimeout = 10000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
