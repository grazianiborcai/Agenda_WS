package br.com.mind5.business.storeNearby.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoPrunerSingleVisitor;

final class StorbyPrunerVisiEmpty implements InfoPrunerSingleVisitor<StorbyInfo, StorbyInfo> {
	
	@Override public boolean pruneRecord(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		
		if ( isGeoEmpty(baseInfo)  == true ||
			 isHashEmpty(baseInfo) == true	 )
			return true;
		
		return false;
	}
	
	
	
	private boolean isGeoEmpty(StorbyInfo baseInfo) {
		if ( baseInfo.latitude  == DefaultValue.geo() &&
			 baseInfo.longitude == DefaultValue.geo()	 )	
			return true;
		
		return false;
	}
	
	
	
	private boolean isHashEmpty(StorbyInfo baseInfo) {
		if ( baseInfo.geoHash03 == null )	
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		return baseInfo.equals(selectedInfo);
	}
}
