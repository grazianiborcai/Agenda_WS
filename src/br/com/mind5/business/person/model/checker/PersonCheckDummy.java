package br.com.mind5.business.person.model.checker;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

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
