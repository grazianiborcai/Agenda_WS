package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class SchedeekdatMergerWeekday extends InfoMergerTemplate_<SchedeekdatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<SchedeekdatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
