package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerEmpwout extends InfoMergerTemplate_<EmpwotmInfo, EmpwoutInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, EmpwoutInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwout();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
