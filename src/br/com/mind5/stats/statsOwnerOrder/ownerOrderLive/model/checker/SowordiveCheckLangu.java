package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

public final class SowordiveCheckLangu extends ModelCheckerTemplateForward<SowordiveInfo, LanguInfo> {
	
	public SowordiveCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(SowordiveInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
