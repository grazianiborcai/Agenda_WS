package br.com.mind5.authorization.storeAuthorization.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.decisionTree.StorauthRootAuthorization;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorauthCheckExist extends ModelCheckerTemplateAction<StorauthInfo, StorauthInfo> {
	
	public StorauthCheckExist(ModelCheckerOption option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorauthInfo> buildActionHook(DeciTreeOption<StorauthInfo> option) {
		ActionStd<StorauthInfo> select = new StorauthRootAuthorization(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_NOT_AUTHORIZED;
	}
}
