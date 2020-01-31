package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerSchedinap extends InfoMergerTemplate_<SchedineInfo, SchedinapInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, SchedinapInfo> getVisitorHook() {
		return new SchedineVisiMergeSchedinap();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
