package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonMergerEmplis extends InfoMergerTemplate_<SchedmonInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<SchedmonInfo, EmplisInfo> getVisitorHook() {
		return new SchedmonVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
