package br.com.mind5.business.storeProspectCounter.model.checker;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoprosouCheckLangu extends ModelCheckerTemplateForward<StoprosouInfo, LanguInfo> {
	
	public StoprosouCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StoprosouInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
