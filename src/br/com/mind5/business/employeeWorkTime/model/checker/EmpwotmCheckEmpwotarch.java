package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpwotmCheckEmpwotarch extends ModelCheckerTemplateForward<EmpwotmInfo, EmpwotarchInfo> {
	
	public EmpwotmCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExist(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(EmpwotmInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
