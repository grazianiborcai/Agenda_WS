package br.com.mind5.business.employeeLunchTimeRange.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeLunchTimeRange.info.EmpulranInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpulranCheckEmp extends ModelCheckerTemplateForward<EmpulranInfo, EmpInfo> {
	
	public EmpulranCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmpulranInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
