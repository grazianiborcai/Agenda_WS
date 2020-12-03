package br.com.mind5.discount.discountStoreSnapshot.model.action;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisorapDaoInsert extends ActionStdTemplate<DisorapInfo> {

	public StdDisorapDaoInsert(DeciTreeOption<DisorapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisorapInfo> buildVisitorHook(DeciTreeOption<DisorapInfo> option) {
		return new VisiDisorapDaoInsert(option);
	}
}
