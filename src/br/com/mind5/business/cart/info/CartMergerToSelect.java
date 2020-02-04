package br.com.mind5.business.cart.info;

import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CartMergerToSelect extends InfoMergerTemplateV2_<CartInfo, CartInfo> {

	@Override protected CartInfo writeHook(CartInfo selectedInfo, CartInfo baseInfo) {
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		return selectedInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CartInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
