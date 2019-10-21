package br.com.mind5.business.employeeWorkTimeOutlier.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwoutMergerEmplis extends InfoMergerTemplate<EmpwoutInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, EmplisInfo> getVisitorHook() {
		return new EmpwoutVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
