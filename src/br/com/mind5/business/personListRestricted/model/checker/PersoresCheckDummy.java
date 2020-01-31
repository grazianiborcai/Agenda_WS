package br.com.mind5.business.personListRestricted.model.checker;

import java.util.List;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class PersoresCheckDummy implements ModelChecker<PersoresInfo> {
	private ModelChecker<PersoresInfo> checker;
	
	
	public PersoresCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PersoresInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PersoresInfo recordInfo) {
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
