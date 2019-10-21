package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartemMergerWeekday extends InfoMergerTemplate<CartemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<CartemInfo, WeekdayInfo> getVisitorHook() {
		return new CartemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
