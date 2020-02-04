package br.com.mind5.business.cartReserveConflict.info;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CartercoMergerCarterve extends InfoMergerTemplateV2_<CartercoInfo, CarterveInfo> {

	@Override protected CartercoInfo writeHook(CarterveInfo selectedInfo, CartercoInfo baseInfo) {
		return CartercoInfo.copyFrom(selectedInfo);
	}
	
	
	
	@Override protected boolean shouldWriteHook(CarterveInfo selectedInfo, CartercoInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
