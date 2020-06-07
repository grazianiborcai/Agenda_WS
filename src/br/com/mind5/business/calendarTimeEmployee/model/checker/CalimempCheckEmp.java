package br.com.mind5.business.calendarTimeEmployee.model.checker;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CalimempCheckEmp extends ModelCheckerTemplateForwardV2<CalimempInfo, EmpInfo> {
	
	public CalimempCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(CalimempInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
