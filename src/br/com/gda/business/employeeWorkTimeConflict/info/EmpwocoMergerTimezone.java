package br.com.gda.business.employeeWorkTimeConflict.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpwocoMergerTimezone extends InfoMergerTemplate<EmpwocoInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitorV2<EmpwocoInfo, TimezoneInfo> getVisitorHook() {
		return new EmpwocoVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
