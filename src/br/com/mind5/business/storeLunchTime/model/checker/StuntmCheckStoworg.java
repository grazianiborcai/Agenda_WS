package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public class StuntmCheckStoworg extends ModelCheckerTemplateForward<StuntmInfo, StoworgInfo> {
	
	public StuntmCheckStoworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoworgCheckExist(option);
	}
	
	
	
	@Override protected StoworgInfo toForwardClass(StuntmInfo baseRecord) {
		return StoworgInfo.copyFrom(baseRecord);
	}
}
