package br.com.mind5.business.scheduleSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedarchMergerToSelect extends InfoMergerTemplate_<SchedarchInfo, SchedarchInfo> {

	@Override protected InfoMergerVisitor_<SchedarchInfo, SchedarchInfo> getVisitorHook() {
		return new SchedarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedarchInfo> getUniquifierHook() {
		return new SchedarchUniquifier();
	}
}
