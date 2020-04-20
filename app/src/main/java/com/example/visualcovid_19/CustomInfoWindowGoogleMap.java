package com.example.visualcovid_19;

 import android.app.Activity;
         import android.content.Context;
         import android.view.View;
 import android.widget.TextView;

         import com.google.android.gms.maps.GoogleMap;
         import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowGoogleMap(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.marker_info_window, null);

        TextView total = view.findViewById(R.id.totalCasesMarker);
        TextView active = view.findViewById(R.id.activeCases);
        TextView recovered = view.findViewById(R.id.recoveredCases);
        TextView fatal = view.findViewById(R.id.fatalCases);
        TextView countryName = view.findViewById(R.id.countryName);


        MarkerInfoWindowData infoWindowData = (MarkerInfoWindowData) marker.getTag();

        total.setText(infoWindowData.getTotalCases());
        active.setText(infoWindowData.getActiveCases());
        recovered.setText(infoWindowData.getRecoveredCases());
        fatal.setText(infoWindowData.getFatalCases());
        countryName.setText(infoWindowData.getCountryName());

        return view;
    }
}