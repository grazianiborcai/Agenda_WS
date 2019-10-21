package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerDuple extends InfoMergerTemplate<SchedineInfo, SchedarchInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedarchInfo> getVisitorHook() {
		return new SchedineVisiMergeDuple();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
