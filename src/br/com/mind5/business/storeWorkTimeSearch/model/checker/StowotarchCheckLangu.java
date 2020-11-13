package br.com.mind5.business.storeWorkTimeSearch.model.checker;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StowotarchCheckLangu extends ModelCheckerTemplateForward<StowotarchInfo, LanguInfo> {
	
	public StowotarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StowotarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
