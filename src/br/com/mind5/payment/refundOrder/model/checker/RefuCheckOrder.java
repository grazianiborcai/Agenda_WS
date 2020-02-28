package br.com.mind5.payment.refundOrder.model.checker;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class RefuCheckOrder implements ModelChecker<RefuInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OrderInfo> checker;
	
	
	public RefuCheckOrder(ModelCheckerOption option) {
		checker = new OrderCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<RefuInfo> recordInfos) {
		for (RefuInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(RefuInfo recordInfo) {
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
