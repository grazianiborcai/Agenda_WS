package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderemCheckStore extends ModelCheckerTemplateForward<OrderemInfo, StoreInfo> {
	
	public OrderemCheckStore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoreCheckExist(option);
	}
	
	
	
	@Override protected StoreInfo toForwardClass(OrderemInfo baseRecord) {
		return StoreInfo.copyFrom(baseRecord);
	}
}
