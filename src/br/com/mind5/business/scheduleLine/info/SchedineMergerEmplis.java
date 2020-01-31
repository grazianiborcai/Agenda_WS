package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerEmplis extends InfoMergerTemplate_<SchedineInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, EmplisInfo> getVisitorHook() {
		return new SchedineVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
