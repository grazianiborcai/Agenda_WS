package br.com.mind5.message.emailPasswordChange.model.checker;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class EmordeCheckUser extends ModelCheckerTemplateForwardV2<EmordeInfo, UserInfo> {
	
	public EmordeCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(EmordeInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}