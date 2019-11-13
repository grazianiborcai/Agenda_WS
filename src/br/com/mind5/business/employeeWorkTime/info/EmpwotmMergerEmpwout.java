package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerEmpwout extends InfoMergerTemplate<EmpwotmInfo, EmpwoutInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, EmpwoutInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwout();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
