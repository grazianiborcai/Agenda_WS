package br.com.mind5.security.storeAuthorization.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.decisionTree.RootStorauthSelect;

public final class StorauthCheckExist extends ModelCheckerTemplateAction<StorauthInfo, StorauthInfo> {
	
	public StorauthCheckExist(ModelCheckerOption option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected ActionStd<StorauthInfo> buildActionHook(DeciTreeOption<StorauthInfo> option) {
		return new RootStorauthSelect(option).toAction();
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_NOT_AUTHORIZED;
	}
}
