package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker.StusorygeCheckExist;

public final class StusoryCheckStusoryge extends ModelCheckerTemplateForward<StusoryInfo, StusorygeInfo> {
	
	public StusoryCheckStusoryge(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusorygeInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusorygeCheckExist(option);
	}
	
	
	
	@Override protected StusorygeInfo toForwardClass(StusoryInfo baseRecord) {
		return StusorygeInfo.copyFrom(baseRecord);
	}
}
