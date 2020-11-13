package br.com.mind5.security.userPasswordSearch.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class UpswdarchCheckUsername extends ModelCheckerTemplateForward<UpswdarchInfo, UsernameInfo> {
	
	public UpswdarchCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(UpswdarchInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
