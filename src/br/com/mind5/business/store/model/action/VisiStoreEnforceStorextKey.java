package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterStorextKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreEnforceStorextKey extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	public VisiStoreEnforceStorextKey(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterStorextKey();
		return attrSetter.setAttr(recordInfo);
	}
}
