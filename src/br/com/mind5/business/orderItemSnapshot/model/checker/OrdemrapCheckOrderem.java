package br.com.mind5.business.orderItemSnapshot.model.checker;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class OrdemrapCheckOrderem implements ModelCheckerV1<OrdemrapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<OrderemInfo> checker;
	
	
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
