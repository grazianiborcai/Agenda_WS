package br.com.gda.business.employeeWorkTimeOutlier.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwoutMergerEmplis extends InfoMergerTemplate<EmpwoutInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, EmplisInfo> getVisitorHook() {
		return new EmpwoutVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
