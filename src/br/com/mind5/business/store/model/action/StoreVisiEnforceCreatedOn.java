package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	public StoreVisiEnforceCreatedOn(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
