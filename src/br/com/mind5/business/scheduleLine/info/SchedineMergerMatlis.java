package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerMatlis extends InfoMergerTemplate<SchedineInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, MatlisInfo> getVisitorHook() {
		return new SchedineVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
