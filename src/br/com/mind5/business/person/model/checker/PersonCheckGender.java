package br.com.mind5.business.person.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.checker.GenderCheckExist;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class PersonCheckGender implements ModelChecker<PersonInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<GenderInfo> checker;
	
	
	public PersonCheckGender(ModelCheckerOption option) {
		checker = new GenderCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PersonInfo> recordInfos) {
		for (PersonInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PersonInfo recordInfo) {
		return checker.check(GenderInfo.copyFrom(recordInfo));
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
