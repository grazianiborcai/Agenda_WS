package br.com.mind5.business.store.model.action;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreSetterAddressKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreEnforceAddressKey extends ActionVisitorTemplateEnforceV2<StoreInfo> {
	
	public VisiStoreEnforceAddressKey(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
