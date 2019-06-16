package br.com.gda.payService.payPartnerOwner.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.checker.CounparCheckExist;

public final class PayparOwnerCheckPayparCountry implements ModelChecker<PayparOwnerInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CounparInfo> checker;
	
	
	public PayparOwnerCheckPayparCountry(ModelCheckerOption option) {
		checker = new CounparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayparOwnerInfo> recordInfos) {
		for (PayparOwnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayparOwnerInfo recordInfo) {
		return checker.check(CounparInfo.copyFrom(recordInfo));
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
