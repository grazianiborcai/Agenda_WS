package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderemCheckMatore extends ModelCheckerTemplateForwardV2<OrderemInfo, MatoreInfo> {
	
	public OrderemCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(OrderemInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
