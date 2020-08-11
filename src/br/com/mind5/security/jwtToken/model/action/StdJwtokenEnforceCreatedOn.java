package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenEnforceCreatedOn extends ActionStdTemplateV2<JwtokenInfo> {

	public StdJwtokenEnforceCreatedOn(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<JwtokenInfo> buildVisitorHook(DeciTreeOption<JwtokenInfo> option) {
		return new VisiJwtokenEnforceCreatedOn(option);
	}
}
