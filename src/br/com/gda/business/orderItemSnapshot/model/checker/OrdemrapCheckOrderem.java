package br.com.gda.business.orderItemSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.checker.OrderemCheckExist;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class OrdemrapCheckOrderem implements ModelChecker<OrdemrapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OrderemInfo> checker;
	
	
	public OrdemrapCheckOrderem(ModelCheckerOption option) {
		checker = new OrderemCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrdemrapInfo> recordInfos) {
		for (OrdemrapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrdemrapInfo recordInfo) {
		return checker.check(OrderemInfo.copyFrom(recordInfo));
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
