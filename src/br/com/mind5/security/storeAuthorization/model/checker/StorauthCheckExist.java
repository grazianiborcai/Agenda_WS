package br.com.mind5.security.storeAuthorization.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.action.LazyStorauthDaoSelect;
import br.com.mind5.security.storeAuthorization.model.action.StdStorauthMergeUsername;

public final class StorauthCheckExist extends ModelCheckerTemplateActionV2<StorauthInfo, StorauthInfo> {
	
	public StorauthCheckExist(ModelCheckerOption option) {
		super(option, StorauthInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StorauthInfo> buildActionHook(DeciTreeOption<StorauthInfo> option) {
		ActionStdV1<StorauthInfo> mergeUsername = new StdStorauthMergeUsername(option);
		ActionLazyV1<StorauthInfo> select = new LazyStorauthDaoSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(select);
		
		return mergeUsername;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_NOT_AUTHORIZED;
	}
}
