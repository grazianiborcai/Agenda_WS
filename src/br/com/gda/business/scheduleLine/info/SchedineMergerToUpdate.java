package br.com.gda.business.scheduleLine.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerToUpdate extends InfoMergerTemplate<SchedineInfo, SchedineInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedineInfo> getVisitorHook() {
		return new SchedineVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
