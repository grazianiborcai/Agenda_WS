package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExistEmpos;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpCheckEmpwotarch extends ModelCheckerTemplateForward<EmpInfo, EmpwotarchInfo> {
	
	public EmpCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExistEmpos(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(EmpInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
