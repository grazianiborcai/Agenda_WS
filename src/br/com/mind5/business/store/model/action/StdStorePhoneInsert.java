package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorePhoneInsert extends ActionStdTemplate<StoreInfo> {

	public StdStorePhoneInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoreInfo> buildVisitorHook(DeciTreeOption<StoreInfo> option) {
		return new VisiStorePhoneInsert(option);
	}
}
