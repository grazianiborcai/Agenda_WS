package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class PetCheckUser extends ModelCheckerTemplateForward<PetInfo, UserInfo> {
	
	public PetCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(PetInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
