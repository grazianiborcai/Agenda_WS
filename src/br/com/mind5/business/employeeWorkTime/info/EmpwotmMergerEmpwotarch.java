package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerEmpwotarch extends InfoMergerTemplate<EmpwotmInfo, EmpwotarchInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, EmpwotarchInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwotarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
