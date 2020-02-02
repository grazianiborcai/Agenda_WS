package br.com.mind5.business.cart.info;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.info.InfoMergerTemplateV2;

final class CartMergerFeewner extends InfoMergerTemplateV2<CartInfo, FeewnerInfo> {

	@Override protected CartInfo writeHook(FeewnerInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.feeService = selectedInfo.price;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(FeewnerInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codOwner == baseInfo.codOwner	&&
				selectedInfo.codCurr.equals(baseInfo.codCurr));
	}
}
