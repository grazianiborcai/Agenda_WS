package br.com.gda.business.storeWorkTime.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StowotmMergerWeekday extends InfoMergerTemplate<StowotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, WeekdayInfo> getVisitorHook() {
		return new StowotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
