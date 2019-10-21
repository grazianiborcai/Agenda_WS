package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerToSelect extends InfoMergerTemplate<EmpwotmInfo, EmpwotmInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, EmpwotmInfo> getVisitorHook() {
		return new EmpwotmVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
