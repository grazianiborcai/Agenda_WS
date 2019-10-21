package br.com.mind5.business.scheduleSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedarchMergerToSelect extends InfoMergerTemplate<SchedarchInfo, SchedarchInfo> {

	@Override protected InfoMergerVisitor<SchedarchInfo, SchedarchInfo> getVisitorHook() {
		return new SchedarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedarchInfo> getUniquifierHook() {
		return new SchedarchUniquifier();
	}
}
