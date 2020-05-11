package br.com.mind5.security.user.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExist;

public final class UserCheckUserarch extends ModelCheckerTemplateForwardV2<UserInfo, UserarchInfo> {
	
	public UserCheckUserarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExist(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(UserInfo baseRecord) {
		return UserarchCopier.copyFromUser(baseRecord);
	}
}
