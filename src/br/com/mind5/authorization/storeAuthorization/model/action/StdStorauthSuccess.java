package br.com.mind5.authorization.storeAuthorization.model.action;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorauthSuccess extends ActionStdSuccessTemplate<StorauthInfo> {
	public StdStorauthSuccess(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
}
