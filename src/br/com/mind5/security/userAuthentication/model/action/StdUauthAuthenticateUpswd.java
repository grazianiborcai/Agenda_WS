package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthAuthenticateUpswd extends ActionStdTemplate<UauthInfo> {

	public StdUauthAuthenticateUpswd(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UauthInfo> buildVisitorHook(DeciTreeOption<UauthInfo> option) {
		return new VisiUauthAuthenticateUpswd(option);
	}
}
