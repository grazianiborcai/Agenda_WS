package br.com.mind5.business.personSearch.model.checker;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class PerarchCheckDummy implements ModelChecker<PerarchInfo> {
	private ModelChecker<PerarchInfo> checker;
	
	
	public PerarchCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PerarchInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PerarchInfo recordInfo) {
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
