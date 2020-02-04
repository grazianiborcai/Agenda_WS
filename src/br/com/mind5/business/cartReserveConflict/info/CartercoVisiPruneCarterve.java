package br.com.mind5.business.cartReserveConflict.info;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoPrunerVisitor;

final class CartercoVisiPruneCarterve implements InfoPrunerVisitor<CartercoInfo, CarterveInfo> {
	
	@Override public boolean pruneRecord(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		if (baseInfo.codOwner == selectedInfo.codOwner &&
			baseInfo.codUser  == selectedInfo.codUser 		)
			
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		return true;
	}
}
