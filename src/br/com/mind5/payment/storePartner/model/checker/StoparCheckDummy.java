package br.com.mind5.payment.storePartner.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckDummy implements ModelCheckerV1<StoparInfo> {
	private ModelCheckerV1<StoparInfo> checker;
	
	
	public StoparCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<StoparInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(StoparInfo recordInfo) {
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
