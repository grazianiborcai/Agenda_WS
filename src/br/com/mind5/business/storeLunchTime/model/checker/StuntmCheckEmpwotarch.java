package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExist;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StuntmCheckEmpwotarch extends ModelCheckerTemplateForward<StuntmInfo, EmpwotarchInfo> {
	
	public StuntmCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExist(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(StuntmInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
