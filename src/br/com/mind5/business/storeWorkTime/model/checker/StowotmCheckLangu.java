package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StowotmCheckLangu extends ModelCheckerTemplateForwardV2<StowotmInfo, LanguInfo> {
	
	public StowotmCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StowotmInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
