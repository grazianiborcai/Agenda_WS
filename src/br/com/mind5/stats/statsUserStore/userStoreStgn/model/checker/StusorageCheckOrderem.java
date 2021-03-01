package br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;

public final class StusorageCheckOrderem extends ModelCheckerTemplateForward<StusorageInfo, OrderemInfo> {
	
	public StusorageCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(StusorageInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
