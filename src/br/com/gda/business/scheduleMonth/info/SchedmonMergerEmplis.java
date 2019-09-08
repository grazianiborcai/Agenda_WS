package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedmonMergerEmplis extends InfoMergerTemplate<SchedmonInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, EmplisInfo> getVisitorHook() {
		return new SchedmonVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
