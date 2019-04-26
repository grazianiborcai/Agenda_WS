package br.com.gda.business.cart.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger_;

final class CartMergerWeekday extends InfoMerger_<CartInfo, WeekdayInfo, CartInfo> {
	public CartInfo merge(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartVisitorWeekday());
	}
	
	
	
	public List<CartInfo> merge(List<WeekdayInfo> sourceOnes, List<CartInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartVisitorWeekday());
	}
}
