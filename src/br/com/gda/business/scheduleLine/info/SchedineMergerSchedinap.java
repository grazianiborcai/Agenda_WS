package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerSchedinap extends InfoMergerTemplate<SchedineInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedinapInfo> getVisitorHook() {
		return new SchedineVisiMergeSchedinap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
