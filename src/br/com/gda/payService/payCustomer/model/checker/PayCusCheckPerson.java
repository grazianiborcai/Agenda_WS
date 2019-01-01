package br.com.gda.payService.payCustomer.model.checker;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.checker.PersonCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckPerson implements ModelChecker<PayCusInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<PersonInfo> checker;
	
	
	public PayCusCheckPerson(ModelCheckerOption option) {
		checker = new PersonCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayCusInfo> recordInfos) {
		for (PayCusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(PayCusInfo recordInfo) {
		return checker.check(PersonInfo.copyFrom(recordInfo));
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
