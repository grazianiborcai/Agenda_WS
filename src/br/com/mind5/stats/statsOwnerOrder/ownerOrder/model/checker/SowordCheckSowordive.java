package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.checker.SowordiveCheckExist;

public final class SowordCheckSowordive extends ModelCheckerTemplateForward<SowordInfo, SowordiveInfo> {
	
	public SowordCheckSowordive(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowordiveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowordiveCheckExist(option);
	}
	
	
	
	@Override protected SowordiveInfo toForwardClass(SowordInfo baseRecord) {
		return SowordiveInfo.copyFrom(baseRecord);
	}
}
