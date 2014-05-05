AndroidLocation
===============

docs
GpsLocation g=GpsLocation.getGpsLocation(this);
	g.getLongitudeLatitude(new LocationListenerWrap() {

	@Override
	public void Listener(Location location,	GpsLocation gpsg) {
		// TODO Auto-generated method stub
		String aa=location.getLongitude()+":"+location.getLatitude();
		gpsg.stop();
		System.out.println(aa);
	}


});
