package br.com.mind5.business.storeSearch.model.checker;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SotarchCheckLangu extends ModelCheckerTemplateForward<SotarchInfo, LanguInfo> {
	
	public SotarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SotarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
