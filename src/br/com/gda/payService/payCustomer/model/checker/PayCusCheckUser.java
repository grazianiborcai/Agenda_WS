package br.com.gda.payService.payCustomer.model.checker;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckUser implements ModelChecker<PayCusInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<UserInfo> checker;
	
	
	public PayCusCheckUser(ModelCheckerOption option) {
		checker = new UserCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayCusInfo> recordInfos) {
		for (PayCusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(PayCusInfo recordInfo) {
		return checker.check(UserInfo.copyFrom(recordInfo));
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
