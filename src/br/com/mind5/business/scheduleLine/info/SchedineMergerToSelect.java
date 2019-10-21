package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerToSelect extends InfoMergerTemplate<SchedineInfo, SchedineInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, SchedineInfo> getVisitorHook() {
		return new SchedineVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
