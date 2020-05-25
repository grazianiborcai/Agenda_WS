package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedeekdatMergerMonth extends InfoMergerTemplate_<SchedeekdatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor_<SchedeekdatInfo, MonthInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
