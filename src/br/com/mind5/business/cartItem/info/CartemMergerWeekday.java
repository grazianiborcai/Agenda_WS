package br.com.mind5.business.cartItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class CartemMergerWeekday extends InfoMergerTemplate_<CartemInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<CartemInfo, WeekdayInfo> getVisitorHook() {
		return new CartemVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<CartemInfo> getUniquifierHook() {
		return new CartemUniquifier();
	}
}
