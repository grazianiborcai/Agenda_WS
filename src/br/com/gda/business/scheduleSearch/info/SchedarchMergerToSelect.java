package br.com.gda.business.scheduleSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedarchMergerToSelect extends InfoMergerTemplate<SchedarchInfo, SchedarchInfo> {

	@Override protected InfoMergerVisitor<SchedarchInfo, SchedarchInfo> getVisitorHook() {
		return new SchedarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedarchInfo> getUniquifierHook() {
		return new SchedarchUniquifier();
	}
}
