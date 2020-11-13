package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpwotmCheckStowotarch extends ModelCheckerTemplateForward<EmpwotmInfo, StowotarchInfo> {
	
	public EmpwotmCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(EmpwotmInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
