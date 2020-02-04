package br.com.mind5.business.cart.info;

import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CartMergerToUpdate extends InfoMergerTemplateV2_<CartInfo, CartInfo> {

	@Override protected CartInfo writeHook(CartInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.codUser = selectedInfo.codUser;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CartInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
