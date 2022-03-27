package br.com.mind5.business.storeWorkTimeSnapshot.model.checker;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StowotmapCheckLangu extends ModelCheckerTemplateForward<StowotmapInfo, LanguInfo> {
	
	public StowotmapCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StowotmapInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
