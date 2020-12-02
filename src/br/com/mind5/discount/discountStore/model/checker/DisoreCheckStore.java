package br.com.mind5.discount.discountStore.model.checker;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisoreCheckStore extends ModelCheckerTemplateForward<DisoreInfo, StoreInfo> {
	
	public DisoreCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(DisoreInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
