package br.com.mind5.business.employeeWorkTimeConflict.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwocoMergerWeekday extends InfoMergerTemplate<EmpwocoInfo, WeekdayInfo> {

	@Override protected InfoMergerVisitor<EmpwocoInfo, WeekdayInfo> getVisitorHook() {
		return new EmpwocoVisiMergeWeekday();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwocoInfo> getUniquifierHook() {
		return new EmpwocoUniquifier();
	}
}
