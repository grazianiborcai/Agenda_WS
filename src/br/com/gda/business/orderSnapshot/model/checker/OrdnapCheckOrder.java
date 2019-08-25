package br.com.gda.business.orderSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.checker.OrderCheckExist;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class OrdnapCheckOrder implements ModelChecker<OrdnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OrderInfo> checker;
	
	
	public OrdnapCheckOrder(ModelCheckerOption option) {
		checker = new OrderCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrdnapInfo> recordInfos) {
		for (OrdnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrdnapInfo recordInfo) {
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
