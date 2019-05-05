package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmplevateMergerTimezone extends InfoMergerTemplate<EmplevateInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitorV2<EmplevateInfo, TimezoneInfo> getVisitorHook() {
		return new EmplevateVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
