package br.com.mind5.business.cartReserveConflict.info;

import br.com.mind5.info.InfoPrunerSingleVisitor;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartercoVisiPruneUsername implements InfoPrunerSingleVisitor<CartercoInfo, UsernameInfo> {
	
	@Override public boolean pruneRecord(CartercoInfo baseInfo, UsernameInfo selectedInfo) {
		if (baseInfo.codOwner == selectedInfo.codOwner &&
			baseInfo.codUser  == selectedInfo.codUser 		)
			
			return true;
		
		return false;
	}



	@Override public boolean shouldPrune(CartercoInfo baseInfo, UsernameInfo selectedInfo) {
		return true;
	}
}
