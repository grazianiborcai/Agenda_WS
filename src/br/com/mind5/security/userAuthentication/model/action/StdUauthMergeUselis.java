package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class StdUauthMergeUselis extends ActionStdTemplate<UauthInfo> {

	public StdUauthMergeUselis(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UauthInfo> buildVisitorHook(DeciTreeOption<UauthInfo> option) {
		return new VisiUauthMergeUselis(option);
	}
}
