package br.com.gda.business.employeeWorkTimeOutlier.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwoutMergerToSelect extends InfoMergerTemplate<EmpwoutInfo, EmpwoutInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, EmpwoutInfo> getVisitorHook() {
		return new EmpwoutVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
