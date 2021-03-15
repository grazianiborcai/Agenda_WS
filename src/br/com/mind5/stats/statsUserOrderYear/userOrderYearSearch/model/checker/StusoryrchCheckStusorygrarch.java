package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.checker.StusorygrarchCheckExistUser;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;

public final class StusoryrchCheckStusorygrarch extends ModelCheckerTemplateForward<StusoryrchInfo, StusorygrarchInfo> {
	
	public StusoryrchCheckStusorygrarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusorygrarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusorygrarchCheckExistUser(option);
	}
	
	
	
	@Override protected StusorygrarchInfo toForwardClass(StusoryrchInfo baseRecord) {
		return StusorygrarchInfo.copyFrom(baseRecord);
	}
}
