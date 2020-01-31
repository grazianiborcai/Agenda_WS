package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerWeekday extends InfoMergerTemplate_<EmpwotmInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwotmVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
