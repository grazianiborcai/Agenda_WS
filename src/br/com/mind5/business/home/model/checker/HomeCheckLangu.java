package br.com.mind5.business.home.model.checker;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class HomeCheckLangu extends ModelCheckerTemplateForward<HomeInfo, LanguInfo> {
	
	public HomeCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(HomeInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
