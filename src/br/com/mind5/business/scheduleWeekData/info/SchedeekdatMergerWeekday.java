package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekdatMergerWeekday extends InfoMergerTemplate<SchedeekdatInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, WeekdayInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
