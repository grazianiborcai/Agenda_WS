package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckDummy implements ModelChecker<CremoipInfo> {
	private ModelChecker<CremoipInfo> checker;
	
	
	public CremoipCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CremoipInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CremoipInfo recordInfo) {
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
