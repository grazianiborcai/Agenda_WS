package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.checker.UserCategCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckCateg extends ModelCheckerTemplateForwardV2<UserInfo, UserCategInfo> {
	
	public UserCheckCateg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserCategInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCategCheckExist(option);
	}
	
	
	
	@Override protected UserCategInfo toForwardClass(UserInfo baseRecord) {
		return UserCategInfo.copyFrom(baseRecord);
	}
}
