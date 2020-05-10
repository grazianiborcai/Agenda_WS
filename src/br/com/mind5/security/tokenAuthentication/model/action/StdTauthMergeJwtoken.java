package br.com.mind5.security.tokenAuthentication.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class StdTauthMergeJwtoken extends ActionStdTemplateV2<TauthInfo> {

	public StdTauthMergeJwtoken(DeciTreeOption<TauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<TauthInfo> buildVisitorHook(DeciTreeOption<TauthInfo> option) {
		return new VisiTauthMergeJwtoken(option);
	}
}
