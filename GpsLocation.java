package com.example.safe.engine;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
public class GpsLocation {
	public interface LocationListenerWrap {
		void Listener(Location location,GpsLocation gpsg);
	}
	LocationManager manager;
	LocationListener locationListener ;
	private static Context context;
	private static GpsLocation instance;

	private GpsLocation() {
	}

	public static GpsLocation getGpsLocation(Context context) {
		if (GpsLocation.context == null) {
			GpsLocation.context = context;
			GpsLocation.instance = new GpsLocation();
		}
		return instance;
	}
	

	/**
	 * @param listener 一个回调 里面会传过来Location
	 */
	public void getLongitudeLatitude(final GpsLocation.LocationListenerWrap listener) {
		 manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		 locationListener =new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				listener.Listener(location,instance);
			}
		};

		// Register the listener with the Location Manager to receive location updates
		  manager.requestLocationUpdates(getProvider(), 0, 0, locationListener);
		//return null;

	}

	private String getProvider() {
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(true);
		criteria.setHorizontalAccuracy(Criteria.POWER_HIGH);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true);
		return manager.getBestProvider(criteria, true);
	}
	/**
	 * 停止信息的获取 可以在Listenr里调用 
	 */
	public void stop(){
		manager.removeUpdates(locationListener);
	}
}

