package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerEmpwoco extends InfoMergerTemplate<EmpwotmInfo, EmpwocoInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, EmpwocoInfo> getVisitorHook() {
		return new EmpwotmVisiMergeEmpwoco();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
