package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CartemMergerWeekday extends InfoMergerTemplate<CartemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, WeekdayInfo> getVisitorHook() {
		return new CartemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
