package br.com.mind5.business.orderList.model.checker;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class OrdistCheckUsername extends ModelCheckerTemplateForward<OrdistInfo, UsernameInfo> {
	
	public OrdistCheckUsername(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UsernameInfo> getCheckerHook(ModelCheckerOption option) {
		return new UsernameCheckExist(option);
	}
	
	
	
	@Override protected UsernameInfo toForwardClass(OrdistInfo baseRecord) {
		return UsernameInfo.copyFrom(baseRecord);
	}
}
