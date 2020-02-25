package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckDummy implements ModelChecker<PaymoipInfo> {
	private ModelChecker<PaymoipInfo> checker;
	
	
	public PaymoipCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PaymoipInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PaymoipInfo recordInfo) {
		return checker.check(recordInfo);
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
