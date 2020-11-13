package br.com.mind5.security.tokenAuthentication.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class StdTauthMergeJwtoken extends ActionStdTemplate<TauthInfo> {

	public StdTauthMergeJwtoken(DeciTreeOption<TauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<TauthInfo> buildVisitorHook(DeciTreeOption<TauthInfo> option) {
		return new VisiTauthMergeJwtoken(option);
	}
}
