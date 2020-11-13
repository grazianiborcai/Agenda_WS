package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhAuth;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotauhCheckExist extends ModelCheckerTemplateAction<SytotauhInfo, SytotauhInfo> {
	
	public SytotauhCheckExist(ModelCheckerOption option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected ActionStd<SytotauhInfo> buildActionHook(DeciTreeOption<SytotauhInfo> option) {
		ActionStd<SytotauhInfo> select = new RootSytotauhAuth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_PART_AUTH_AUTHORIZED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PART_AUTH_NOT_AUTHORIZED;
	}
}
