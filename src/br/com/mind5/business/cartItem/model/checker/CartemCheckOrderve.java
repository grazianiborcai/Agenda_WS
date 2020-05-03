package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckOrderve extends ModelCheckerTemplateForwardV2<CartemInfo, OrderveInfo> {
	
	public CartemCheckOrderve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderveInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderveCheckExist(option);
	}
	
	
	
	@Override protected OrderveInfo toForwardClass(CartemInfo baseRecord) {
		return OrderveInfo.copyFrom(baseRecord);
	}
}
