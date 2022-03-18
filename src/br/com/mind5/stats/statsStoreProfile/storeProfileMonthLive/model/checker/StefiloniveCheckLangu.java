package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefiloniveCheckLangu extends ModelCheckerTemplateForward<StefiloniveInfo, LanguInfo> {
	
	public StefiloniveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(StefiloniveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
