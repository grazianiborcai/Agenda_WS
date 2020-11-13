package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplateCheckEmp extends ModelCheckerTemplateForward<EmplateInfo, EmpInfo> {
	
	public EmplateCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmplateInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
