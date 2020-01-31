package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekdatMergerToSelect extends InfoMergerTemplate_<SchedeekdatInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor_<SchedeekdatInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekdatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekdatInfo> getUniquifierHook() {
		return new SchedeekdatUniquifier();
	}
}
