package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.checker.StusorygrCheckExist;

public final class StusoryCheckStusorygr extends ModelCheckerTemplateForward<StusoryInfo, StusorygrInfo> {
	
	public StusoryCheckStusorygr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusorygrInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusorygrCheckExist(option);
	}
	
	
	
	@Override protected StusorygrInfo toForwardClass(StusoryInfo baseRecord) {
		return StusorygrInfo.copyFrom(baseRecord);
	}
}
