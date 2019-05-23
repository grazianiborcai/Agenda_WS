package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CartMergerWeekday extends InfoMergerTemplate<CartInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitorV2<CartInfo, WeekdayInfo> getVisitorHook() {
		return new CartVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<CartInfo> getUniquifierHook() {
		return new CartUniquifier();
	}
}
