package br.com.mind5.payment.statusPayOrder.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckExist;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckPayordarch implements ModelChecker<PaytusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayordarchInfo> checker;
	
	
	public PaytusCheckPayordarch(ModelCheckerOption option) {
		checker = new PayordarchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PaytusInfo> recordInfos) {
		for (PaytusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PaytusInfo recordInfo) {
		return checker.check(PayordarchInfo.copyFrom(recordInfo));
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
