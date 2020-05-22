package br.com.mind5.security.user.model.checker;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.checker.UseregCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckUsereg extends ModelCheckerTemplateForwardV2<UserInfo, UseregInfo> {
	
	public UserCheckUsereg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UseregInfo> getCheckerHook(ModelCheckerOption option) {
		return new UseregCheckExist(option);
	}
	
	
	
	@Override protected UseregInfo toForwardClass(UserInfo baseRecord) {
		return UseregInfo.copyFrom(baseRecord);
	}
}
