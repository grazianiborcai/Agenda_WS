package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhAuth;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotauhCheckExist extends ModelCheckerTemplateActionV2<SytotauhInfo, SytotauhInfo> {
	
	public SytotauhCheckExist(ModelCheckerOption option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<SytotauhInfo> buildActionHook(DeciTreeOption<SytotauhInfo> option) {
		ActionStdV2<SytotauhInfo> select = new RootSytotauhAuth(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_PART_AUTH_AUTHORIZED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PART_AUTH_NOT_AUTHORIZED;
	}
}
