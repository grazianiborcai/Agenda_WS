package br.com.gda.business.employeeWorkTimeConflict.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwocoMergerToSelect extends InfoMergerTemplate<EmpwocoInfo, EmpwocoInfo> {

	@Override protected InfoMergerVisitor<EmpwocoInfo, EmpwocoInfo> getVisitorHook() {
		return new EmpwocoVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
