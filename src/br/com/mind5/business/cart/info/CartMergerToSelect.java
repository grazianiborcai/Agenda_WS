package br.com.mind5.business.cart.info;

import br.com.mind5.info.InfoMergerTemplateV2;

final class CartMergerToSelect extends InfoMergerTemplateV2<CartInfo, CartInfo> {

	@Override protected CartInfo writeHook(CartInfo selectedInfo, CartInfo baseInfo) {
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		return selectedInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CartInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
