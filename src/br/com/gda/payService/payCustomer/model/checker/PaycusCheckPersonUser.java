package br.com.gda.payService.payCustomer.model.checker;

import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.model.checker.PersonUserCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusCheckPersonUser implements ModelChecker<PaycusInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<PersonUserInfo> checker;
	
	
	public PaycusCheckPersonUser(ModelCheckerOption option) {
		checker = new PersonUserCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PaycusInfo> recordInfos) {
		for (PaycusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(PaycusInfo recordInfo) {
		return checker.check(PersonUserInfo.copyFrom(recordInfo));
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
