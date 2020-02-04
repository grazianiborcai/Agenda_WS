package br.com.mind5.business.cartReserve.info;

import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CarterveMergerToSelect extends InfoMergerTemplateV2_<CarterveInfo, CarterveInfo> {

	@Override protected CarterveInfo writeHook(CarterveInfo selectedInfo, CarterveInfo baseInfo) {
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		return selectedInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CarterveInfo selectedInfo, CarterveInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
