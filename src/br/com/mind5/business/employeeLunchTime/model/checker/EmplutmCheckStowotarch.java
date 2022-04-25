package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.checker.StowotarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplutmCheckStowotarch extends ModelCheckerTemplateForward<EmplutmInfo, StowotarchInfo> {
	
	public EmplutmCheckStowotarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StowotarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StowotarchCheckExist(option);
	}
	
	
	
	@Override protected StowotarchInfo toForwardClass(EmplutmInfo baseRecord) {
		return StowotarchInfo.copyFrom(baseRecord);
	}
}
