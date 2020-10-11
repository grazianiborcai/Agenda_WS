package br.com.mind5.business.storeNearby.info;

import br.com.mind5.info.InfoPrunerSingleVisitor;

final class StorbyVisiPruneDistance50 implements InfoPrunerSingleVisitor<StorbyInfo, StorbyInfo> {
	
	@Override public boolean pruneRecord(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		
		if (baseInfo.distanceKm > 50)
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(StorbyInfo baseInfo, StorbyInfo selectedInfo) {
		return baseInfo.equals(selectedInfo);
	}
}
