package br.com.mind5.business.cart.info;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.info.obsolete.InfoMergerTemplateV2_;

final class CartMergerCurrency extends InfoMergerTemplateV2_<CartInfo, CurrencyInfo> {

	@Override protected CartInfo writeHook(CurrencyInfo selectedInfo, CartInfo baseInfo) {
		baseInfo.txtCurr = selectedInfo.txtCurr;

		return baseInfo;
	}
	
	
	
	@Override protected boolean shouldWriteHook(CurrencyInfo selectedInfo, CartInfo baseInfo) {
		return (selectedInfo.codCurr.equals(baseInfo.codCurr));
	}
}
