package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckDummy implements ModelChecker<MultmoipInfo> {
	private ModelChecker<MultmoipInfo> checker;
	
	
	public MultmoipCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MultmoipInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MultmoipInfo recordInfo) {
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
