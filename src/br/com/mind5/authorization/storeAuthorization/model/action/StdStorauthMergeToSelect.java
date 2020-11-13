package br.com.mind5.authorization.storeAuthorization.model.action;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorauthMergeToSelect extends ActionStdTemplate<StorauthInfo> {

	public StdStorauthMergeToSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorauthInfo> buildVisitorHook(DeciTreeOption<StorauthInfo> option) {
		return new VisiStorauthMergeToSelect(option);
	}
}
