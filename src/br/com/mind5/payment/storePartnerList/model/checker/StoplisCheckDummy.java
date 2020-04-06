package br.com.mind5.payment.storePartnerList.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisCheckDummy implements ModelCheckerV1<StoplisInfo> {
	private ModelCheckerV1<StoplisInfo> checker;
	
	
	public StoplisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<StoplisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(StoplisInfo recordInfo) {
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
