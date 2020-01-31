package br.com.mind5.business.employeeWorkTimeRange.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpworgMergerToSelect extends InfoMergerTemplate_<EmpworgInfo, EmpworgInfo> {

	@Override protected InfoMergerVisitor_<EmpworgInfo, EmpworgInfo> getVisitorHook() {
		return new EmpworgVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpworgInfo> getUniquifierHook() {
		return new EmpworgUniquifier();
	}
}
