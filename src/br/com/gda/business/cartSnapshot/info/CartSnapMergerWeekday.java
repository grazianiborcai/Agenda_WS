package br.com.gda.business.cartSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger_;

final class CartSnapMergerWeekday extends InfoMerger_<CartSnapInfo, WeekdayInfo, CartSnapInfo> {
	public CartSnapInfo merge(WeekdayInfo sourceOne, CartSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CartSnapVisitorWeekday());
	}
	
	
	
	public List<CartSnapInfo> merge(List<WeekdayInfo> sourceOnes, List<CartSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CartSnapVisitorWeekday());
	}
}
