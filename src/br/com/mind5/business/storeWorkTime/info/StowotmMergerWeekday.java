package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotmMergerWeekday extends InfoMergerTemplate_<StowotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<StowotmInfo, WeekdayInfo> getVisitorHook() {
		return new StowotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
