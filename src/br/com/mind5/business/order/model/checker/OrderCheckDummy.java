package br.com.mind5.business.order.model.checker;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class OrderCheckDummy implements ModelCheckerV1<OrderInfo> {
	private ModelCheckerV1<OrderInfo> checker;
	
	
	public OrderCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<OrderInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(OrderInfo recordInfo) {
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
