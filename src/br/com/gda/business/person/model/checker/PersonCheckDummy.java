package br.com.gda.business.person.model.checker;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class PersonCheckDummy implements ModelChecker<PersonInfo> {
	private ModelChecker<PersonInfo> checker;
	
	
	public PersonCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PersonInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PersonInfo recordInfo) {
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
