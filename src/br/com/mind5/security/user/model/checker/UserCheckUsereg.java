package br.com.mind5.security.user.model.checker;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.checker.UseregCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckUsereg extends ModelCheckerTemplateForward<UserInfo, UseregInfo> {
	
	public UserCheckUsereg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UseregInfo> getCheckerHook(ModelCheckerOption option) {
		return new UseregCheckExist(option);
	}
	
	
	
	@Override protected UseregInfo toForwardClass(UserInfo baseRecord) {
		return UseregInfo.copyFrom(baseRecord);
	}
}
