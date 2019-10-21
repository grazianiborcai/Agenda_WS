package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonMergerEmplis extends InfoMergerTemplate<SchedmonInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, EmplisInfo> getVisitorHook() {
		return new SchedmonVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
