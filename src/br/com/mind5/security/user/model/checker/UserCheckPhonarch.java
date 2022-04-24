package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExistUser;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckPhonarch extends ModelCheckerTemplateForward<UserInfo, PhonarchInfo> {
	
	public UserCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExistUser(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(UserInfo baseRecord) {
		return PhonarchInfo.copyFrom(baseRecord);
	}
}
