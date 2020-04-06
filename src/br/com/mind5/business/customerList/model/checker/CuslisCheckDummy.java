package br.com.mind5.business.customerList.model.checker;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class CuslisCheckDummy implements ModelCheckerV1<CuslisInfo> {
	private ModelCheckerV1<CuslisInfo> checker;
	
	
	public CuslisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CuslisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CuslisInfo recordInfo) {
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
