package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.checker.StusorygerchCheckExistUser;

public final class StusoryrchCheckStusorygerch extends ModelCheckerTemplateForward<StusoryrchInfo, StusorygerchInfo> {
	
	public StusoryrchCheckStusorygerch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StusorygerchInfo> getCheckerHook(ModelCheckerOption option) {
		return new StusorygerchCheckExistUser(option);
	}
	
	
	
	@Override protected StusorygerchInfo toForwardClass(StusoryrchInfo baseRecord) {
		return StusorygerchInfo.copyFrom(baseRecord);
	}
}
