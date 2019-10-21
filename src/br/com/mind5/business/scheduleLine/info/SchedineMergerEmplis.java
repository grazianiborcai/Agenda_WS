package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerEmplis extends InfoMergerTemplate<SchedineInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, EmplisInfo> getVisitorHook() {
		return new SchedineVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
