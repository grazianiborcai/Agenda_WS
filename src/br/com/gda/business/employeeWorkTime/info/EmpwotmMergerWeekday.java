package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwotmMergerWeekday extends InfoMergerTemplate<EmpwotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
