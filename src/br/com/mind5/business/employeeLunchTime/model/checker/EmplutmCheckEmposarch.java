package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmplutmCheckEmposarch extends ModelCheckerTemplateForward<EmplutmInfo, EmposarchInfo> {
	
	public EmplutmCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(EmplutmInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
