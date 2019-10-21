package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmMergerWeekday extends InfoMergerTemplate<StowotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, WeekdayInfo> getVisitorHook() {
		return new StowotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
