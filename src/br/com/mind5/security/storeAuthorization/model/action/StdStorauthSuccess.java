package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthSuccess extends ActionStdSuccessTemplate<StorauthInfo> {
	public StdStorauthSuccess(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
}
