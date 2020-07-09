package br.com.mind5.authorization.customerAuthorization.model.action;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusauthSuccess extends ActionStdSuccessTemplate<CusauthInfo> {
	
	public StdCusauthSuccess(DeciTreeOption<CusauthInfo> option) {
		super(option);
	}
}
