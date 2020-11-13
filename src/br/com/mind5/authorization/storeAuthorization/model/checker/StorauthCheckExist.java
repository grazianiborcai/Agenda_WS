package br.com.mind5.authorization.storeAuthorization.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.decisionTree.RootStorauthAuthorization;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorauthCheckExist extends ModelCheckerTemplateActionV2<StorauthInfo, StorauthInfo> {
	
	public StorauthCheckExist(ModelCheckerOption option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StorauthInfo> buildActionHook(DeciTreeOption<StorauthInfo> option) {
		ActionStdV2<StorauthInfo> select = new RootStorauthAuthorization(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_NOT_AUTHORIZED;
	}
}
