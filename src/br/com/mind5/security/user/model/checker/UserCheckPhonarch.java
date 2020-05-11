package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.checker.PhonarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckPhonarch extends ModelCheckerTemplateForwardV2<UserInfo, PhonarchInfo> {
	
	public UserCheckPhonarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PhonarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonarchCheckExist(option);
	}
	
	
	
	@Override protected PhonarchInfo toForwardClass(UserInfo baseRecord) {
		return PhonarchCopier.copyFromUser(baseRecord);
	}
}
