package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerDuple extends InfoMergerTemplate<SchedineInfo, SchedarchInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedarchInfo> getVisitorHook() {
		return new SchedineVisiMergeDuple();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
