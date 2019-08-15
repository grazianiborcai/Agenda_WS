package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerCuslis extends InfoMergerTemplate<SchedineInfo, CuslisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, CuslisInfo> getVisitorHook() {
		return new SchedineVisiMergeCuslis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
