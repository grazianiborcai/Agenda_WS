package br.com.gda.business.employeeWorkTimeOutlier.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwoutMergerWeekday extends InfoMergerTemplate<EmpwoutInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwoutVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
