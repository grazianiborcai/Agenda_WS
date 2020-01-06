package br.com.mind5.business.employeeWorkTimeRange.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpworgMergerToSelect extends InfoMergerTemplate<EmpworgInfo, EmpworgInfo> {

	@Override protected InfoMergerVisitor<EmpworgInfo, EmpworgInfo> getVisitorHook() {
		return new EmpworgVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpworgInfo> getUniquifierHook() {
		return new EmpworgUniquifier();
	}
}
