package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusarchCheckLangu extends ModelCheckerTemplateForward<SowusarchInfo, LanguInfo> {
	
	public SowusarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SowusarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
