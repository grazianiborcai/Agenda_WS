package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.checker.GenderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PersonCheckGender extends ModelCheckerTemplateForward<PersonInfo, GenderInfo> {
	
	public PersonCheckGender(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<GenderInfo> getCheckerHook(ModelCheckerOption option) {
		return new GenderCheckExist(option);
	}
	
	
	
	@Override protected GenderInfo toForwardClass(PersonInfo baseRecord) {
		return GenderInfo.copyFrom(baseRecord);
	}
}
