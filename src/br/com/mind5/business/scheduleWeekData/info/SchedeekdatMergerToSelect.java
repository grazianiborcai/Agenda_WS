package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekdatMergerToSelect extends InfoMergerTemplate<SchedeekdatInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor<SchedeekdatInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
