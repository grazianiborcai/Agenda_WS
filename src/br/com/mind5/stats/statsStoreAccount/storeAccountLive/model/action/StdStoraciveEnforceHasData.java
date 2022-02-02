package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

public final class StdStoraciveEnforceHasData extends ActionStdTemplate<StoraciveInfo> {

	public StdStoraciveEnforceHasData(DeciTreeOption<StoraciveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoraciveInfo> buildVisitorHook(DeciTreeOption<StoraciveInfo> option) {
		return new VisiStoraciveEnforceHasData(option);
	}
}
