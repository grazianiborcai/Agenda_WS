package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckExist;

public final class SowordCheckSowordagr extends ModelCheckerTemplateForward<SowordInfo, SowordagrInfo> {
	
	public SowordCheckSowordagr(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SowordagrInfo> getCheckerHook(ModelCheckerOption option) {
		return new SowordagrCheckExist(option);
	}
	
	
	
	@Override protected SowordagrInfo toForwardClass(SowordInfo baseRecord) {
		return SowordagrInfo.copyFrom(baseRecord);
	}
}
