package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerMatlis extends InfoMergerTemplate_<SchedineInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, MatlisInfo> getVisitorHook() {
		return new SchedineVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
