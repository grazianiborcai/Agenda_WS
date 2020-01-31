package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerWeekday extends InfoMergerTemplate_<SchedineInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, WeekdayInfo> getVisitorHook() {
		return new SchedineVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
