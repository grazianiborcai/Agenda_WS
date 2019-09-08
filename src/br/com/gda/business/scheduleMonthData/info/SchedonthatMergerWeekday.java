package br.com.gda.business.scheduleMonthData.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedonthatMergerWeekday extends InfoMergerTemplate<SchedonthatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedonthatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
