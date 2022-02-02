package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;

public final class StdStoracMergeStoracive extends ActionStdTemplate<StoracInfo> {

	public StdStoracMergeStoracive(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoracInfo> buildVisitorHook(DeciTreeOption<StoracInfo> option) {
		return new VisiStoracMergeStoracive(option);
	}
}
