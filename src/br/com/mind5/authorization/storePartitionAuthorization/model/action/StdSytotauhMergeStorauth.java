package br.com.mind5.authorization.storePartitionAuthorization.model.action;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotauhMergeStorauth extends ActionStdTemplate<SytotauhInfo> {

	public StdSytotauhMergeStorauth(DeciTreeOption<SytotauhInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SytotauhInfo> buildVisitorHook(DeciTreeOption<SytotauhInfo> option) {
		return new VisiSytotauhMergeStorauth(option);
	}
}
