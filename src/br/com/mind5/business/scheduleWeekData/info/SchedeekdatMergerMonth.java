package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekdatMergerMonth extends InfoMergerTemplate<SchedeekdatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, MonthInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
