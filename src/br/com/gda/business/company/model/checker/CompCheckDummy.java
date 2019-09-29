package br.com.gda.business.company.model.checker;

import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class CompCheckDummy implements ModelChecker<CompInfo> {
	private ModelChecker<CompInfo> checker;
	
	
	public CompCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CompInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CompInfo recordInfo) {
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
