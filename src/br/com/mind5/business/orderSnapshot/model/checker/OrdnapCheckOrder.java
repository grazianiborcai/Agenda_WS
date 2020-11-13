package br.com.mind5.business.orderSnapshot.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdnapCheckOrder extends ModelCheckerTemplateForward<OrdnapInfo, OrderInfo> {
	
	public OrdnapCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(OrdnapInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
