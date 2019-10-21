package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerWeekday extends InfoMergerTemplate<EmpwotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
