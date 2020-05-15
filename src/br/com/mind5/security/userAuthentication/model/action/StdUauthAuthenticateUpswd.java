package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthAuthenticateUpswd extends ActionStdTemplateV2<UauthInfo> {

	public StdUauthAuthenticateUpswd(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UauthInfo> buildVisitorHook(DeciTreeOption<UauthInfo> option) {
		return new VisiUauthAuthenticateUpswd(option);
	}
}
