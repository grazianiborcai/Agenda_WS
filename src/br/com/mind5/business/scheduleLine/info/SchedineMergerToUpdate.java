package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerToUpdate extends InfoMergerTemplate_<SchedineInfo, SchedineInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, SchedineInfo> getVisitorHook() {
		return new SchedineVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
