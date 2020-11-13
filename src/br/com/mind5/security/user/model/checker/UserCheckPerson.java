package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckPerson extends ModelCheckerTemplateForward<UserInfo, PersonInfo> {
	
	public UserCheckPerson(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PersonInfo> getCheckerHook(ModelCheckerOption option) {
		return new PersonCheckExist(option);
	}
	
	
	
	@Override protected PersonInfo toForwardClass(UserInfo baseRecord) {
		return PersonInfo.copyFrom(baseRecord);
	}
}
