package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpwotmMergerTimezone extends InfoMergerTemplate<EmpwotmInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitorV2<EmpwotmInfo, TimezoneInfo> getVisitorHook() {
		return new EmpwotmVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
