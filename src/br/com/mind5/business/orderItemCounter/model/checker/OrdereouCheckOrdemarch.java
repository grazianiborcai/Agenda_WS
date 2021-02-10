package br.com.mind5.business.orderItemCounter.model.checker;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class OrdereouCheckOrdemarch extends ModelCheckerTemplateForward<OrdereouInfo, OrdemarchInfo> {
	
	public OrdereouCheckOrdemarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrdemarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrdemarchCheckExist(option);
	}
	
	
	
	@Override protected OrdemarchInfo toForwardClass(OrdereouInfo baseRecord) {
		return OrdemarchInfo.copyFrom(baseRecord);
	}
}
