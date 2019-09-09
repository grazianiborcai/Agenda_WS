package br.com.gda.business.scheduleWeekData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekdatMergerToSelect extends InfoMergerTemplate<SchedeekdatInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
