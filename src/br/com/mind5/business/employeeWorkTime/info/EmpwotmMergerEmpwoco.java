package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerEmpwoco extends InfoMergerTemplate_<EmpwotmInfo, EmpwocoInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, EmpwocoInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwoco();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
