package br.com.gda.business.store.model.action;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreSetterAddressKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiStoreEnforceAddressKey extends ActionVisitorTemplateEnforce<StoreInfo> {
	
	@Override protected StoreInfo enforceHook(StoreInfo recordInfo) {
		InfoSetter<StoreInfo> attrSetter = new StoreSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
