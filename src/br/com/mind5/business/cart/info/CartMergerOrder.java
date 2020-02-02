package br.com.mind5.business.cart.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerTemplateV2;

final class CartMergerOrder extends InfoMergerTemplateV2<CartInfo, OrderInfo> {

	@Override protected CartInfo writeHook(OrderInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.codOrder = selectedInfo.codOrder;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(OrderInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner);
	}
}
