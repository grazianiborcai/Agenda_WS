package br.com.gda.payService.payPartnerOwner.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.checker.PayparCountryCheckExist;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;

public final class PayparOwnerCheckPayparCountry implements ModelChecker<PayparOwnerInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayparCountryInfo> checker;
	
	
	public PayparOwnerCheckPayparCountry(ModelCheckerOption option) {
		checker = new PayparCountryCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayparOwnerInfo> recordInfos) {
		for (PayparOwnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayparOwnerInfo recordInfo) {
		return checker.check(PayparCountryInfo.copyFrom(recordInfo));
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
