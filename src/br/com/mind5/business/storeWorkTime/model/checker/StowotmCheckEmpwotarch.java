package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.checker.EmpwotarchCheckExist;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StowotmCheckEmpwotarch extends ModelCheckerTemplateForward<StowotmInfo, EmpwotarchInfo> {
	
	public StowotmCheckEmpwotarch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpwotarchCheckExist(option);
	}
	
	
	
	@Override protected EmpwotarchInfo toForwardClass(StowotmInfo baseRecord) {
		return EmpwotarchInfo.copyFrom(baseRecord);
	}
}
