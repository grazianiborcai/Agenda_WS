package br.com.gda.payment.payOrder.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.checker.PayparCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordCheckPaypar implements ModelChecker<PayordInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayparInfo> checker;
	
	
	public PayordCheckPaypar(ModelCheckerOption option) {
		checker = new PayparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayordInfo> recordInfos) {
		for (PayordInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayordInfo recordInfo) {
		return checker.check(PayparInfo.copyFrom(recordInfo));
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
