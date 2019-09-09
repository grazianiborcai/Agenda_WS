package br.com.gda.business.scheduleWeekData.info;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekdatMergerMonth extends InfoMergerTemplate<SchedeekdatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, MonthInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
