package br.com.mind5.business.orderItem.model.checker;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class OrderemCheckDummy implements ModelChecker<OrderemInfo> {
	private ModelChecker<OrderemInfo> checker;
	
	
	public OrderemCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<OrderemInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(OrderemInfo recordInfo) {
		return checker.check(recordInfo);
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
