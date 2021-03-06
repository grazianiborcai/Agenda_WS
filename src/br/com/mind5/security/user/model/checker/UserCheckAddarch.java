package br.com.mind5.security.user.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckAddarch extends ModelCheckerTemplateForward<UserInfo, AddarchInfo> {
	
	public UserCheckAddarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddarchCheckExist(option);
	}
	
	
	
	@Override protected AddarchInfo toForwardClass(UserInfo baseRecord) {
		return AddarchCopier.copyFromUser(baseRecord);
	}
}
