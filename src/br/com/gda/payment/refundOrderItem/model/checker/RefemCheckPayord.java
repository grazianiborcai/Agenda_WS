package br.com.gda.payment.refundOrderItem.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.checker.PayordCheckExist;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckPayord implements ModelChecker<RefemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayordInfo> checker;
	
	
	public RefemCheckPayord(ModelCheckerOption option) {
		checker = new PayordCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<RefemInfo> recordInfos) {
		for (RefemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(RefemInfo recordInfo) {
		return checker.check(PayordInfo.copyFrom(recordInfo));
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
