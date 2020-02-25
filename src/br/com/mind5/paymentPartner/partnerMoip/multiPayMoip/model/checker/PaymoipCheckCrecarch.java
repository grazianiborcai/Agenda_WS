package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCrecarch implements ModelChecker<PaymoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CrecarchInfo> checker;
	
	
	public PaymoipCheckCrecarch(ModelCheckerOption option) {
		checker = new CrecarchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PaymoipInfo> recordInfos) {
		for (PaymoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PaymoipInfo recordInfo) {
		return checker.check(CrecarchCopier.copyFromPaymoip(recordInfo));
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
