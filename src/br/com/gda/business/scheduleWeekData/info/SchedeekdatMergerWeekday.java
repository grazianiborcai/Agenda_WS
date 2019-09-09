package br.com.gda.business.scheduleWeekData.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekdatMergerWeekday extends InfoMergerTemplate<SchedeekdatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
