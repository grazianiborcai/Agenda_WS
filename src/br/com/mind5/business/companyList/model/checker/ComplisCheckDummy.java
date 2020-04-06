package br.com.mind5.business.companyList.model.checker;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class ComplisCheckDummy implements ModelCheckerV1<ComplisInfo> {
	private ModelCheckerV1<ComplisInfo> checker;
	
	
	public ComplisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<ComplisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(ComplisInfo recordInfo) {
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
