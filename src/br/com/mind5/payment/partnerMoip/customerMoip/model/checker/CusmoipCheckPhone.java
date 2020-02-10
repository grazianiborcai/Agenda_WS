package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhone implements ModelChecker<CusmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PhoneInfo> checker;
	
	
	public CusmoipCheckPhone(ModelCheckerOption option) {
		checker = new PhoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusmoipInfo> recordInfos) {
		for (CusmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusmoipInfo recordInfo) {
		return checker.check(PhoneCopier.copyFromCusmoip(recordInfo));
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
