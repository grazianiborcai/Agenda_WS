package br.com.mind5.business.storeFavoriteSearch.model.checker;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoritarchCheckLangu extends ModelCheckerTemplateForward<StoritarchInfo, LanguInfo> {
	
	public StoritarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoritarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
