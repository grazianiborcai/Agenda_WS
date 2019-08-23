package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerEmplis extends InfoMergerTemplate<SchedineInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, EmplisInfo> getVisitorHook() {
		return new SchedineVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
