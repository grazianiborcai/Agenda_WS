package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmplevateMergerTimezone extends InfoMergerTemplate<EmplevateInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<EmplevateInfo, TimezoneInfo> getVisitorHook() {
		return new EmplevateVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
