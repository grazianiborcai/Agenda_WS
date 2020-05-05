package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckEmposarch extends ModelCheckerTemplateForwardV2<SchedineInfo, EmposarchInfo> {
	
	public SchedineCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(SchedineInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
