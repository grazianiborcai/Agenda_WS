package br.com.mind5.authorization.storeAuthorization.model.action;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorauthMergeSotarch extends ActionStdTemplateV2<StorauthInfo> {

	public StdStorauthMergeSotarch(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorauthInfo> buildVisitorHook(DeciTreeOption<StorauthInfo> option) {
		return new VisiStorauthMergeSotarch(option);
	}
}
