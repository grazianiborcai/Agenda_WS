package br.com.mind5.business.employeeSnapshot.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpnapCheckEmp extends ModelCheckerTemplateForward<EmpnapInfo, EmpInfo> {
	
	public EmpnapCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(EmpnapInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
