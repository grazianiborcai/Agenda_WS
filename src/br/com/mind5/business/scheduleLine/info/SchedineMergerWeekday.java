package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerWeekday extends InfoMergerTemplate<SchedineInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, WeekdayInfo> getVisitorHook() {
		return new SchedineVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
