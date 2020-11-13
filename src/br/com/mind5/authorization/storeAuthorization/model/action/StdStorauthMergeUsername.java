package br.com.mind5.authorization.storeAuthorization.model.action;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorauthMergeUsername extends ActionStdTemplate<StorauthInfo> {

	public StdStorauthMergeUsername(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorauthInfo> buildVisitorHook(DeciTreeOption<StorauthInfo> option) {
		return new VisiStorauthMergeUsername(option);
	}
}
