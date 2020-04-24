package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthDaoSelect extends ActionStdTemplateV2<StorauthInfo> {

	public StdStorauthDaoSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorauthInfo> buildVisitorHook(DeciTreeOption<StorauthInfo> option) {
		return new VisiStorauthDaoSelect(option);
	}
}