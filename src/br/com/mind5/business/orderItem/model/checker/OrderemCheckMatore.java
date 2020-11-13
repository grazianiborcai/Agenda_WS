package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderemCheckMatore extends ModelCheckerTemplateForward<OrderemInfo, MatoreInfo> {
	
	public OrderemCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(OrderemInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
