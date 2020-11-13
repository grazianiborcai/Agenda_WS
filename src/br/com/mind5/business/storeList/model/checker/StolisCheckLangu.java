package br.com.mind5.business.storeList.model.checker;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StolisCheckLangu extends ModelCheckerTemplateForward<StolisInfo, LanguInfo> {
	
	public StolisCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StolisInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
