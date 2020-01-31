package br.com.mind5.business.employeeWorkTimeConflict.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwocoMergerToSelect extends InfoMergerTemplate_<EmpwocoInfo, EmpwocoInfo> {

	@Override protected InfoMergerVisitor_<EmpwocoInfo, EmpwocoInfo> getVisitorHook() {
		return new EmpwocoVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
