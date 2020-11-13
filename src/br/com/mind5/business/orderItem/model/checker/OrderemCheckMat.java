package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderemCheckMat extends ModelCheckerTemplateForward<OrderemInfo, MatInfo> {
	
	public OrderemCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(OrderemInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
