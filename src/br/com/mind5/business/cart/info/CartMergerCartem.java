package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CartMergerCartem extends InfoMergerTemplateV2_<CartInfo, CartemInfo> {

	@Override protected CartInfo writeHook(CartemInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.cartems.add(selectedInfo);

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CartemInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner &&
				selectedInfo.codUser  == baseInfo.codUser		);
	}
}
