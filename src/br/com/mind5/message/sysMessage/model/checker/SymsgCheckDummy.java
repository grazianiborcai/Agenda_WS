package br.com.mind5.message.sysMessage.model.checker;

import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class SymsgCheckDummy implements ModelChecker<SymsgInfo> {
	private ModelChecker<SymsgInfo> checker;
	
	
	public SymsgCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<SymsgInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(SymsgInfo recordInfo) {
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
