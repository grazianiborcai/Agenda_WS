package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerEmpwotarch extends InfoMergerTemplate_<EmpwotmInfo, EmpwotarchInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, EmpwotarchInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwotarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
