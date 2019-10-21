package br.com.mind5.business.orderItem.model.checker;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class OrderemCheckStore implements ModelChecker<OrderemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreInfo> checker;
	
	
	public OrderemCheckStore(ModelCheckerOption option) {
		checker = new StoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrderemInfo> recordInfos) {
		for (OrderemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrderemInfo recordInfo) {
		return checker.check(StoreInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
