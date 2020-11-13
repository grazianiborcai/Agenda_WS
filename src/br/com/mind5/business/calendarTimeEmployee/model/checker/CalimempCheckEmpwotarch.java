package br.com.mind5.business.calendarTimeEmployee.model.checker;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalimempCheckEmpwotarch extends ModelCheckerTemplateForward<CalimempInfo, EmpwotarchInfo> {
	
	public CalimempCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExist(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(CalimempInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
