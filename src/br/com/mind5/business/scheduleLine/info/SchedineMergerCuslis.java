package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerCuslis extends InfoMergerTemplate_<SchedineInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, CuslisInfo> getVisitorHook() {
		return new SchedineVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
