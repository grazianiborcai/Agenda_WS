package br.com.gda.business.cartItem.info;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerTotAmount extends InfoMergerTemplate<CartInfo, TotAmountInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, TotAmountInfo> getVisitorHook() {
		return new CartVisiMergeTotAmount();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
