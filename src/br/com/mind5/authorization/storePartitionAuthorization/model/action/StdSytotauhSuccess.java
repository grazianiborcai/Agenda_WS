package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotauhSuccess extends ActionStdSuccessTemplate<SytotauhInfo> {
	
	public StdSytotauhSuccess(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
}
