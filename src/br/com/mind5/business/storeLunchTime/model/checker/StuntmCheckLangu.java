package br.com.mind5.business.storeLunchTime.model.checker;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StuntmCheckLangu extends ModelCheckerTemplateForward<StuntmInfo, LanguInfo> {
	
	public StuntmCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StuntmInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
