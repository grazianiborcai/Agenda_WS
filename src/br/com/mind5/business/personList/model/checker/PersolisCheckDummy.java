package br.com.mind5.business.personList.model.checker;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class PersolisCheckDummy implements ModelCheckerV1<PersolisInfo> {
	private ModelCheckerV1<PersolisInfo> checker;
	
	
	public PersolisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PersolisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PersolisInfo recordInfo) {
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
