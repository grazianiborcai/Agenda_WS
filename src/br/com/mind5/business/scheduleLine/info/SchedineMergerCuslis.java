package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerCuslis extends InfoMergerTemplate<SchedineInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, CuslisInfo> getVisitorHook() {
		return new SchedineVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
