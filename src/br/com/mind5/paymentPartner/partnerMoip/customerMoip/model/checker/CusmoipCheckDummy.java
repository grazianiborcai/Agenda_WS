package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckDummy implements ModelChecker<CusmoipInfo> {
	private ModelChecker<CusmoipInfo> checker;
	
	
	public CusmoipCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CusmoipInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CusmoipInfo recordInfo) {
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
