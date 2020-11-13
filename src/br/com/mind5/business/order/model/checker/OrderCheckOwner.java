package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderCheckOwner extends ModelCheckerTemplateForward<OrderInfo, OwnerInfo> {
	
	public OrderCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OrderInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
