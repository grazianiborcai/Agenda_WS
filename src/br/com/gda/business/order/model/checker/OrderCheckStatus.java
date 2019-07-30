package br.com.gda.business.order.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.checker.OrderStatusCheckExist;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class OrderCheckStatus implements ModelChecker<OrderInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OrderStatusInfo> checker;
	
	
	public OrderCheckStatus(ModelCheckerOption option) {
		checker = new OrderStatusCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrderInfo> recordInfos) {
		for (OrderInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrderInfo recordInfo) {
		return checker.check(OrderStatusInfo.copyFrom(recordInfo));
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
