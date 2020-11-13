package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class StdJwtokenEnforceToken extends ActionStdTemplate<JwtokenInfo> {

	public StdJwtokenEnforceToken(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<JwtokenInfo> buildVisitorHook(DeciTreeOption<JwtokenInfo> option) {
		return new VisiJwtokenEnforceToken(option);
	}
}
