package br.com.mind5.business.calendarTimeEmployee.model.checker;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CalimempCheckEmp extends ModelCheckerTemplateForward<CalimempInfo, EmpInfo> {
	
	public CalimempCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(CalimempInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
