package br.com.gda.business.schedule.model.checker;

import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.checker.OrderCheckExist;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class OrderemCheckOrder implements ModelChecker<ScheduInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OrderInfo> checker;
	
	
	public OrderemCheckOrder(ModelCheckerOption option) {
		checker = new OrderCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<ScheduInfo> recordInfos) {
		for (ScheduInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(ScheduInfo recordInfo) {
		return checker.check(OrderInfo.copyFrom(recordInfo));
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
