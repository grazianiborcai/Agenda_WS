package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplevateMergerTimezone extends InfoMergerTemplate<EmplevateInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<EmplevateInfo, TimezoneInfo> getVisitorHook() {
		return new EmplevateVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
