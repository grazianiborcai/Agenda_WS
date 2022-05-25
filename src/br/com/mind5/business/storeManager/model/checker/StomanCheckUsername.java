package br.com.mind5.business.storeManager.model.checker;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class StomanCheckUsername extends ModelCheckerTemplateForward<StomanInfo, UsernameInfo> {
	
	public StomanCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(StomanInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
