package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.checker.PositionCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmposCheckPosition extends ModelCheckerTemplateForward<EmposInfo, PositionInfo> {
	
	public EmposCheckPosition(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PositionInfo> getCheckerHook(ModelCheckerOption option) {
		return new PositionCheckExist(option);
	}
	
	
	
	@Override protected PositionInfo toForwardClass(EmposInfo baseRecord) {
		return PositionInfo.copyFrom(baseRecord);
	}
}
