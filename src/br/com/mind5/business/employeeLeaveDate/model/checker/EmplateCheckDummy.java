package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class EmplateCheckDummy implements ModelChecker<EmplateInfo> {
	private ModelChecker<EmplateInfo> checker;
	
	
	public EmplateCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<EmplateInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(EmplateInfo recordInfo) {
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
