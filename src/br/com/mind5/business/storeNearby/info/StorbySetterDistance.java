package br.com.mind5.business.storeNearby.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StorbySetterDistance extends InfoSetterTemplate<StorbyInfo> {
	
	@Override protected StorbyInfo setAttrHook(StorbyInfo recordInfo) {
		recordInfo.distanceKm = 0;
		
		if (isZeroDistance(recordInfo) == true)
			return recordInfo;
		
		recordInfo.distanceKm = computeDistance(recordInfo);		
		return recordInfo;
	}
	
	
	
	private boolean isZeroDistance(StorbyInfo recordInfo) {
		if (recordInfo.addressData == null)
			return true;
		
		if (recordInfo.addressData.latitude  == recordInfo.latitude	&&
			recordInfo.addressData.longitude == recordInfo.longitude	)
			return true;
		
		if (recordInfo.addressData.latitude  == 0 &&
			recordInfo.addressData.longitude == 0		)
			return true;
		
		if (recordInfo.latitude  == 0 &&
			recordInfo.longitude == 0		)
			return true;
		
		return false;
	}
	
	
	
	private double computeDistance(StorbyInfo recordInfo) {
		double theta = recordInfo.addressData.longitude - recordInfo.longitude;
		
		double dist = Math.sin(Math.toRadians(recordInfo.addressData.latitude)) 
				    * Math.sin(Math.toRadians(recordInfo.latitude)) 
				    + Math.cos(Math.toRadians(recordInfo.addressData.latitude)) 
				    * Math.cos(Math.toRadians(recordInfo.latitude)) 
				    * Math.cos(Math.toRadians(theta));
		
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;	
		dist = dist * 1.609344;

		dist = Math.floor(dist * 100) / 100;
		return dist;
	}
}
