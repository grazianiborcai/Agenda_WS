package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedonthatMergerWeekday extends InfoMergerTemplate<SchedonthatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedonthatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
