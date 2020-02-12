package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckDummy implements ModelChecker<CrecardInfo> {
	private ModelChecker<CrecardInfo> checker;
	
	
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
