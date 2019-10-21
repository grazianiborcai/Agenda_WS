package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerSchedinap extends InfoMergerTemplate<SchedineInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedinapInfo> getVisitorHook() {
		return new SchedineVisiMergeSchedinap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
