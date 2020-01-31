package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerTimezone extends InfoMergerTemplate_<EmpwotmInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, TimezoneInfo> getVisitorHook() {
		return new EmpwotmVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
