package br.com.mind5.business.employeeWorkTimeConflict.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwocoMergerToSelect extends InfoMergerTemplate<EmpwocoInfo, EmpwocoInfo> {

	@Override protected InfoMergerVisitor<EmpwocoInfo, EmpwocoInfo> getVisitorHook() {
		return new EmpwocoVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
