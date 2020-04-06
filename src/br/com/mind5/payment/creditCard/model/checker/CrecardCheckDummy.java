package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckDummy implements ModelCheckerV1<CrecardInfo> {
	private ModelCheckerV1<CrecardInfo> checker;
	
	
	public CrecardCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CrecardInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CrecardInfo recordInfo) {
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
