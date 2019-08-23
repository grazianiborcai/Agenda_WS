package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerWeekday extends InfoMergerTemplate<SchedineInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, WeekdayInfo> getVisitorHook() {
		return new SchedineVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
