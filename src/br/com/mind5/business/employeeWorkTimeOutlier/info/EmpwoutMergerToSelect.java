package br.com.mind5.business.employeeWorkTimeOutlier.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwoutMergerToSelect extends InfoMergerTemplate_<EmpwoutInfo, EmpwoutInfo> {

	@Override protected InfoMergerVisitor_<EmpwoutInfo, EmpwoutInfo> getVisitorHook() {
		return new EmpwoutVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
