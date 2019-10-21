package br.com.mind5.business.employeeWorkTimeOutlier.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwoutMergerToSelect extends InfoMergerTemplate<EmpwoutInfo, EmpwoutInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, EmpwoutInfo> getVisitorHook() {
		return new EmpwoutVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
