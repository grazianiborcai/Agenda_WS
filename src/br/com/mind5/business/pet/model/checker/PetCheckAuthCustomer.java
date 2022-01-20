package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistCustomer;

public final class PetCheckAuthCustomer extends ModelCheckerTemplateForward<PetInfo, UserarchInfo> {
	
	public PetCheckAuthCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistCustomer(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(PetInfo baseRecord) {
		return UserarchInfo.copyFrom(baseRecord);
	}
}
