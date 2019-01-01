package br.com.gda.payService.payCustomer.model.checker;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.checker.AddressCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckAddressExist implements ModelChecker<PayCusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AddressInfo> checker;
	
	
	public PayCusCheckAddressExist(ModelCheckerOption option) {
		checker = new AddressCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayCusInfo> recordInfos) {
		for (PayCusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayCusInfo recordInfo) {
		return checker.check(AddressInfo.copyFrom(recordInfo));
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
