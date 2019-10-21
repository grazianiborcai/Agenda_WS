package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerTimezone extends InfoMergerTemplate<EmpwotmInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, TimezoneInfo> getVisitorHook() {
		return new EmpwotmVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
