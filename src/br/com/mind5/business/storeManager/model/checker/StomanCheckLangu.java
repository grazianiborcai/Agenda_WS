package br.com.mind5.business.storeManager.model.checker;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StomanCheckLangu extends ModelCheckerTemplateForward<StomanInfo, LanguInfo> {
	
	public StomanCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StomanInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
