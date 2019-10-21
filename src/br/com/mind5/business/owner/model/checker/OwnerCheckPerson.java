package br.com.mind5.business.owner.model.checker;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class OwnerCheckPerson implements ModelChecker<OwnerInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<PersonInfo> checker;
	
	
	public OwnerCheckPerson(ModelCheckerOption option) {
		checker = new PersonCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OwnerInfo> recordInfos) {
		for (OwnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(OwnerInfo recordInfo) {
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
