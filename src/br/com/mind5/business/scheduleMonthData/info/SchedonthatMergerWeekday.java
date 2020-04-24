package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedonthatMergerWeekday extends InfoMergerTemplate_<SchedonthatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<SchedonthatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedonthatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
