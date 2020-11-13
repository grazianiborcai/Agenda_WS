package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedineCheckEmposarch extends ModelCheckerTemplateForward<SchedineInfo, EmposarchInfo> {
	
	public SchedineCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(SchedineInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
