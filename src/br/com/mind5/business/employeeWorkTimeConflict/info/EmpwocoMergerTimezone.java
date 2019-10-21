package br.com.mind5.business.employeeWorkTimeConflict.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwocoMergerTimezone extends InfoMergerTemplate<EmpwocoInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<EmpwocoInfo, TimezoneInfo> getVisitorHook() {
		return new EmpwocoVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
