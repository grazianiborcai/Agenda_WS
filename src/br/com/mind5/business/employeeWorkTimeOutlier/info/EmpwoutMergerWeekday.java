package br.com.mind5.business.employeeWorkTimeOutlier.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwoutMergerWeekday extends InfoMergerTemplate<EmpwoutInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwoutVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
