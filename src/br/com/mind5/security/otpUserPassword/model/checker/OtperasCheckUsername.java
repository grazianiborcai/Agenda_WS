package br.com.mind5.security.otpUserPassword.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class OtperasCheckUsername extends ModelCheckerTemplateForward<OtperasInfo, UsernameInfo> {
	
	public OtperasCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(OtperasInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
