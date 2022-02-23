package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StordiveCheckOwner extends ModelCheckerTemplateForward<StordiveInfo, OwnerInfo> {
	
	public StordiveCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(StordiveInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
