package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwotmMergerToSelect extends InfoMergerTemplate<EmpwotmInfo, EmpwotmInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, EmpwotmInfo> getVisitorHook() {
		return new EmpwotmVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
