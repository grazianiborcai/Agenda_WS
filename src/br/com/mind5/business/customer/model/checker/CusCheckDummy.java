package br.com.mind5.business.customer.model.checker;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class CusCheckDummy implements ModelCheckerV1<CusInfo> {
	private ModelCheckerV1<CusInfo> checker;
	
	
	public CusCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
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
