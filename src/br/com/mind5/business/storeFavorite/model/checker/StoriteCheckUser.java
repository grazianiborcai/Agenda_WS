package br.com.mind5.business.storeFavorite.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class StoriteCheckUser extends ModelCheckerTemplateForwardV2<StoriteInfo, UserInfo> {
	
	public StoriteCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(StoriteInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
