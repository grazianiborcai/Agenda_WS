package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.checker.OrdistCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

public final class StusorygeCheckOrdist extends ModelCheckerTemplateForward<StusorygeInfo, OrdistInfo> {
	
	public StusorygeCheckOrdist(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrdistInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrdistCheckExist(option);
	}
	
	
	
	@Override protected OrdistInfo toForwardClass(StusorygeInfo baseRecord) {
		return OrdistInfo.copyFrom(baseRecord);
	}
}
