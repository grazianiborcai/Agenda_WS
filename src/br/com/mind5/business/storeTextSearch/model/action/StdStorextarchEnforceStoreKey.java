package br.com.mind5.business.storeTextSearch.model.action;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextarchEnforceStoreKey extends ActionStdTemplate<StorextarchInfo> {

	public StdStorextarchEnforceStoreKey(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorextarchInfo> buildVisitorHook(DeciTreeOption<StorextarchInfo> option) {
		return new VisiStorextarchEnforceStoreKey(option);
	}
}
