package br.com.mind5.authorization.customerAuthorization.model.action;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusauthMergeStorauth extends ActionStdTemplateV2<CusauthInfo> {

	public StdCusauthMergeStorauth(DeciTreeOption<CusauthInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusauthInfo> buildVisitorHook(DeciTreeOption<CusauthInfo> option) {
		return new VisiCusauthMergeStorauth(option);
	}
}
