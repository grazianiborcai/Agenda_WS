package br.com.gda.business.personSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.checker.PersonCheckExist;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class PersonSnapCheckPerson implements ModelChecker<PersonSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PersonInfo> checker;
	
	
	public PersonSnapCheckPerson(ModelCheckerOption option) {
		checker = new PersonCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PersonSnapInfo> recordInfos) {
		for (PersonSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PersonSnapInfo recordInfo) {
		return checker.check(PersonInfo.copyFrom(recordInfo));
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
