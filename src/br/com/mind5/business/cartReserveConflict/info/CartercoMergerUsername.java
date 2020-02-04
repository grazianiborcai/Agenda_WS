package br.com.mind5.business.cartReserveConflict.info;

import br.com.mind5.info.InfoMergerTemplateV2;
import br.com.mind5.security.username.info.UsernameInfo;

final class CartercoMergerUsername extends InfoMergerTemplateV2<CartercoInfo, UsernameInfo> {

	@Override protected CartercoInfo writeHook(UsernameInfo selectedInfo, CartercoInfo baseInfo) {
		baseInfo.codUser = selectedInfo.codUser;
		
		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(UsernameInfo selectedInfo, CartercoInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner	&&
				selectedInfo.username.equals(baseInfo.username));
	}
}
