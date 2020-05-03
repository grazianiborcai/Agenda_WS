package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchCopier;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderemCheckMatarchService extends ModelCheckerTemplateForwardV2<OrderemInfo, MatarchInfo> {
	
	public OrderemCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(OrderemInfo baseRecord) {
		return MatarchCopier.copyFromOrderem(baseRecord);
	}
}
