package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoreMergeSotarch extends ActionStdTemplateV2<StoreInfo> {

	public StdStoreMergeSotarch(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoreInfo> buildVisitorHook(DeciTreeOption<StoreInfo> option) {
		return new VisiStoreMergeSotarch(option);
	}
}
