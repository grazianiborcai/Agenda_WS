package br.com.gda.business.employeeWorkTimeConflict.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpwocoMergerWeekday extends InfoMergerTemplate<EmpwocoInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitorV2<EmpwocoInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwocoVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
