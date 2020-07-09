package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotauhEnforceStore extends ActionStdTemplateV2<SytotauhInfo> {

	public StdSytotauhEnforceStore(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SytotauhInfo> buildVisitorHook(DeciTreeOption<SytotauhInfo> option) {
		return new VisiSytotauhEnforceStore(option);
	}
}
